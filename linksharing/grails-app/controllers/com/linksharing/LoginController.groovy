package com.linksharing

import com.link.sharing.core.Resource
import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Enum.Visibility

class LoginController {

    def index() {
        if (session.user) {
            forward(controller: "user", action: "index")
        } else {
            List<Resource> recentShares = Resource.list([sort: 'dateCreated', order: 'desc', max: 2])
            render(view: 'home', model: [recentShares: recentShares])
        }
    }

    def login(String username, String password) {
        User user = User.findByUsernameAndPassword(username, password)
        if (user) {
            if (user.active) {
                session.user = user
                redirect(controller: 'user', action: 'index')
            } else {
                flash.error = 'Your account is not active'
            }
        } else {
            flash.error = 'User not found'
            render flash.error
        }
    }

    def logout() {
        session.invalidate()
        forward(action: "index")
    }


    def validateUserName(){
        Integer numUser = User.countByUsername(params.username)
        log.info params.username
        Boolean result = numUser ? false : true

        render result

    }

    def validateEmail(){
        Integer numEmail = User.countByEmail(params.email)
        log.info params.email
        Boolean result1 = numEmail ? false : true

        render result1
    }

}
