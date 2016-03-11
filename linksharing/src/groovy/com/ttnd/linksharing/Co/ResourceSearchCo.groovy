package com.ttnd.linksharing.Co

import com.link.sharing.core.User
import com.ttnd.linksharing.Enum.Visibility
import grails.validation.Validateable

/**
 * Created by surbhi on 23/2/16.
 */
@Validateable
class ResourceSearchCo extends SearchCo {
    long topicId
    Visibility visibility
    Long id
   User getUser(){
    return User.findById(id)
    }
}
