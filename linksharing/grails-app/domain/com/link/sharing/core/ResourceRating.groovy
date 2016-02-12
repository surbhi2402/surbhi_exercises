package com.link.sharing.core

import javax.validation.constraints.Size

class ResourceRating {

    Resource resource
    User user
    Integer score
    Date dateCreated
    Date lastUpdated

    static belongsTo = [user:User,resource:Resource]

    static constraints = {

        score(min:1,max: 5,nullable: false)
        resource unique: 'user'
        user nullable: false
    }
}
