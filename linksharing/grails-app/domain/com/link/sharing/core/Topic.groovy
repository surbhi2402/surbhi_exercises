package com.link.sharing.core


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
}
