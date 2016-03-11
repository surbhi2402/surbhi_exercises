package com.linksharing

import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Co.TopicSearchCO
import grails.transaction.Transactional

@Transactional
class SubscriptionService {

    Long id
    User getUser(){
        return User.findById(id)
    }
    def serviceMethod() {

    }

    def search(TopicSearchCO topicSearchCO){
        return topicSearchCO.getUser().getSubscribeTopics()

    }
}
