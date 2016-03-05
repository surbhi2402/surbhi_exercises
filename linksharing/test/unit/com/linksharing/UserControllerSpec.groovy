package com.linksharing

import com.link.sharing.core.Resource
import com.link.sharing.core.User
import com.ttnd.linksharing.Co.UserCo
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UserController)
@Mock([User,Resource])
class UserControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }


    void "testing user controller index action"() {
        when:
        controller.index()

        then:
        response.contentAsString == "User Dashboard"
//        model.subscribeTopics == session.user.subscribeTopics
//        model.trendingTopics == trendingTopics
        view == "dashboard"
    }


//    void "testing register action if user is already registered"(){
//        setup:
//        mockCommandObject(UserCo.class)
//        UserCo userCo = new UserCo(email:"surbhi@tothenew.com",firstName:"Surabhi",lastName:"Goyal",password:"surbhi",username:"surabhi",confirmPassword:"surbhi")
//        session.user = true
//
//        when:
//        controller.register(userCo)
//
//        then:
//        response.contentAsString ==  "You are already Registered"
//
//    }



//    void "testing register action for new user"(){
//        setup:
//        UserCo userCo = new UserCo(username: "surbhi", password: "abcdefhgh",confirmPassword: "abcdefhgh",email: "newuser@tothenew.com", firstName: "surbhi", lastName: "dhawan")
//        user.save(validate: false)
//
//        when:
//        controller.register(userCo)
//
//        then:
//        response.contentAsString == "validation succeeded"
//    }
}
