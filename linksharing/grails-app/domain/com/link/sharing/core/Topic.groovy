package com.link.sharing.core

import com.ttnd.linksharing.Enum.Seriousness
import com.ttnd.linksharing.Enum.Visibillity



class Topic {

    String name
    Date dateCreated
    Date lastUpdated
    User createdBy
    Visibillity visibility

   static hasMany = [subscritions:Subscription,resources:Resource]


    static constraints = {

        name (nullable:false,blank:false,unique:'createdBy')
        createdBy(nullable: false)

    }


 def afterInsert ={
     Topic.withNewSession{
         Subscription subscription =new Subscription(user:this.createdBy,seriousness: Seriousness.VERY_SERIOUS,topic:this)
        if(subscription.save())
        {
            log.info "Subscription saved successfully"
        }
         else {
            log.error "could not save subscriptions"
        }
     }
 }
}
