package com.linksharing

class Person {

    String name
    Integer age
    String location

    static constraints = {
        name nullable: false
        age nullable: false
        location nullable: true
    }
}
