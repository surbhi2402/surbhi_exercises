package com.link.sharing.core

import com.ttnd.linksharing.Vo.PostVO

class ReadingItem {

    //Resource resource
    //User user
    Boolean isRead
    Date dateCreated
    Date lastUpdated

    static belongsTo = [user: User, resource: Resource]

    static constraints = {
        resource(unique: 'user', nullable: false)
        isRead(nullable: false)
        user nullable: false
    }

    def executeUpdate() {
        User user = User.get(1)
        String firstName = user.firstName
        User.executeUpdate("update User as u set u.firstName = firstName where u.id =:id", [firstName: "surbhi", id: 1.toLong()])
        render "firstName before --> ${firstName} and firstName after --> ${user.firstName}"

    }

    static def getInboxItems(user) {
// User currentUser = session.user
        List<PostVO> readingItemsList = [];
        ReadingItem.findAllByUser(user).each {
            readingItemsList.add(new PostVO(resourceID: it.resource.id, description: it.resource.description,
                    topicName: it.resource.topic.name, userUserName: it.resource.createdBy.username,
                    userFirstName: it.resource.createdBy.firstName, userLastName: it.resource.createdBy.lastName,
                    userPhoto: it.resource.createdBy.photo, isRead: it.isRead,
                    url: it.resource.class.equals(LinkResource) ? it.resource.id : "",
                    filePath: it.resource.class.equals(DocumentResource) ? it.resource.id : ""))
        }
        println "====readingItemsList====${readingItemsList}"
        return readingItemsList
    }
}
