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
    String content
    Map model

    static constraints = {
        model(nullable: true)
        to(nullable: false)
        view(nullable: true)
        subject(nullable: false)
        content(nullable: true)
    }
}
