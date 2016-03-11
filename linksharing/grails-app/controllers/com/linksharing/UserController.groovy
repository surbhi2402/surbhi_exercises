package com.linksharing

import com.link.sharing.core.ReadingItem
import com.link.sharing.core.Resource
import com.link.sharing.core.ResourceRating
import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Co.ResourceSearchCo
import com.ttnd.linksharing.Co.TopicSearchCO
import com.ttnd.linksharing.Co.UserCo
import com.ttnd.linksharing.Enum.Visibility
import com.ttnd.linksharing.Vo.PostVO
import com.ttnd.linksharing.Vo.TopicVo
import com.ttnd.linksharing.Vo.UserVO
import org.xhtmlrenderer.css.parser.property.PrimitivePropertyBuilders

class UserController {

    def userService
    def assetResourceLocator
    def subscriptionService
    def resourceService
    def topicService
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
        render(view: '/user/dashboard', model: [subscribeTopics: user.subscribeTopics,readingItemList: readingItems,userDetails:userDetails])
    }


    def register(UserCo userCo) {

        User user = new User()
        user.properties = userCo.properties
        if(!params.pic.empty){
            user.photo = params.pic.bytes
        }
        user.validate()
        if(user?.hasErrors()){
            List<Resource> recentShares = Resource.list([sort: 'dateCreated', order: 'desc', max: 2])
            render view: '/login/home' , model:[recentShares:recentShares,user:userCo]
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
        byte[] photo
        if(user.photo){
            photo = user.photo
        }else {
            photo = assetResourceLocator.findAssetForURI('dummy.png').byteArray
        }
        response.outputStream << photo
        response.outputStream.flush()
    }

    def profile(ResourceSearchCo resourceSearchCo){
        User user = session.user
            TopicSearchCO topicSearchCO=new TopicSearchCO(id: resourceSearchCo.id,visibility: resourceSearchCo.visibility)
            List<Topic> topicsCreated =topicService.search(topicSearchCO)
            List<Topic> subscribedTopics=subscriptionService.search(topicSearchCO)
            List<Resource> posts=resourceService.search(resourceSearchCo)
        UserVO userDetails = user.getUserDetails()
            render(view: '/user/profile', model: [topicsCreated:topicsCreated,subscribedTopics: subscribedTopics,posts:posts,userDetails: userDetails])

    }


}
