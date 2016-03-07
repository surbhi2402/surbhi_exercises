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
            List<Resource> resources = Resource.showTopPost()
            List<Resource> recentShares = Resource.list([sort: 'dateCreated', order: 'desc', max: 2])
            render(view: 'home', model: [resources: resources, recentShares: recentShares])
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

}
