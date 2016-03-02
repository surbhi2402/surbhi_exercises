package com.linksharing

import com.link.sharing.core.Resource
import com.link.sharing.core.ResourceRating
import com.link.sharing.core.Topic
import com.ttnd.linksharing.Co.ResourceSearchCo
import com.ttnd.linksharing.Enum.Visibility
import com.ttnd.linksharing.Vo.RatingInfoVo
import com.ttnd.linksharing.Vo.TopicVo

class ResourceController {

    def index() {
        render "Inside resource!"
    }

    def delete(Long id) {
        Resource resource = Resource.get(id)
        if (!resource) {
            render "Resource does not exists"
        } else {
            resource.delete(flush: true)
            render "Resource deleted successfully!"
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
        Resource resource = Resource.findById(id)

        RatingInfoVo ratingInfoVo = resource.ratingInfo

        render "****total votes: $ratingInfoVo.totalVotes*****average: $ratingInfoVo.averageScore***total: $ratingInfoVo.totalScore"
    }

//     def showTopics() {
//        List<TopicVo> topicVoList = Topic.getTrendingTopics()
//        render(template: "/topic/showTopic", model: [topicVoList: topicVoList])
//
//    }
}
