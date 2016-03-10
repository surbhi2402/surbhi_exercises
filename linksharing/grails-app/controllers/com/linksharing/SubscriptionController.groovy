package com.linksharing

import com.link.sharing.core.ReadingItem
import com.link.sharing.core.Subscription
import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Enum.Seriousness
import com.ttnd.linksharing.Vo.PostVO
import com.ttnd.linksharing.Vo.TopicVo
import grails.converters.JSON

class SubscriptionController {

//    static transactional = false

    def index() {}

    def delete(Long topicId) {
        Map jsonResponseMap = [:]
        User user = session.user
        if (user.isSubscribed(topicId)) {
            Topic topic = Topic.get(topicId)
//            if(user.equals(session.user.id)){}
            Subscription subscription = Subscription.findByUserAndTopic(user, topic)
            subscription.delete(flush: true)
            jsonResponseMap.message = "subscription deleted!!"
            redirect(controller: 'user', action: 'index')
        } else {
            flash.error = "subscription not found!"
            jsonResponseMap.error = "Subscription not found!!"
        }
        JSON jsonResponse = jsonResponseMap as JSON
        render jsonResponse
    }

    def save(Long id) {
        User user = session.user
        Topic topic = Topic.get(id)
        Subscription subscription1 = Subscription.findByUserAndTopic(user, topic)
        if (!subscription1) {
            Subscription subscription = new Subscription(topic: topic, user: session.user, seriousness: Seriousness.SERIOUS)
            if (subscription.save(flush: true)) {
                List<PostVO> readingItems = ReadingItem.getInboxItems(user)
                render(view: '/user/dashboard', model: [subscribeTopics: user.subscribeTopics, readingItemList: readingItems])
            } else {
                flash.error = "Subscription not saved"
            }
        }
    }

    def update(Long topicId, String seriousness) {
        println "inside updating"
//        User user = session.user
        Map jsonResponseMap = [:]

        // Subscription subscription = Subscription.findByUserAndTopic(user, topic)
        seriousness = Seriousness.convert(seriousness)
        //Seriousness seriousness = Seriousness.getBySeriousness()

        Subscription subscription = Subscription.findByIdAndSeriousness(topicId, seriousness)
        if (subscription) {
            subscription.save(flush: true)
            jsonResponseMap.message = "subscription found and updated successfully"
        } else {
            jsonResponseMap.error = "failure in saving subscription"
        }
        jsonResponseMap as JSON
    }

}