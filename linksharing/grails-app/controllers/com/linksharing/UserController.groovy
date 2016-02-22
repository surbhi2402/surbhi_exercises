package com.linksharing

import com.link.sharing.core.User

class UserController {

    def index() {
        //String user1 = params.username
        render "User Dashboard"
    }

    def register() {
        println "insidde register"
        User user = new User(email: "new@tothenew.com", password: "abcdefgh", firstName: "newUser")

//        if(!user){
//
//            flash.message = "User is not set--> ${user.properties}"
//        }
//        else {
//            render "Successfully set new user!"
//        }

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
