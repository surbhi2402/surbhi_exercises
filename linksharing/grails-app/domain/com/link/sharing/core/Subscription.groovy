package com.link.sharing.core

import com.ttnd.linksharing.Enum.Seriousness


import spock.util.mop.Use

class Subscription {

    //Topic topic
    //User user
    Date dateCreated
    Date lastUpdated
    Seriousness seriousness

    static belongsTo = [user:User,topic:Topic]

    static constraints = {
        user(nullable: false)
        //,validator{def object, def val->
          //  return "ff.g.g"
        //}
        topic(nullable: false,unique:'user')
        seriousness(nullable:false)

    }
}
