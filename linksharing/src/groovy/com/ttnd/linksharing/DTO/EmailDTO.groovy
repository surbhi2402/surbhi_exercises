package com.ttnd.linksharing.DTO

import grails.validation.Validateable

/**
 * Created by surbhi on 13/3/16.
 */
@Validateable
class EmailDTO {
    List<String> to
    String view
    String subject
    Map model

    static constraints = {
        model(nullable: true)
    }
}
