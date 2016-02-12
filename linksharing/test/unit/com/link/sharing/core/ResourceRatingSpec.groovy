package com.link.sharing.core

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ResourceRating)
class ResourceRatingSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "testing resource rating"() {
        given:
        ResourceRating resourceRating = new ResourceRating(resource: resource, user: user, score: score)

        when:
        Boolean result = resourceRating.validate()

        then:
        result == expectedOutput

        where:
        resource               | user       | score || expectedOutput
        new LinkResource()     | new User() | 1      | true
        new DocumentResource() | new User() | 0     || false
        new DocumentResource() | null       | 1     || false
        new DocumentResource() | ""         | 3     || false
        new LinkResource()     | "abcd"     | 4     || false
        null                   | null       | 4     || false
        null                   | new User() | 1     || false

    }
}
