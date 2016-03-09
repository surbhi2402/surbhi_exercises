package com.linksharing

import com.link.sharing.core.Subscription
import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Co.ResourceSearchCo
import com.ttnd.linksharing.Enum.Seriousness
import com.ttnd.linksharing.Enum.Visibility
import com.ttnd.linksharing.Vo.TopicVo

class TopicController {

    def index() {
        render(view: '/topic/searchPage')
    }

    def show(ResourceSearchCo resourceSearchCo) {
        def topic
        topic = Topic.read(resourceSearchCo?.topicId)
        if (!topic) {
            redirect(controller: "user", action: "index")
            flash.error = "No topic in database"
        } else {
            if (Visibility.PUBLIC) {
                render(view: '/topic/displayTopic', model: [topic: topic, subscribedUsers: topic.subscribedUsers])
            } else if (Visibility.PRIVATE) {
                User user1 = User.findByUsername(session.user)
                def subscription = Subscription.findAllByUserAndTopic(user1, topic)
                if (!subscription) {
                    redirect(controller: 'login', action: 'index')
                    flash.message = "Subscription does not exists."
                } else {
                    render "Success"
                }
            } else {
                render "Topic not available!"
            }
        }
    }

    def save(String name, String visibility) {
//        println "***inside save of topic"
        Topic topic = new Topic(name: name, createdBy: session.user, visibility: Visibility.convert(visibility))
        if (topic.validate()) {
            topic.save(flush: true)
            flash.message = "Success"
            render flash.message
        } else {
            log.error(" Could not save Topic ${topic.name}")
            flash.message = "Topic ${topic.name} does not satisfied constraints"
            render flash.message
        }
    }

}
