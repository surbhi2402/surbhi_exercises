package com.link.sharing.core

import grails.test.mixin.TestFor
import spock.lang.Specification
import com.ttnd.linksharing.Enum.Seriousness

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Subscription)
class SubscriptionSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "testing subscripton class"() {

        given:
        Subscription subscription = new Subscription(user: uname, topic: topic, seriousness: seriousness)

        when:
        Boolean result = subscription.validate()

        then:
        result == expectedOutput

        where:
        uname      | topic       | seriousness              || expectedOutput
        new User() | new Topic() | Seriousness.CASUAL       || true
        new User() | "topic1"    | Seriousness.VERY_SERIOUS || false
    }
}
