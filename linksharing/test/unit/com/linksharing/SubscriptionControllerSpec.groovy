package com.linksharing

import com.link.sharing.core.Subscription
import com.ttnd.linksharing.Enum.Seriousness
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(SubscriptionController)
@Mock([Subscription])
class SubscriptionControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "testing update action when subsription is not found"() {
        when:
        controller.update(1L, "VERY_SERIOUS")

        then:
        response.contentAsString == "failure in saving subscription"
    }

//    void "testing update action when subscription is found"(){
//
//        setup:
//        Subscription subscription = new Subscription(id: 42L,seriousness: Seriousness.SERIOUS)
//        subscription.save(validate: false)
//        when:
//        controller.update(42L,"VERY_SERIOUS")
//        then:
//        response.contentAsString == "subscription found and updated successfully"
//    }
}
