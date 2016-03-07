package com.linksharing

import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Co.ResourceSearchCo
import com.ttnd.linksharing.Enum.Visibility
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(TopicController)
@Mock([Topic, User])
class TopicControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

//    void "testing index action"() {
//        when:
//        controller.index()
//
//        then:
//        response.contentAsString == "inside index"
//    }

    void "testing show action if topic not found"() {
        setup:
        Topic topic = Topic.read(11L)

        and:
        ResourceSearchCo resourceSearchCo = new ResourceSearchCo()

        when:
        controller.show(resourceSearchCo)

        then:
        response.redirectedUrl == '/user/index'
        flash.error == "No topic in database"
    }

    void "testing show action of Topic"() {
        given: "a topic"
        Topic topic = new Topic()
        topic.save(validate: false)

        and: "mock the command objects"
        ResourceSearchCo resourceSearchCo = new ResourceSearchCo(topicId: topic?.id, visibility: Visibility.PUBLIC)

        when:
        controller.show(resourceSearchCo)

        then:
//        view == '/topic/displayTopic'
//        model.topic == topic
//       model.subscribedUsers == topic.subscribedUsers
        response.text == "success"
    }

    void "topic show if visibility is private"() {
        setup: "a user"
        User user = new User()
        user.save(validate: false)
        session.user = user

        and: "a topic"
        Topic topic = new Topic(name: "Grails", visibility: Visibility.PRIVATE)
        topic.save(validate: false)

        and: "command object"
        ResourceSearchCo resourceSearchCo = new ResourceSearchCo(topicId: topic?.id, visibility: Visibility.PRIVATE)

        when:
        controller.show(resourceSearchCo)

        then:
//        response.redirectedUrl == '/login/index'
//        flash.message == null
        response.contentAsString == "success"
    }


    void "testing save action"() {
        when:
        controller.save('Grails', "PUBLIC")

        then:
        flash.message == "Topic Grails does not satisfied constraints"

    }

//    void "saving topic successfully"(){
//        setup:
//        Topic topic = new Topic(name: "Grails",visibility:"PUBLIC")
//        topic.save(validate: false)
//
//        when:
//        controller.save("Grails","PUBLIC")
//
//        then:
//        flash.message == "Success"
//    }
}
