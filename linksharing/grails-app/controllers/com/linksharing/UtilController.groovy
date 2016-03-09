package com.linksharing

class UtilController {


    def mailService



    //def grailsApplication
    def index() {

        mailService.sendMail {
            to "saloni.sharma@tothenew.com"
            from "surbhi.dhawan@tothenew.com"
//            cc "marge@g2one.com", "ed@g2one.com"
//            bcc "joe@g2one.com"
            subject "Hello Saloni"
            body 'this is some text'


            render "Mail Sent"
        }
        // render "logs called"
        //render "grailsApplication.config.grails.test"

        //log.fatal("testing log fatal")
        //log.error("testing log error")
        //log.trace("testing log trace")

    }

}
