package com.linksharing

import com.link.sharing.core.Subscription
import com.link.sharing.core.Topic
import com.link.sharing.core.User

class SubscriptionController {

    def index() {}

    def deleting(Long id,String username,String password) {
        User user = User.findByUsernameAndPassword(username,password)
        Subscription s = Subscription.get(id)
        if(s){
         s.delete(flush: true)
            render "successful deletion!"
        }else {
            render "Subscription not found!!"
        }
    }

//    def saving(Long id){
//      Topic topic = Topic.get(id)
//       if(topic){
//
//           Subscription subscription = new Subscription(user:)
//       }


//    }
}