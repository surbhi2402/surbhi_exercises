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
    //String confirm_password
    Date dateCreated
    Date lastUpdated

    static hasMany = [topics:Topic,subscriptions:Subscription,readingItems:ReadingItem, resources: Resource]

    static constraints = {
        email(unique:true,blank: false, nullable: false,email:true)
        password(nullable:false, blank: false,minSize: 5,validator:{ value, object -> if(value.size()<5) return false })
     //   confirm_password(nullable: true,blank: true,minSize: 5,validator:{val,obj ->
       //     if(obj.password != obj.confirm_password) return false})
        firstName(nullable:false,blank: false)
        photo(nullable: true)
        admin(nullable: true)
        active(nullable: true)
    }

    static transients = ['name','confirm_password']

    static mapping = {
         photo(sqlType:'blob')
    }

    String getName(){


        [firstName,lastName].findAll{it}.join(' ')
        //return "${firstName}${lastName}"
    }


}
