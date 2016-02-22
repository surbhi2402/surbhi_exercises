package com.linksharing

import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Enum.Visibillity

class LoginController {

    def index() {
        if(session.user){
           //forward(controller: "user",action: "index")
            String user1 = params.username
            render "User Dashboard ${user1}"
        }
        else {
            render "failure!-> Please login"
        }
    }

    def login(){
        if(session.user){
            render "logged in as Admin"}
     else {
            render "login failed"
        }
    }

    def logout(){
            session.invalidate()
       // render session.user
            forward(action: "index")
    }

    def loginHandler(String username,String password){
                User user = User.findByUsernameAndPassword(username,password)

            println "=======user====$user.properties"
            if (user && user.active) {
                //render "User is active"
                session.user = true
                redirect(action: "index",params: [username: "admin"])
            }

        else{
            flash.error = "Your account is not active!"
            render flash.error
        }
    }

}
