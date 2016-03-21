package com.linksharing

import com.link.sharing.core.ReadingItem
import com.link.sharing.core.Resource
import com.link.sharing.core.Subscription
import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Co.UserCo
import com.ttnd.linksharing.Vo.UserVO
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UserController)
@Mock([User, Resource,ReadingItem,Subscription])
class UserControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @IgnoreRest
    void "testing user controller index action"() {
        given:
        User user = new User(username: "surbhi", password: "abcdefhgh", confirmPassword: "abcdefhgh", email: "newuser@tothenew.com", firstName: "surbhi", lastName: "dhawan")
        user.save(validate: false)

        user.metaClass.getSubscribeTopics ={
            [new Topic()]
        }
        ReadingItem.metaClass.getInboxItems ={
            [new ReadingItem()]
        }
        user.metaClass.getUserDetails ={
            [new UserVO()]
        }

        when:
        controller.index()

        then:
        model.subscribeTopics.size() == 1
        model.readingItems.size() == 1
        model.userDetails.size() == 1
        view == "/user/dashboard"

    }




    void "testing register action if user is already registered"() {
        setup:
        session.user = true

        and:
        UserCo userCo = new UserCo()

        when:
        controller.register(userCo)

        then:
        response.contentAsString == "You are already Registered-----"
    }


    void "testing register action for new user"() {
        setup:
        User user = new User(username: "surbhi", password: "abcdefhgh", confirmPassword: "abcdefhgh", email: "newuser@tothenew.com", firstName: "surbhi", lastName: "dhawan")
        user.save(validate: false)

        user.metaClass.userDetails ={
            [user]
        }

        and:
        UserCo userCo = new UserCo(pic: "123".getBytes())

        when:
        controller.register(userCo)

        then:
//        controller.session.user == user
        model.userDetails.size() == 1
        view == "/user/dashboard"
    }

//    void "testing register action for unsuccessful registration"() {
//        setup:
//        UserCo userCo = new UserCo()
//        userCo.validate()
//        when:
//        controller.register(userCo)
//
//        then:
//        response.contentAsString == "validation succeeded-----"
//    }

    void "testing forgot password template"() {
        when:
        controller.forgotPassword()
        then:
        view == '/user/forgotPassword'
    }
}
