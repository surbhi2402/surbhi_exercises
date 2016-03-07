package com.linksharing

import com.link.sharing.core.Resource
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ResourceController)
@Mock([Resource])
class ResourceControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "deleting resource-when resource is not there"() {
        when:
        controller.delete(44L)

        then:
        response.contentAsString == "Resource does not exists"
    }

}
