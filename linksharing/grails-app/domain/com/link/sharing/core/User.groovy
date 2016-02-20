package com.link.sharing.core

class User {

    String email
    String username
    String password
    String firstName
    String lastName
    Byte[] photo
    Boolean admin
    Boolean active
    Date dateCreated
    Date lastUpdated

    static hasMany = [topics:Topic,subscriptions:Subscription,readingItems:ReadingItem, resources: Resource]

    static constraints = {
        email(unique:true,blank: false, nullable: false,email:true)
        password(nullable:false, blank: false,minSize: 5)
        firstName(nullable:false,blank: false)
        photo(nullable: true)
        admin(nullable: true)
        active(nullable: true)
    }

    static transients = ['name']

    static mapping = {
         photo(sqlType:'blob')
    }

    String getName(){


        [firstName,lastName].findAll{it}.join(' ')
        //return "${firstName}${lastName}"
    }


}
