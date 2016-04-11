package com.linksharing

import com.link.sharing.core.ReadingItem
import com.link.sharing.core.Resource
import com.link.sharing.core.ResourceRating
import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Co.ResourceSearchCo
import com.ttnd.linksharing.Co.TopicSearchCO
import com.ttnd.linksharing.Co.UpdatePasswordCO
import com.ttnd.linksharing.Co.UserCo
import com.ttnd.linksharing.Co.UserSearchCO
import com.ttnd.linksharing.DTO.EmailDTO
import com.ttnd.linksharing.Enum.Visibility
import com.ttnd.linksharing.Util
import com.ttnd.linksharing.Vo.PostVO
import com.ttnd.linksharing.Vo.TopicVo
import com.ttnd.linksharing.Vo.UserVO
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class UserController {

    def userService
    def assetResourceLocator
    def subscriptionService
    def resourceService
    def topicService
    def emailService
    def springSecurityService



    static defaultAction = "index"

    def saving() {
        if (userService.save())
            render "success"
        else
            render "failed"
    }


    def index() {
        println "---------Inside user index--------"
        if (springSecurityService.isLoggedIn()) {
            println "---------Inside user index if--------"
            User user = session.user = User.read(springSecurityService.currentUserId as Long)
            springSecurityService.reauthenticate(user.username)
            UserVO userDetails = user.getUserDetails()
            List<PostVO> readingItems = ReadingItem.getInboxItems(user)

            flash.message = "Login successful..!!"
            render(view: '/user/dashboard', model: [subscribeTopics: user.subscribeTopics,readingItemList:readingItems, userDetails: userDetails])
        } else {
            println "---------Inside user index else--------"
            flash.error = "Unsuccessful Login..!!"
            redirect(controller: 'login', action: 'index')
        }
    }

//    def index() {
//        User user = session.user
//        UserVO userDetails = user.getUserDetails()
//        List<PostVO> readingItems = ReadingItem.getInboxItems(user)
//        render(view: '/user/dashboard', model: [subscribeTopics: user.subscribeTopics, readingItemList: readingItems, userDetails: userDetails])
//    }


    def register(UserCo userCo) {

        User user = new User()
        user.properties = userCo.properties
        if (params.pic&&!params.pic.empty) {
            user.photo = params.pic.bytes
        }
        user.validate()
        if (!user?.hasErrors()) {
            user.save(flush: true, failOnError: true)
            flash.message = "User registered successfully"
            session.user = user
            UserVO userDetails = user.getUserDetails()
            render(view: '/user/dashboard', model: [userDetails: userDetails])
        } else {
            List<Resource> recentShares = Resource.list([sort: 'dateCreated', order: 'desc', max: 2])
            render view: '/login/home', model: [recentShares: recentShares, user: userCo]
        }
    }

    def forgotPassword(String email) {
        User user = User.findByEmail(email)
        if (user && user.active) {
            String newPassword = Util.getRandomPassword()
            user.password = newPassword
            EmailDTO emailDTO = new EmailDTO(to: [email], subject: "Your Link sharing New Password", view: '/user/_newPassword', model: [newPassword: newPassword])
            emailService.sendMail(emailDTO)
            if (User.updatePassword(newPassword, email)) {
                flash.message = "${user.password}If your Email id is valid and you are active user then you will get your new password via mail"
            } else {
                flash.error = "Please try again"
            }
//            redirect(controller: "login", action: "index")
            render "----"
        }
//        redirect(controller: "login", action: "index")
        render "---"
    }

    def getScore(Long resourceId, Integer score) {
        User user = session.user
        Integer value = ResourceRating.executeUpdate("update ResourceRating r set r.score=:score where r.resource.id=:resourceId and r.user.id = :userId", [score: score, resourceId: resourceId, userId: user.id])

        render value
    }

    def image(Long id) {
        User user = User.get(id)
        byte[] photo
        if (user.photo) {
            photo = user.photo
        } else {
            photo = assetResourceLocator.findAssetForURI('dummy.png').byteArray
        }
        response.outputStream << photo
        response.outputStream.flush()
    }

    def profile(ResourceSearchCo resourceSearchCo) {
        User user = session.user
        TopicSearchCO topicSearchCO = new TopicSearchCO(id: resourceSearchCo.id, visibility: resourceSearchCo.visibility)
        List<Topic> topicsCreated = topicService.search(topicSearchCO)
        List<Topic> subscribedTopics = subscriptionService.search(topicSearchCO)
        List<Resource> posts = resourceService.search(resourceSearchCo)
        UserVO userDetails = user.getUserDetails()
        render(view: '/user/profile', model: [topicsCreated: topicsCreated, subscribedTopics: subscribedTopics, posts: posts, userDetails: userDetails])

    }

    def list(UserSearchCO userSearchCO) {
        List<UserVO> userVOList = []
        if (session.user?.admin) {
            User.search(userSearchCO).list([sort: userSearchCO.sort, order: userSearchCO.order,max:1,offset:0]).each { user ->
                userVOList.add(new UserVO(id: user.id, username: user.username, email: user.email, fname: user.firstName,
                        lname: user.lastName, isActive: user.active))
            }
            render(view: 'list', model: [users: userVOList,total:userVOList.size(),max:2,offset:0,userSearchCO:userSearchCO ])
        } else {
            redirect(controller: 'login', action: 'index')
        }
    }

    def privateProfile(ResourceSearchCo resourceSearchCo) {
        User user = session.user
        List<Topic> topicsCreated = Topic.findAllByCreatedBy(user)

        UserVO userDetails = user.getUserDetails()
        render(view: '/user/privateProfile', model: [userDetails: userDetails, topicsCreated: topicsCreated])
    }

    def changePasswordOfUser(String newPassword, String confirmUserPassword) {
        User user = session.user
        if (newPassword == confirmUserPassword) {
            if (User.executeUpdate("update User as u set password=:newPassword where id=:id", [newPassword: newPassword, id: user.id])) {
                render "succesfully change password!!"
                session.invalidate()
            }
        }
    }

    def modifyUserProfile(String firstName, String lastName, String userName) {
        User user = session.user
        if (User.executeUpdate("update User as u set firstName=:fname,lastName=:lname,username=:uname where id=:id", [fname: firstName, lname: lastName, uname: userName, id: user.id])) {
            redirect(controller: "login", action: "index")
        } else {
            render "Could not register you!"
        }

        if (!params.pic.empty) {
            user.photo = params.pic.bytes
            user.save(flush: true)
            render "picc uploadeddd too!!"
        }
    }

    def updatePassword(UpdatePasswordCO updatePasswordCO) {
        User user = updatePasswordCO.getUser()
        Map jsonResponseMap = [:]
        if (user.password == updatePasswordCO.oldPassword) {
            user.password = updatePasswordCO.password
            user.confirmPassword = updatePasswordCO.password
            if (user.save(flush: true)) {
//                jsonResponseMap.message = "Password Updated Successfully"
//                render "password updated successfully through CO"
                redirect(controller: "login", action: "index")
            } else {
//                jsonResponseMap.error = "Password Could not be updated!"
                render "password could not be updated!"
            }
        }
//                render jsonResponseMap as JSON
    }


    def toggleActive(Long id) {
        User user = User.get(id)

        if (user && (!user.admin)) {
            user.active = !user.active
            user.confirmPassword = user.password
            if (user.save(flush: true)) {
                flash.message = g.message(code: "com.linksharing.User.controller.toggle.active.success")
            } else {
                flash.error = g.message(code: "com.linksharing.User.controller.toggle.active.fail")
            }
        } else {
            flash.error = g.message(code: "com.linksharing.User.controller.toggle.active.fail")
        }
        redirect(controller: 'user', action: "list")

    }

    def subscriptions(Long id) {
        TopicSearchCO topicSearchCO = new TopicSearchCO(id: id)
        User currentUser = session.user
        if (currentUser) {
            if (!(currentUser.admin || currentUser.id == id)) {
                topicSearchCO.visibility = Visibility.PUBLIC
            }
        } else
            topicSearchCO.visibility = Visibility.PUBLIC

        List subscribedTopics = subscriptionService.search(topicSearchCO)
        render(view: '/topic/list', model: [topics: subscribedTopics])

    }


    def topics(Long id) {
        TopicSearchCO topicSearchCO = new TopicSearchCO(id: id)
        User currentUser = session.user
        if (currentUser) {
            if (!(currentUser.admin || currentUser.id == id)) {
                topicSearchCO.visibility = null
            } else {
                topicSearchCO.visibility = Visibility.PUBLIC
            }
        }
        List topicsCreated = subscriptionService.search(topicSearchCO)
        render(view: '/topic/list', model: [topics: topicsCreated])
    }
}
