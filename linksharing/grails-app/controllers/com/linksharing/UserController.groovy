package com.linksharing

import com.link.sharing.core.User

class UserController {

    def index() {
        String user1 = params.username
       render "User Dashboard ${user1}"
    }

    def register(){
        def user = new User(params)


        if(!user){
            flash.message = "User is not set"
        }
        else {
            render "Successful user"
        }
        if(!user.validate()){
            render "validation failed"
        }
        else{
            render "validation succeeded"
        }
    }
}
