package com.ttnd.linksharing.Co

import grails.validation.Validateable

/**
 * Created by surbhi on 25/2/16.
 */
@Validateable
class UserCo {
    String firstName
    String lastName
    String password
    String email
    String username
    String confirmPassword
}
