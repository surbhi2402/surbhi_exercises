package com.link.sharing.core

import com.ttnd.linksharing.Enum.Seriousness
import com.ttnd.linksharing.Enum.Visibility
import com.ttnd.linksharing.Vo.TopicVo


class Topic {

    String name
    Date dateCreated
    Date lastUpdated
    User createdBy
    Visibility visibility

    static hasMany = [subscritions: Subscription, resources: Resource]


    static constraints = {

        name(nullable: false, blank: false, unique: 'createdBy')
        createdBy(nullable: false)

    }

    static mapping = {
        sort name: 'asc'
    }

    static getTrendigTopics() {
        List topicVos = Resource.createCriteria().list {

            projections {
                createAlias('topic', 't')
                groupProperty('t.id')
                property('t.name')
                property('t.visibility')
                property('t.createdBy')
                count('id')


            }
            //max('resourceCount')

            maxResults 5

            order('t.name', 'desc')
        }
        println "${topicVos}"
        List<TopicVo> topicVoList = []
        topicVos.each {
            topicVoList.add(new TopicVo(id: it[0], name: it[1], visibility: it[2], createdBy: it[3], count: it[4]))
        }

        return topicVoList

    }

    def afterInsert() {
        System.err.println("....${this.id}")

        Topic.withNewSession {
            System.err.println("....${this.id}")
            Topic topic = Topic.get(this.id)
            Subscription subscription = new Subscription(user: topic.createdBy, seriousness: Seriousness.VERY_SERIOUS, topic: topic)
            if (subscription.save(flush: true)) {
                log.info "Subscription saved successfully"
            } else {
                log.error "could not save subscriptions"
            }
        }
    }
}
