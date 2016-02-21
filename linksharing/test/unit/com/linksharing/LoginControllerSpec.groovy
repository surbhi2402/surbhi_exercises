package com.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(LoginController)
class LoginControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "testing index action"() {
            when:"calling action for indexing on ogin controller"
            controller.index()

            then:"text failure is rendered"
           // response.forwardedUrl == '/user/index'
            response.contentAsString == "failure!"

    }

    void "testing logout action"(){

        when:"logout is called"
        controller.logout()

        then:
        session.invalidate()
        response.forwardedUrl == '/login/index'
    }


}
