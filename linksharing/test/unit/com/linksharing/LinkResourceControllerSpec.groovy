package com.linksharing

import com.link.sharing.core.LinkResource
import com.link.sharing.core.Subscription
import com.link.sharing.core.Topic
import com.link.sharing.core.User
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(LinkResourceController)
@Mock([LinkResource, Topic, Subscription])
class LinkResourceControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "testing index action"() {
        when:
        controller.index()

        then:
        response.contentAsString == "inside Link Resource"
    }


    void "testing save action"() {
        setup:
        session.user = new User()

        when:
        controller.save("http://google.com", "it's google", 1)

        then:
        response.contentAsString == "link not saved!!"
    }

//    void "testing saving of link resource"(){
//        setup:
//        session.user = new User()
//        Topic topic = new Topic()
//        topic.save(validate: false)
//        topic.validate()
//
//        when:
//        controller.save("topic1","this is topic",2)
//
//        then:
//        response.contentAsString == "link saved successfully"
//    }
}
