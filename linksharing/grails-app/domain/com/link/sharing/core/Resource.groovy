package com.link.sharing.core

abstract class Resource {

    String description
    User createdBy
    Topic topic
    Date dateCreated
    Date lastUpdated

    static hasMany=[resourceRatings:ResourceRating,readingItems:ReadingItem]

    static belongsTo = [topic:Topic]

    static mapping = {
        description(type:'text')
    }
}



