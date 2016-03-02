package com.link.sharing.core

import com.ttnd.linksharing.Enum.Seriousness


import spock.util.mop.Use

class Subscription {

    Date dateCreated
    Date lastUpdated
    Seriousness seriousness = Seriousness.SERIOUS

    static belongsTo = [user: User, topic: Topic]

    static constraints = {
        user(nullable: false)
        topic(nullable: false, unique: 'user')
        seriousness(nullable: false)
    }

    String toString() {

        "User is : ${this.user} and topic is:  ${this.topic}"
    }
}
