package com.link.sharing.core

class Employee {



        String firstName
    String lastName

    void setFirstName(String firstName) {
        println "calling setterr inside custom bean..inside Employee class....!!!"
        this.firstName = firstName
    }
    void setLastName(String lastName) {
        println "calling setter inside custom bean..inside Employee class.....!!!"
        this.lastName = lastName
    }

    String getFirstName() {
        return firstName
    }
    String getLastName() {
        return lastName
    }

    static constraints = {
    }
}
