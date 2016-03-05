package com.linksharing

import com.link.sharing.core.Topic
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
@Mock([Topic])

class TopicControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "testing index action"() {
        when:
        controller.index()

        then:
        response.contentAsString == "inside index"
    }

    void "testing show action if topic not found"(){
        when:
        controller.show()

        then:
        response.redirectedUrl == '/user/index'
        flash.error == "No topic in database"
    }

    @IgnoreRest
    void "testing show action of Topic"(){
        given:"a topic"
        Topic topic = new Topic()
        topic.save(validate: false)

        and:"mock the command objects"
        ResourceSearchCo resourceSearchCo = new ResourceSearchCo(topicId:topic?.id,visibility:Visibility.PUBLIC)

        when:
        controller.show(resourceSearchCo)

        then:
        response.text == "success"
    }


}
