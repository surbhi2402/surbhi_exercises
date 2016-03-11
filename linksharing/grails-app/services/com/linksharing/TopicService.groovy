package com.linksharing

import com.link.sharing.core.Resource
import com.link.sharing.core.Topic
import com.ttnd.linksharing.Co.ResourceSearchCo
import com.ttnd.linksharing.Co.TopicSearchCO
import grails.transaction.Transactional

@Transactional
class TopicService {

    def serviceMethod() {

    }

    def search(TopicSearchCO topicSearchCO) {
          List<Topic> topics=  Topic.findAllByCreatedByAndVisibility(topicSearchCO.getUser(),topicSearchCO.visibility)
     return topics
    }
}
