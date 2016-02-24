package com.linksharing

import com.link.sharing.core.User

class UserController {

    def index() {
        render "User Dashboard"
    }

    def register() {
        println "insidde register"

        if (session.user) {
            flash.message = "You are already Registered"
        } else {
            User user = new User(email: "new@tothenew.com", password: "abcdefgh", firstName: "newUser")

            if (user.hasErrors()) {
                if (!user.validate()) {
                    flash.message = "new.user.validate.error"
                    render flash.message
                } else {
                    render "validation succeeded"
                }
            }
        }
    }
}
