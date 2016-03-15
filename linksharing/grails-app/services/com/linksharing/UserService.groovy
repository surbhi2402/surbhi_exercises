package com.linksharing

import com.link.sharing.core.Resource
import com.link.sharing.core.User
import com.ttnd.linksharing.Co.UserCo
import com.ttnd.linksharing.constants.Constants
import grails.transaction.Transactional

@Transactional
class UserService {
def emailService
    def save() {
        User user = new User(email: "surbhi@tothenew.com", password: Constants.DEFAULT_PASSWORD, firstName: "surbhi", admin: false, username: "surbhi", lastName: "abcd", confirmPassword: "surbhidhawan", active: true)
        user.save()
    }

def sendUnreadItemsEmail(){
    getUserWithUnreadItems().each {User user ->
        emailService.sendUnreadResourcesEmail(user,getUnreadResources(user))

    }
}

    List<User> getUserWithUnreadItems() {
        return Resource.usersWithUnreadResources()
    }
    List<Resource> getUnreadResources(User user) {
        return user.unreadResources()
    }
}

