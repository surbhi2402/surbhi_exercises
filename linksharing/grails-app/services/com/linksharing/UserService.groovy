package com.linksharing

import com.link.sharing.core.User
import com.ttnd.linksharing.Co.UserCo
import com.ttnd.linksharing.constants.Constants
import grails.transaction.Transactional

@Transactional
class UserService {

    def save() {
        User user = new User(email: "surbhi@tothenew.com", password: Constants.DEFAULT_PASSWORD, firstName: "surbhi", admin: false, username: "surbhi", lastName: "abcd", confirmPassword: "surbhidhawan", active: true)
        user.save()
    }
}

