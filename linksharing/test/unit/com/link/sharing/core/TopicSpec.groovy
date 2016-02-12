package com.link.sharing.core

import grails.test.mixin.TestFor
import spock.lang.Specification
import com.ttnd.linksharing.Enum.Visibillity

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Topic)
class TopicSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "testing topic"() {

        given:
        Topic topic = new Topic(name: n, createdBy: author,visibility: visibility)

        when:
        Boolean result = topic.validate()

        then:
        result == expectedOutput

        where:
        n       | author     | visibility          || expectedOutput
        "abcd"  | new User() | Visibillity.PUBLIC  || true
        "xyze"  | new User() | Visibillity.PRIVATE || true
        "ffsvf" | "xyze"     | Visibillity.PRIVATE || false
    }
}
