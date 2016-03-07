package com.linksharing

import com.link.sharing.core.Subscription
import com.link.sharing.core.User
import org.apache.log4j.lf5.util.Resource

class LinkSharingTagTagLib {
//    static defaultEncodeAs = [taglib:'html']
//    static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    static namespace = "ls"

    def markRead = { attrs, body ->
        User user = session.user
        String link = "${createLink(controller: 'readingItem', action: 'changeIsRead', params: [id: attrs.id, isRead: !attrs.isRead])}"
        if (user) {
            if (!attrs.isRead) {
                out << "<a href=$link>Mark as Unread</a>"
            } else {
                out << "<a href=$link>Mark as Read</a>"
            }
        }
    }

    def checkType = { attrs, body ->

        if (com.link.sharing.core.Resource.checkResourceType(attrs.id)) {
            out << "<a href=${attrs.filePath}>Download</a>"
        } else {
            out << "<a href=${attrs.url} target='_blank'>View full site</a>"
        }
    }

    def resourceDelete = { attrs, body ->
        if (session.user) {
            User user = session.user
            if (user.canDeleteResource(attrs.id)) {
                String deleteLink = "${createLink(controller: 'resource', action: 'delete', params: [id: attrs.id])}"
                out << "<a href=$deleteLink>Delete</a>"
            }
        }
    }
    def showSubscribe = { attrs, body ->
        if (session.user) {
            if (!User.isSubscribed(session.user, attrs.id)) {
                String subscribe = "${createLink(controller: 'subscription', action: 'save', params: [id: attrs.id])}"
                out << "<a href=$subscribe>Subscribe</a>"
            } else {
                String unsubscribe = "${createLink(controller: 'subscription', action: 'delete', params: [id: attrs.id])}"
                out << "<a href=$unsubscribe>Unsubscribe</a>"
            }
        }
    }
}
