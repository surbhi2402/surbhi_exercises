package com.ttnd.linksharing.Vo

/**
 * Created by surbhi on 4/3/16.
 */
class PostVO {
    Long resourceID
    Integer resourceRating
    String description
    String url
    String filePath
    byte[] userPhoto
    boolean isRead
    String topicName
    String userUserName
    String userFirstName
    String userLastName

    String getNameOfUser(){
        return "$userFirstName $userLastName"
    }
}
