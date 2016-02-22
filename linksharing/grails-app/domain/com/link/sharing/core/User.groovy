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
    String confirmPassword
    Date dateCreated
    Date lastUpdated

    static hasMany = [topics:Topic,subscriptions:Subscription,readingItems:ReadingItem, resources: Resource]

    static constraints = {
        email(unique:true,blank: false, nullable: false,email:true)
        password(nullable:false, blank: false,minSize: 5,validator:{ value, object -> if(value.size()<5) return false })
        confirmPassword nullable: true,blank: true,minSize: 5,binding:true,
                validator:{val,obj ->
                    if(obj.password != obj.confirmPassword) {
                        return "object.password.not.match"
                    }else {
                        return true
                    }
                }
        firstName(nullable:false,blank: false)
        photo(nullable: true)
        admin(nullable: true)
        active(nullable: true)
    }

    static transients = ['name','confirmPassword']

    static mapping = {
        photo(sqlType:'blob')
        sort id: 'desc'
    }

    String getName(){


        [firstName,lastName].findAll{it}.join(' ')
        //return "${firstName}${lastName}"
    }


}
