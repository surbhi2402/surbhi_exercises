package com.ttnd.linksharing.Co

import com.link.sharing.core.User
import grails.validation.Validateable

/**
 * Created by surbhi on 15/3/16.
 */
@Validateable
class UpdatePasswordCO {
    Long userId
    String oldPassword
    String password


    static constraints = {
        password(blank: false, minSize: 5)
    }
    User getUser() {
        return User.get(userId)
    }
}
