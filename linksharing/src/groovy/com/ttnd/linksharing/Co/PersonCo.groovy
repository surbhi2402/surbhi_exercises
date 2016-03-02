package com.ttnd.linksharing.Co

import grails.validation.Validateable

/**
 * Created by surbhi on 2/3/16.
 */
@Validateable
class PersonCo {
    String name
    Integer age
    String location

    static constraints={
        name nullable: false
        age nullable: true
        location nullable: true
    }
}
