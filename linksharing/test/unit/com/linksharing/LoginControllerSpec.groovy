package com.linksharing

import com.link.sharing.core.User
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(LoginController)
@Mock([User])
class LoginControllerSpec extends Specification {




    void "when session is set, user is forwarded to user index"(){
        setup:
        controller.session.user = new User()
        when:
        controller.index()
        then:
        response.forwardedUrl == '/user/index'
    }

    void "testing index action"() {
            when:"calling action for indexing on login controller"
            controller.index()

            then:"text failure is rendered"
            response.contentAsString == "failure!-> Please login"

    }

    void "testing logout action"(){

        when:"logout is called"
        controller.logout()

        then:
        session.invalidate()
        response.forwardedUrl == '/login/index'
    }

    @IgnoreRest
    void "testing Login Handler function"(){
        setup:
        User user = new User(username: "surbhi",password: "abcdefhgh",active: true,email: "newuser@tothenew.com",firstName: "surbhi",lastName: "dhawan")
        user.save(validate: false)

        when:
        controller.loginHandler("surbhi","abcdefhgh")

        then:
        response.redirectedUrl == '/login/index'
    }

}
