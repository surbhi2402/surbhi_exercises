package com.link.sharing.core

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DocumentResource)
class DocumentResourceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "testing document resource class"() {

        given:
        DocumentResource documentResource = new DocumentResource(topic: topic, createdBy: author, filePath: path, description: desc)

        when:
        Boolean result = documentResource.validate()

        then:
        result == expectedOutput

        where:
        topic       | author     | path           | desc            || expectedOutput
        new Topic() | new User() | "/home/surbhi" | "new file path" || true
        new Topic() | new User() | null           | "path2"         || false
        new Topic() | new User() | ""             | "path3"         || false
    }
}
