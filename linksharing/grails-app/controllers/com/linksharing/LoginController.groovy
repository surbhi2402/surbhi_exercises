package com.linksharing

class LoginController {

    def index() {

    }

    def login(){

        if(session.user){
            forward()
        }
        else {
            render "failure"
        }

    }

    def logout(){

    }
}
