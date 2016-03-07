package com.linksharing

import com.link.sharing.core.User
import com.ttnd.linksharing.Co.PersonCo

class BindingController {

    def index() {}

    def fetchList() {
        List list = params.list("topics")
        render list
        println params.getProperties()
    }

    def floatChange(float x) {
        Float z = params.float("x")
        render z
//        println params.getProperties()
    }

    def checkErrors() {
        def user = new User(params)
        render user.hasErrors()
        if (user.hasErrors()) {
            render "errors in field ${user.errors.getFieldError('email')}"
            if (user.errors.getFieldError('email')) {
                println "${user.errors.getFieldError("email")}--> rejected value"
            }
        }
    }

    def printErrors(PersonCo personCo) {
        render personCo.properties
        render "<br>"
        render personCo.errors
        render "<br>"
        if (personCo.hasErrors()) {
            render "${personCo.errors.getFieldError('name').rejectedValue}"
        }
    }

}
