package com.linksharing

import com.link.sharing.core.User

class DemoTagLib {

    static namespace = "tl"
//    static defaultEncodeAs = [taglib: 'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def showAdmin = {
        attrs, body ->
            Boolean admin = Boolean.valueOf(attrs.admin)
            if (admin) {
                out << body()
            }
    }

    def showUsers = {
            List<User> users = User.list()
            out << render(template: '/user/userTemplate', model: [users: users])
    }

//    def showUserDetail={
//        attrs,body ->
//        Boolean admin=Boolean.valueOf(attrs.admin)
//            out << link(controller: 'user',action: 'showUserDetail'params: [admin:admin])
//
//    }
}
