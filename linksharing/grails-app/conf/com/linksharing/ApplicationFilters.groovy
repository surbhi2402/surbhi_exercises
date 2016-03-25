package com.linksharing

class ApplicationFilters {

    def filters = {
//        sessionCheck(controller:'*', action:'*') {
//            before = {
//
//            }
//            after = { Map model ->
//
//            }
//            afterView = { Exception e ->
//
//            }
//        }
        loginCheck(controller: 'login|topic', invert: true) {
            before = {
                println "======session.user=====${session.user}"
                if (!session.user && (!(controllerName == "user" && actionName == "register")) && (!(controllerName == "resource" && actionName == "globalSearch"))) {
                    redirect(controller: 'login', action: 'index')
                }
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }


    }
}
