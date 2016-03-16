package com.linksharing

import com.link.sharing.core.ReadingItem
import com.link.sharing.core.Resource
import com.link.sharing.core.User
import grails.converters.JSON

class ReadingItemController {

    def index() {
        render(view: '/user/dashboard')
    }

    def changeIsRead(Long resourceId, Boolean isRead) {
        Resource resource = Resource.get(resourceId)
        Map jsonResponseMap = [:]
        User user = session.user

        if (ReadingItem.executeUpdate("update ReadingItem as r set r.isRead=:isRead where r.resource=:resource and r.user =:user", [isRead: isRead, user: user, resource:resource]))
        {
            jsonResponseMap.message = "Reading Item isRead successfully changed."
//            render "Reading Item isRead successfully changed. ~SUCCESS~"
        } else {
            jsonResponseMap.error = "Reading Item isRead could not be changed."
//            render "Reading Item isRead could not be changed. ~FAILURE~"
        }
        render jsonResponseMap as JSON
    }
}
