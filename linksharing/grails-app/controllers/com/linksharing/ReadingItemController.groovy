package com.linksharing

import com.link.sharing.core.ReadingItem
import com.link.sharing.core.Resource
import com.link.sharing.core.User

class ReadingItemController {

    def index() {
        render(view: '/user/dashboard')
    }

    def changeIsRead(Long id, Boolean isRead) {
        Resource resource = Resource.get(id)
        println "==============------------------${resource}"
        User user = session.user

        if (ReadingItem.executeUpdate("update ReadingItem as r set r.isRead=:isRead " +
                "where r.resource=:resource and r.user =:user", [isRead: isRead, user: user, resource:resource]))
        {
            render "Reading Item isRead successfully changed. ~SUCCESS~"
        } else {
            render "Reading Item isRead could not be changed. ~FAILURE~"
        }
    }
}
