package com.linksharing

import com.link.sharing.core.ReadingItem
import com.link.sharing.core.Resource
import com.link.sharing.core.User

class ReadingItemController {

    def index() {
//        User user = session.user
//        List<ReadingItem> readingItemList = ReadingItem.findAllByUser(user)
//        println "${re}"
        render(view: '/user/dashboard')
    }

    def changeIsRead(Long Id, Boolean isRead) {
        Resource resource = Resource.get(id)
        User user = session.user

        if (ReadingItem.executeUpdate("update ReadingItem as r set r.isRead=:isRead where r.resource.id=id and r.user.id = :userId", [isRead: isRead, userId: user.id])) {
            render "Reading Item isRead successfully changed. ~SUCCESS~"
        } else {
            render "Reading Item isRead could not be changed. ~FAILURE~"
        }
    }
}
