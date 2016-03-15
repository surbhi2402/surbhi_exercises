package com.ttnd.linksharing.Co

import com.link.sharing.core.User
import grails.validation.Validateable

/**
 * Created by surbhi on 15/3/16.
 */
@Validateable
class UpdatePasswordCO {
    String oldPassword
    String password
    Long id


    static constraints = {
        password(blank: false,minSize: 5)
    }
    User getUser(){
        return User.get(id)
    }
}
