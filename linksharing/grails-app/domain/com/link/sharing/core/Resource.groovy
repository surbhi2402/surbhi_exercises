package com.link.sharing.core

import com.ttnd.linksharing.Co.ResourceSearchCo

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
    static namedQueries = {
        search { ResourceSearchCo co ->
            if(co.topicId) {
                'topic'{
                    eq('id',co.topicId)
                    eq('visibility',co.visibility)
                }
            }
        }
    }

}





