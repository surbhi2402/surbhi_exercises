package com.link.sharing.core

import com.sun.org.apache.xpath.internal.operations.Bool
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(LinkResource)
class LinkResourceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "testing link resource file"() {

        given:
        LinkResource linkResource = new LinkResource(topic: topic, createdBy: author, url: myURL, description: desc)

        when:
        Boolean result = linkResource.validate()

        then:
        result == expectedOutput

        where:
        topic       | author     | myURL                      | desc              || expectedOutput
        new Topic() | new User() | "https://www.google.co.in" | "new description" || true
        new Topic() | new User() | "hdbx"                     | "new2"            || false
        new Topic() | new User() | null                       | "new3"            || false
        new Topic() | new User() | ""                         | "new4"            || false
    }
}
