package com.link.sharing.core


import grails.test.mixin.TestFor
import spock.lang.Specification
import com.ttnd.linksharing.Enum.Visibility

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
        n       | author     | visibility         || expectedOutput
        "abcd"  | new User() | Visibility.PUBLIC  || false
        "xyze"  | new User() | Visibility.PRIVATE || false
        "ffsvf" | "xyze"     | Visibility.PRIVATE || false
    }
}
