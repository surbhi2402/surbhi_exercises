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
            render(view: '/user/dashboard', model: [subscribeTopics: user.subscribeTopics, readingItemList: readingItems, userDetails: userDetails])
        } else {
            render "Resource does not exists"
        }
    }

    def search(ResourceSearchCo co) {
        User user = session.user
        if (co.q) {
            co.visibility = Visibility.PUBLIC
        }
        UserVO userDetails = user.getUserDetails()
        List<Resource> resources = Resource.search(co).list()
        render(view: '/resource/searchPage',model: [userDetails: userDetails,resources:resources])
    }

//           Resource resource = Resource.findById(id)
//        RatingInfoVo ratingInfoVo = resource.ratingInfo
//        render "****total votes: $ratingInfoVo.totalVotes*****average: $ratingInfoVo.averageScore***total: $ratingInfoVo.totalScore"

    def viewPost(Long id) {
        User user = session.user
        List<PostVO> readingItems = ReadingItem.getInboxItems(user)
        Resource resource = Resource.read(id)
        UserVO userDetails = user.getUserDetails()
        if (Resource.canViewBy(user, id)) {
            render(view: '/resource/resourceSearch', model: [readingItemList: readingItems, resource: resource, userDetails: userDetails])
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
                        readingItem.save(flush: true)
                    } else {
                        ReadingItem readingItem = new ReadingItem(isRead: false, user: user, resource: resource)
                        user.addToReadingItems(readingItem)
                        readingItem.save(flush: true)
                    }

                }
        }

    }

}

