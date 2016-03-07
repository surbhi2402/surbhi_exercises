package com.linksharing

import com.link.sharing.core.ReadingItem
import com.link.sharing.core.Subscription
import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Enum.Seriousness
import com.ttnd.linksharing.Vo.PostVO
import com.ttnd.linksharing.Vo.TopicVo

class SubscriptionController {

//    static transactional = false

    def index() {}

    def delete(Long id) {
        User user = session.user
//        Subscription subscription
        if (User.isSubscribed(user, id)) {
            Topic topic = Topic.get(id)
            Subscription subscription = Subscription.findByUserAndTopic(user, topic)
            subscription.delete(flush: true)
            List<TopicVo> trendingTopics = Topic.getTrendingTopics()
            List<PostVO> readingItems = ReadingItem.getInboxItems(user)
            render(view: '/user/dashboard', model: [subscribeTopics: user.subscribeTopics, trendingTopics: trendingTopics, readingItemList: readingItems])
//            render view: '/user/dashboard'
        } else {
            render "Subscription not found!!"
        }
    }

    def save(Long id) {
        User user = session.user
        Topic topic = Topic.get(id)
        Subscription subscription1 = Subscription.findByUserAndTopic(user, topic)
        println "======${topic}"
        println "Subscription -- >>> ${subscription1}"
        if (!subscription1) {
            Subscription subscription = new Subscription(topic: topic, user: session.user, seriousness: Seriousness.SERIOUS)
            if (subscription.save(flush: true)) {
                List<TopicVo> trendingTopics = Topic.getTrendingTopics()
                List<PostVO> readingItems = ReadingItem.getInboxItems(user)
//                render(view: 'dashboard', model: [subscribeTopics: user.subscribeTopics, trendingTopics: trendingTopics, readingItemList: readingItems])

                render(view: '/user/dashboard')
//                render "Successfullyy subscribed!!"
            } else {
                render "Subscription not saved"
            }
        }
    }

    def update(Long id, String seriousness) {
        println "inside updating"
        seriousness = Seriousness.convert(seriousness)
        Subscription subscription = Subscription.findByIdAndSeriousness(id, seriousness)
        if (subscription) {
            subscription.save(flush: true)
            render "subscription found and updated successfully"
        } else {
            render "failure in saving subscription"
        }
    }
}