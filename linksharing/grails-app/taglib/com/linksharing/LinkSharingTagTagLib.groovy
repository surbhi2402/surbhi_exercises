package com.linksharing

import com.link.sharing.core.Subscription
import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Enum.Seriousness
import com.ttnd.linksharing.Vo.TopicVo
import com.ttnd.linksharing.Vo.UserVO
import org.apache.log4j.lf5.util.Resource

class LinkSharingTagTagLib {
//    static defaultEncodeAs = [taglib:'html']
//    static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    static namespace = "ls"

    def markRead = { attrs, body ->
        User user = session.user
        String link = "${createLink(controller: 'readingItem', action: 'changeIsRead', params: [id: attrs.resourceId, isRead: !attrs.isRead])}"
        if (user) {
            if (attrs.isRead) {
                out << "<a href=$link>Mark as Unread</a>"
            } else {
                out << "<a href=$link>Mark as Read</a>"
            }
        }
    }

    def checkType = { attrs, body ->

        if (com.link.sharing.core.Resource.checkResourceType(attrs.id)) {
            out << "<a href=${createLink(controller: 'documentResource', action: 'download', params: [id: attrs.id])}>Download</a>"
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

        if (!session.user.isSubscribed(attrs.id)) {
            String subscribe = "${createLink(controller: 'subscription', action: 'save', params: [id: attrs.id])}"
            out << "<a href=$subscribe>Subscribe</a>"
        } else {
            String unsubscribe = "${createLink(controller: 'subscription', action: 'delete', params: [topicId:attrs.id])}"
            out << "<a href=$unsubscribe topicId=\"$attrs.id\" class='subscription'>Unsubscribe</a>"
        }

    }

    def trendingTopics = {
        if (session.user) {
            List<TopicVo> trendingTopics = Topic.getTrendingTopics()
            out << render(template: "/user/trendingTopics", model: [trendingTopics: trendingTopics])
        }
    }

    def topPosts = {
        List<com.link.sharing.core.Resource> resources = com.link.sharing.core.Resource.showTopPost()
        out << render(template: "/login/topPost", model: [resources: resources])
    }

    def subscriptionCount = { attrs, body ->
        Long userId = attrs.userId
        Long topicId = attrs.topicId
        if (userId) {
            out << Subscription.countByUser(User.load(userId))
        }
        if (topicId) {
            out << Subscription.countByTopic(Topic.load(topicId))
        }
    }

    def resourceCount = { attrs, body ->
        Long topicId = attrs.topicId
        Topic topic = Topic.get(topicId)
        if (topicId) {
            out << com.link.sharing.core.Resource.countByTopic(topic)
        }
    }

    def topicCount = { attrs, body ->
        Long userId = session.user.id
        if (userId) {
            out << Topic.countByCreatedBy(User.load(userId))
        }
    }

    def userImage = { attrs, body ->
        Long userId = attrs.id
        if (userId) {
            String src = "/user/image/${userId}"
            out << "<img src=${src} class='img img-thumbnail img-responsive' width='75px> height='75px"
        }
    }

    def canUpdateTopic = { attrs, body ->
        Long topicId = attrs.topicId
        Topic topic = Topic.get(topicId)
        User user = session.user
        if (user.equals(topic.createdBy.id) || user.admin) {
            out << render(template: '/subscription/tags', model: [topicId:attrs.topicId])
        }
    }

    def showSeriousness = { attrs, body ->
        Long topicId = attrs.topicId
        User user = session.user
        Subscription subscription = user.getSubscription(topicId)

        if (subscription) {
                out << g.select(class: 'seriousness', id: topicId, name: 'serious', from:Seriousness.values(), value: subscription.seriousness)
        } else {
            flash.error = "User not subscribed to topic"
        }
    }

}


