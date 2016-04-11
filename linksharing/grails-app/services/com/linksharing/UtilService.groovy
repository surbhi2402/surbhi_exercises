package com.linksharing

import grails.transaction.Transactional

@Transactional
class UtilService {

    def springSecurityService

    String fetchEncodedPassword(String password) {
        return springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password

    }
}
