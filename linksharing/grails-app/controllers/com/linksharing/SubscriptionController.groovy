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
        println "==topicId-->>>${topicId}"
        Map jsonResponseMap = [:]
        Topic topic = Topic.get(topicId)
        println "===${topic.createdBy}"
        User user = session.user
        if (user.isSubscribed(topicId)) {

            Subscription subscription = Subscription.findByUserAndTopic(user, topic)
            subscription.delete(flush: true)
            jsonResponseMap.message = "subscription deleted!!"
            //redirect(controller: 'user', action: 'index')
        }
        else  if(user.equals(topic.createdBy)) {
            println "inside if user is created by of topic"
            flash.error = "you cannot unsubscribe from topic!"
        }
        else{
            flash.error = "subscription not found!"
            jsonResponseMap.error = "Subscription not found!!"
        }
        JSON jsonResponse = jsonResponseMap as JSON
        render jsonResponse
    }

    def save(Long id) {
        User user = session.user
        Topic topic = Topic.get(id)
        Map jsonResponseMap = [:]
        Subscription subscription1 = Subscription.findByUserAndTopic(user, topic)
        if (!subscription1) {
            Subscription subscription = new Subscription(topic: topic, user: session.user, seriousness: Seriousness.SERIOUS)
            if (subscription.save(flush: true)) {
                List<PostVO> readingItems = ReadingItem.getInboxItems(user)
//                render(view: '/user/dashboard', model: [subscribeTopics: user.subscribeTopics, readingItemList: readingItems])
              jsonResponseMap.message = "Subscription Saved Sucessfully!"
            } else {
                jsonResponseMap.error = "Subscription not saved"
            }
        }
        render jsonResponseMap as JSON
    }

    def update(Integer id, String serious) {
        Subscription subscription = Subscription.get(id)

        Seriousness seriousness = Seriousness.getSeriousness(serious)

        Map jsonResponseMap = [:]
        if (subscription && seriousness) {
            subscription.seriousness = seriousness

            if (subscription.validate() && subscription.save(flush: true, failOnError: true))
                jsonResponseMap.message = "Subscription ${subscription} saved successfully"
            else
                jsonResponseMap.error = "Subscription ${subscription} could not be saved"
        } else {
            jsonResponseMap.error = "Subscription with id ${id} could not be found."
        }
        JSON jsonResponse = jsonResponseMap as JSON
        render jsonResponse
    }

}