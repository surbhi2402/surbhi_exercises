package com.linksharing

import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Enum.Visibility

class LoginController {

    def index() {
        if(session.user){
            forward(controller: "user",action: "index")
        }
        else {
            render "failure!-> Please login"
        }
    }

    def login(){
        if(session.user){
            render "logged in!!"}
        else {
            render "login failed"
        }
    }

    def logout(){
        session.invalidate()
        forward(action: "index")
    }

    def loginHandler(String username,String password){
        User user = User.findByUsernameAndPassword(username,password)

       // println "=======user====$user.properties"
        if (user && user.active) {
            session.user = true
            redirect(action: "index",params: [username:username])
        }

        else{
            flash.error = "Your account is not active!"
            render flash.error
        }
    }

}
