package com.ttnd.linksharing.Vo

import com.link.sharing.core.User
import com.ttnd.linksharing.Enum.Visibility

/**
 * Created by surbhi on 25/2/16.
 */
class TopicVo {
    Long id
    String name
    Visibility visibility
    Integer count
    User createdBy
}
