package com.linksharing

import com.link.sharing.core.Subscription
import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Enum.Seriousness

class SubscriptionController {

    def index() {}

    def deleting(Long id,String username,String password) {
        User user = User.findByUsernameAndPassword(username,password)
        Subscription subscription = Subscription.get(id)
        if(subscription){
            subscription.delete(flush: true)
            render "successful deletion!"
        }else {
            render "Subscription not found!!"
        }
    }

    def saving(Long id) {

       // User user = User.findByUsernameAndPassword(username, password)
        Topic topic = Topic.get(id)
        if (topic) {
            Subscription subscription = new Subscription(topic: topic, user: session.user, seriousness: Seriousness.SERIOUS)
            if (subscription.save(flush: true)) {
                render "Subscription saved successfully!"
            } else {
                render "Subscription not saved"
            }
        }
    }

    def updating(Long id,String seriousness) {
        println "inside updating"
        seriousness = Seriousness.convert(seriousness)
        Subscription subscription = Subscription.findByIdAndSeriousness(id,seriousness)
        if(subscription){
            subscription.save(flush: true)
            render "subscription found and updated successfully"
        }else {
            render "failure in saving subscription"
        }
    }
}