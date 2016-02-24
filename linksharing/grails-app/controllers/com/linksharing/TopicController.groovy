package com.linksharing

import com.link.sharing.core.Subscription
import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Co.ResourceSearchCo
import com.ttnd.linksharing.Enum.Seriousness
import com.ttnd.linksharing.Enum.Visibility

class TopicController {

    def index() {

        render "inside index"
    }
    def show(Long id,ResourceSearchCo resourceSearchCo) {
        println "under show"
        def topic
        topic = Topic.get(id)

        if(!topic){
            redirect(controller: "user", action: "index")
            flash.error = "No topic in database"
        }
        else {
            if(Visibility.PUBLIC){
                render "success"
            }
            else if(Visibility.PRIVATE) {
                User user1 = User.findByUserName(session.user)
                def subscription = Subscription.findAllByUserAndTopic(user1, topic)
                if (!subscription) {
                    redirect(controller: 'login', action: 'index')
                    flash.message = "Subscription does not exists."
                } else {
                    render "Success"
                }
            }
        }
    }

    def save(String name, String seriousness) {
        println "***inside save of topic"
        Topic topic = new Topic(name: name, createdBy: session.user, visiblity: Visibility.convert(seriousness))

        if (topic.save()) {
            flash.message = "Success"
            render flash.message
        } else {
            log.error(" Could not save Topic ${topic.name}")
            flash.message = "Topic ${topic.name} does not satisfied constraints"
            render flash.message

        }

    }

}
