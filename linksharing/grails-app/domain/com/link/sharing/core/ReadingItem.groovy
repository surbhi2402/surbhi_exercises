package com.link.sharing.core

class ReadingItem {

    //Resource resource
    //User user
    Boolean isRead
    Date dateCreated
    Date lastUpdated

    static belongsTo = [user:User,resource:Resource]

    static constraints = {
        resource(unique: 'user',nullable: false)
        isRead(nullable: false)
        user nullable: false
    }

    def executeUpdate(){
        User user = User.get(1)
        String firstName = user.firstName
        User.executeUpdate("update User as u set u.firstName = firstName where u.id =:id", [firstName:"surbhi",id:1.toLong()])
        render "firstName before --> ${firstName} and firstName after --> ${user.firstName}"

    }
}
