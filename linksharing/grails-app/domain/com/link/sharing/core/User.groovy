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
        confirmPassword nullable: true,blank: true,minSize: 5,bindable:true,
                validator: { val, obj ->
                    if (val != obj.password) {
                        // return "object.password.not.match"
                        return false
                    } else {
                        return true
                    }

                }
        firstName(nullable:false,blank: false)
        photo(nullable: true)
        admin(nullable: true)
        active(nullable: true)
    }

    static transients = ['name','confirmPassword','subscribeTopics']

    static mapping = {
        photo(sqlType:'blob')
        sort id: 'desc'
    }

    String getName(){


        [firstName,lastName].findAll{it}.join(' ')
        //return "${firstName}${lastName}"
    }

    List<Topic> getSubscribeTopics(){
        List<Topic> topics= Subscription.createCriteria().list() {
            projections {
                property('topic')
            }
            eq('user.id',this.id)
        }
        return topics
    }

    User save(){
        User user = this
        user.validate()
        if(user.hasErrors()){
            log.error("Error in saving user: ${user.errors}")
        }else{
            user.save(flush: true)
            log.info "Users saved successfully"
        }
        return user
    }

     Boolean canDeleteResource(Long id){
        Resource resource = Resource.read(id)
         println "=====${resource.id}================"
        if(this.admin || resource.createdBy.id == this.id){
            return true
        } else {
            return false
        }


    }
}
