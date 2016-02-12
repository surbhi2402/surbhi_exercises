package com.link.sharing.core

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ReadingItem)
class ReadingItemSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "testing reading item class"() {
        given:
        ReadingItem readingItem = new ReadingItem(user: user,resource: resource,isRead: read)

        when:
        Boolean result = readingItem.validate()

        then:
        result == expectedOutput

        where:
        user       | resource               | read  || expectedOutput
        new User() | new DocumentResource() | false || true
        null       | null                   | true   | false
        null       | new LinkResource()     | true   | false
        new User() | null                   | true  || false
        new User() | new DocumentResource() | null  || false
    }
}
