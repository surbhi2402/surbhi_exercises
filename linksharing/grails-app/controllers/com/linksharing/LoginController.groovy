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
            forward(action: "index")
    }

    def loginHandler(String username,String password){

            if (params.username == "admin" && params.password == "su") {
                //render "User is active"
                session.user = true
                redirect(action: "index",params: [username: "admin"])
            }

        else{
            flash.error = "Your account is not active!"
            render flash.error
        }
    }

 def show(String id){

      def topic

      topic = Topic.get(params:id)

      /*def user = get(params: id) */

    if(!topic){
         redirect(controller: "user", action: "index")
         flash.error = "No topic in database"
     }
     else {
         if(Visibillity.PUBLIC){
             render "Successfull"
         }
         else if(Visibillity.PRIVATE){
             render "private topic"

             if(user.subscription.topic == this.topic)
                 render "success"

             else {
                 redirect(controller: "user",action: "login")
                 flash.error = "user not subscribed to this private topic"
             }
         }
     }
 }
}
