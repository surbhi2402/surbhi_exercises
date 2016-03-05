package com.linksharing

import com.link.sharing.core.LinkResource
import com.link.sharing.core.ReadingItem
import com.link.sharing.core.Resource
import com.link.sharing.core.ResourceRating
import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Co.ResourceSearchCo
import com.ttnd.linksharing.Enum.Visibility
import com.ttnd.linksharing.Vo.PostVO
import com.ttnd.linksharing.Vo.RatingInfoVo
import com.ttnd.linksharing.Vo.TopicVo

class ResourceController {

    def index() {
//        render "Inside resource!"
        List<TopicVo> trendingTopics = Topic.getTrendingTopics()
        render (view: 'resourceSearch',model: [trendingTopics: trendingTopics])
    }

    def delete(Long id) {
        Resource resource = Resource.get(id)
        if (!resource) {
            render "Resource does not exists"
        } else {
            resource.delete(flush: true)
            List<TopicVo> trendingTopics = Topic.getTrendingTopics()
            List<PostVO> readingItems =ReadingItem.getInboxItems(session.user)
            render(view: '/user/dashboard',model: [trendingTopics:trendingTopics,readingItemList:readingItems])
            //flash.message= "Resource deleted successfully!"
            //render flash.message
        }
    }

    def search(ResourceSearchCo co) {
        if (co.q) {
            co.visibility = Visibility.PUBLIC
        }
        List<Resource> resources = Resource.search(co).list()
        render resources
    }

    def show(Long id) {
        User user = session.user
        List<TopicVo> trendingTopics = Topic.getTrendingTopics()
        List<PostVO> readingItems =ReadingItem.getInboxItems(user)
        Resource resource = Resource.read(id)
        if(Resource.canViewBy(user,id)){
        render(view: '/resource/resourceSearch',model: [trendingTopics: trendingTopics,readingItemList:readingItems,resource:resource])
        }
        else {
            render "you cannot view this resource"
        }
//        Resource resource = Resource.findById(id)
//        RatingInfoVo ratingInfoVo = resource.ratingInfo
//        render "****total votes: $ratingInfoVo.totalVotes*****average: $ratingInfoVo.averageScore***total: $ratingInfoVo.totalScore"
    }

//     def showTopics() {
//        List<TopicVo> topicVoList = Topic.getTrendingTopics()
//        render(template: "/topic/showTopic", model: [topicVoList: topicVoList])
//
//    }

    def viewPost(Long id){
        User user = session.user
        List<TopicVo> trendingTopics = Topic.getTrendingTopics()
        List<PostVO> readingItems =ReadingItem.getInboxItems(user)
        Resource resource = Resource.read(id)
//        println "=====${resource}===="
//        println "=====${resource.id}===="
        render(view: '/resource/resourceSearch',model: [trendingTopics: trendingTopics,readingItemList:readingItems,resource:resource])
    }
}

