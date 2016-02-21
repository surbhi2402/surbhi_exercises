package com.linksharing

class ApplicationFilters {

    def filters = {
        sessionCheck(controller:'*', action:'*') {
            before = {

            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
        loginCheck(controller:'login', invert:true) {
            before = {
                if(!session.user)
                    redirect(action: 'login')
                return false
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
