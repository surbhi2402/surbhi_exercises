package com.ttnd.linksharing
/**
 * Created by surbhi on 7/3/16.
 */
class CustomBean {


    String getName() {
        return name
    }

    void setName(String name) {
        println "calling setterr inside custom bean......!!!"
        this.name = name
    }

    String name

    CustomBean() {
        println "called Default Constructor"
    }

    CustomBean(String name) {
        println "constructor called"
        this.name = name
    }
}
