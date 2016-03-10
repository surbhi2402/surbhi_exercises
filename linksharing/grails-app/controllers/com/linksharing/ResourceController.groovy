package com.linksharing

import com.link.sharing.core.LinkResource
import com.link.sharing.core.ReadingItem
import com.link.sharing.core.Resource
import com.link.sharing.core.ResourceRating
import com.link.sharing.core.Subscription
import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Co.ResourceSearchCo
import com.ttnd.linksharing.Enum.Visibility
import com.ttnd.linksharing.Vo.PostVO
import com.ttnd.linksharing.Vo.RatingInfoVo
import com.ttnd.linksharing.Vo.TopicVo
import com.ttnd.linksharing.Vo.UserVO

class ResourceController {

    def index() {
        render(view: 'resourceSearch')
    }

    def delete(Long id) {
        User user = session.user
        if (user.canDeleteResource(id)) {
            Resource resource = Resource.get(id)
            resource.delete(flush: true)
            UserVO userDetails = user.getUserDetails()
            List<PostVO> readingItems = ReadingItem.getInboxItems(session.user)
            render(view: '/user/dashboard', model: [subscribeTopics: user.subscribeTopics,readingItemList: readingItems,userDetails:userDetails])
        } else {
            render "Resource does not exists"
        }
    }

    def search(ResourceSearchCo co) {
        if (co.q) {
            co.visibility = Visibility.PUBLIC
        }
        List<Resource> resources = Resource.search(co).list()
        render resources
    }

//           Resource resource = Resource.findById(id)
//        RatingInfoVo ratingInfoVo = resource.ratingInfo
//        render "****total votes: $ratingInfoVo.totalVotes*****average: $ratingInfoVo.averageScore***total: $ratingInfoVo.totalScore"

    def viewPost(Long id) {
        User user = session.user
        List<PostVO> readingItems = ReadingItem.getInboxItems(user)
        Resource resource = Resource.read(id)
        println "=====resource is-->>>>>>>>${resource}===="
        println "=====resource Id is ---- >>>>${resource.id}===="
        if (Resource.canViewBy(user, id)) {
            println "inside can viewwww by----->>>>>"
            render(view: '/resource/resourceSearch', model: [readingItemList: readingItems, resource: resource])
        } else {
            render "you cannot view this resource"
        }
    }


    private def addToReadingItems(Resource resource) {

        Topic topic = resource.topic
        List userList = topic.getSubscribedUsers()

        userList.each {
            User user ->
                if (Subscription.findByUserAndTopic(user, topic)) {
                    if (resource.createdBy.id == user.id) {
                        ReadingItem readingItem = new ReadingItem(isRead: true, user: user, resource: resource)
                        user.addToReadingItems(readingItem)
                    } else {
                        ReadingItem readingItem = new ReadingItem(isRead: false, user: user, resource: resource)
                        user.addToReadingItems(readingItem)
                    }
                }
        }

    }

}

