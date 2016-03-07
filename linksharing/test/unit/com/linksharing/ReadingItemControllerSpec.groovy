package com.linksharing

import com.link.sharing.core.ReadingItem
import com.link.sharing.core.Resource
import com.link.sharing.core.User
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ReadingItemController)
@Mock([ReadingItem, User, Resource])
class ReadingItemControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "testing index action"() {
        when:
        controller.index()

        then:
        view == '/user/dashboard'
    }

//    @IgnoreRest
//    void "testing isRead action"() {
//
//        setup:
//        id = 1L
//        when:
//        controller.changeIsRead(1L, true)
//        then:
//        response.text == "Reading Item isRead successfully changed. ~SUCCESS~"
//    }
}
