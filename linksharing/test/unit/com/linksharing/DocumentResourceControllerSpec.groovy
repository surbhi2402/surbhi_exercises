package com.linksharing

import com.link.sharing.core.DocumentResource
import com.link.sharing.core.Topic
import com.link.sharing.core.User
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(DocumentResourceController)
@Mock([User, DocumentResource, Topic])
class DocumentResourceControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "testing index action"() {
        when:
        controller.index()

        then:
        response.contentAsString == "inside document resource!"
    }

    void "testing save action"() {
        setup:
        session.user = new User()

        when:
        controller.save("/some/path", "it's a file", 1)

        then:
        response.contentAsString == "Document not saved!!"
    }
}
