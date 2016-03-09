package com.linksharing

import com.link.sharing.core.ReadingItem
import com.link.sharing.core.Resource
import com.link.sharing.core.ResourceRating
import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Co.UserCo
import com.ttnd.linksharing.Vo.PostVO
import com.ttnd.linksharing.Vo.TopicVo
import com.ttnd.linksharing.Vo.UserVO

class UserController {

    def userService
    def assetResourceLocator
    def saving() {
        if (userService.save())
            render "success"
        else
            render "failed"
    }


    def index() {
        User user = session.user
        UserVO userDetails = user.getUserDetails()
        List<PostVO> readingItems = ReadingItem.getInboxItems(user)
        render(view: 'dashboard', model: [subscribeTopics: user.subscribeTopics,readingItemList: readingItems,userDetails:userDetails])
    }


    def register(UserCo userCo) {

        User user = new User()
        user.properties = userCo.properties
        user.validate()
        if(user?.hasErrors()){
            render view: '/login/home' , model:[user:userCo]
        }
        else  {
            user.save(flush: true, failOnError: true)
            flash.message = "Successful registration"
            render flash.message
        }
    }

    def forgotPassword() {
        render(view: '/user/forgotPassword')
    }

    def getScore(Long resourceId, Integer score) {
        User user = session.user
        Integer value = ResourceRating.executeUpdate("update ResourceRating r set r.score=:score where r.resource.id=:resourceId and r.user.id = :userId", [score:score,resourceId:resourceId,userId: user.id])

        render value
    }

    def image(Long id){
        User user = User.get(id)
        def photo
        if(user.photo){
            photo = user.photo
        }else {
            photo = assetResourceLocator.findAssetForURI('dummy.png').getInputStream().getBytes()
        }
        response.outputStream << photo
        response.outputStream.flush()
    }
}
