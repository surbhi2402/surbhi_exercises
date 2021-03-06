package com.linksharing

import com.link.sharing.core.ReadingItem
import com.link.sharing.core.Resource
import com.link.sharing.core.Subscription
import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Co.InvitationCO
import com.ttnd.linksharing.Co.ResourceSearchCo
import com.ttnd.linksharing.DTO.EmailDTO
import com.ttnd.linksharing.Enum.Seriousness
import com.ttnd.linksharing.Enum.Visibility
import com.ttnd.linksharing.Vo.PostVO
import com.ttnd.linksharing.Vo.TopicVo
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN','ROLE_USER'])
class TopicController {
    def emailService

    def index() {
        render(view: '/topic/searchPage')
    }

    def show(ResourceSearchCo resourceSearchCo) {
        def topic
        topic = Topic.read(resourceSearchCo?.topicId)
        if (!topic) {
            redirect(controller: "user", action: "index")
        } else {
            if (Visibility.PUBLIC) {
                List<Resource> resources = topic.getPost()
                render(view: '/topic/displayTopic', model: [post: resources, topic: topic, subscribedUsers: topic.subscribedUsers])
            } else if (Visibility.PRIVATE) {
                User user1 = User.findByUsername(session.user)
                def subscription = Subscription.findAllByUserAndTopic(user1, topic)
                if (!subscription) {
                    redirect(controller: 'login', action: 'index')
                } else {
                    flash.message = "Success"
                    redirect(controller: 'login', action: 'index')
                }
            } else {
                flash.error = "Topic not available!"
                redirect(controller: 'login', action: 'index')
            }
        }
    }

    def save(String name, String visibility) {
        Topic topic = new Topic(name: name, createdBy: session.user, visibility: Visibility.getVisibility(visibility))
        if (topic.validate()) {
            topic.save(flush: true)
            flash.message = "Success"
            redirect(controller: 'user', action: 'index')
        } else {
            log.error(" Could not save Topic ${topic.name}")
            flash.message = "Topic ${topic.name} does not satisfied constraints"
            render flash.message
        }
    }

    def saving(Long topicId, String visibility) {
        Topic topic = Topic.get(topicId)
        Visibility visibility1 = Visibility.getVisibility(visibility)
        Map jsonResponseMap = [:]
        if (topic && visibility) {
            topic.visibility = visibility1
            if (topic.validate() && topic.save(flush: true))
                jsonResponseMap.message = "Visibility saved successfully"
            else
                jsonResponseMap.error = "Visibility  ${visibility} could not be saved"
        } else {
            jsonResponseMap.error = "Topic with id ${id} could not be found."
        }
        JSON jsonResponse = jsonResponseMap as JSON
        render jsonResponse
    }

    def delete(Long id) {
        User user = session.user
        Topic topic = Topic.findById(id)
        if (topic && user.canDeleteTopic(id)) {
            topic.delete(flush: true)
            redirect(controller: 'user', action: 'index')
        } else
            render "Could not delete topic"

    }

    def invite(InvitationCO invitationCO) {
        Topic topic = Topic.get(invitationCO.topicId)
        if (topic && (!invitationCO.email.matches("\\s"))) {
            TopicVo topicVO = new TopicVo(id: topic.id, name: topic.name, visibility: topic.visibility,
                    createdBy: topic.createdBy)
            EmailDTO emailDTO = new EmailDTO(to: [invitationCO.email], subject: "Invitations for topic from Linksharing",
                    view: '/email/_invite', model: [currentUser: session.user, topic: topicVO])
            emailService.sendMail(emailDTO)
            flash.message = "Successfully send invitation"
        } else {
            flash.error = "Can't sent invitation"
        }
        redirect(controller: "login", action: "index")
    }


    def join(Long topicId) {
        User user = session.user
        if (user) {
            Topic topic = Topic.get(topicId)
            if (topic) {
                Subscription subscription = new Subscription(topic: topic, user: session.user, seriousness: Seriousness.SERIOUS)
                if (subscription?.save(flush: true)) {
                    flash.message = "Subscription save successfully"
                } else {
                    flash.error = "Subscription not save successfully"
                }
            } else {

                flash.error = "Topic not exist"
            }
        }
        redirect(controller: "login", action: 'index')
    }


    def titleUpdate(Long topicId, String name) {
        Map jsonResponseMap = [:]
        Topic topic = Topic.get(topicId)
        if (topic) {
            if (Topic.executeUpdate("update Topic as t set name=:name where id=:id", [name: name, id: topic.id])) {
                jsonResponseMap.message = "Successfully update Topic title!"
            } else {
                jsonResponseMap.error = "Sorry!! Could not update Topic title!"
            }
        }
        render jsonResponseMap as JSON
//        redirect(controller: "login", action: 'index')
    }
}



