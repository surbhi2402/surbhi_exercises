package com.linksharing

import com.link.sharing.core.ReadingItem

class ReadingItemController {

    def index() {
        render "inside reading item"
    }

    def changeIsRead(Long id,Boolean isRead){
        if(ReadingItem.executeUpdate("update ReadingItem as r set r.isRead=isRead where r.id=id"))
            render "successfully changed isRead!!!"
        else {
            render "Unsuccessful!!"
        }
    }
}
