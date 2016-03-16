package com.ttnd.linksharing.Co

import com.link.sharing.core.User
import com.ttnd.linksharing.Enum.Visibility

/**
 * Created by surbhi on 11/3/16.
 */
class TopicSearchCO {

    Visibility visibility
    Long id

    User getUser() {
        return User.findById(id)
    }
}
