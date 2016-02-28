package com.linksharing

import com.link.sharing.core.User
import com.ttnd.linksharing.Co.UserCo

class UserController {

    def index() {
        render(view: 'dashboard')
        //render "User Dashboard ${params.username}"
    }

    def register(UserCo userCo) {
        println "inside register"

        if (session.user) {
            render "You are already Registered"
        } else {
            User user = new User(email:userCo.email,firstName: userCo.firstName,lastName: userCo.lastName,password: userCo.password,username: userCo.username,confirmPassword: userCo.confirmPassword )

            if (user?.hasErrors()) {
//                    flash.message = "new.user.validate.error"
//                render (view: 'register',model: [user:user])
                    render "validation failed!!!"
                } else {
                    user.save(flush: true)
                    render "validation succeeded"
                }
            }

        render "-----"
        }


    def createForm(){
        render (view: 'myForm.gsp')
    }
}
