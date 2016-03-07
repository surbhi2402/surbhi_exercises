package com.linksharing

import com.ttnd.linksharing.CustomBean
import grails.util.Holders
import org.springframework.beans.factory.annotation.Autowired

class CustomBeanDemoController {

    def index() {
        def c = Holders.applicationContext.getBean('myBean')
        render ("${c} :--> ${c.properties}")
//        render "${myBean.properties}"
    }

    def myBean1
    def customBean1


    @Autowired
    CustomBean myBean

}
