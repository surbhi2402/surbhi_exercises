package com.link.sharing.core

import com.ttnd.linksharing.Enum.Seriousness
import com.ttnd.linksharing.Enum.Visibility




class Topic {

    String name
    Date dateCreated
    Date lastUpdated
    User createdBy
    Visibility Visibility

   static hasMany = [subscritions:Subscription,resources:Resource]


    static constraints = {

        name (nullable:false,blank:false,unique:'createdBy')
        createdBy(nullable: false)

    }

    static mapping = {
        sort name:'asc'
    }


 def afterInsert() {
     System.err.println("....${this.id}")

     Topic.withNewSession{
         System.err.println("....${this.id}")
         Topic topic = Topic.get(this.id)
         Subscription subscription =new Subscription(user:topic.createdBy,seriousness: Seriousness.VERY_SERIOUS,topic:topic)
        if(subscription.save(flush: true))
        {
            log.info "Subscription saved successfully"
        }
         else {
            log.error "could not save subscriptions"
        }
     }
 }
}
