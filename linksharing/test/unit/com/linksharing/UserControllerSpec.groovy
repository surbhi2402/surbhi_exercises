package com.linksharing

import com.link.sharing.core.LinkResource
import com.link.sharing.core.ReadingItem
import com.link.sharing.core.Resource
import com.link.sharing.core.Subscription
import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Co.UserCo
import com.ttnd.linksharing.DTO.EmailDTO
import com.ttnd.linksharing.Util
import com.ttnd.linksharing.Vo.PostVO
import com.ttnd.linksharing.Vo.UserVO
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.util.mop.ConfineMetaClassChanges

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UserController)
@Mock([User, Resource, ReadingItem, Subscription])
@ConfineMetaClassChanges([User, ReadingItem])
class UserControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "testing user controller index action"() {
        given:

        User user = new User(username: "surbhi", password: "abcdefhgh", confirmPassword: "abcdefhgh", email: "newuser@tothenew.com", firstName: "surbhi", lastName: "dhawan")
        user.save(validate: false)
        controller.session.user = user

        user.metaClass.getUserDetails = {
            new UserVO()
        }
        user.metaClass.getSubscribeTopics = {
            [new Topic()]
        }
        ReadingItem.metaClass.static.getInboxItems = { User user1 ->
            [new PostVO()]
        }

        when:
        controller.index()

        then:
        model.subscribeTopics.size() == 1
        model.readingItemList.size() == 1
        view == "/user/dashboard"
    }


    void "testing register action for new user"() {
        setup:
        User user = new User(username: "surbhi", password: "abcdefhgh", confirmPassword: "abcdefhgh", email: "newuser@tothenew.com", firstName: "surbhi", lastName: "dhawan")
        user.save(validate: false, flush: true)

        user.metaClass.getUserDetails = {
            new UserVO()
        }
        controller.session.user = user

        and:
        UserCo userCo = new UserCo(username: "surbhi", password: "abcdefhgh", confirmPassword: "abcdefhgh", email: "newuser1@tothenew.com", firstName: "surbhi", lastName: "dhawan")

        when:
        controller.register(userCo)

        then:
//        model.userDetails.size() == 1
        view == "/user/dashboard"
    }

    void "testing registration when user not saved successfully"() {
        setup:
        UserCo userCo = new UserCo(username: "surbhi", password: "abfhgh", confirmPassword: "abcdefhgh", email: "newuser@tothenew.com", firstName: "surbhi", lastName: "dhawan")

        when:
        controller.register(userCo)

        then:
        view == "/login/home"
    }

//    void "testing getScore"() {
//        given:
//        Resource resource = new LinkResource(url: "https://www.google.com")
//        resource.save(validate: false,flush: true)
//
//        when:
//        controller.getScore()
//
//    }


//    void "testing forgot password template"() {
//
//        given:
//        User user = new User(email: "a@a.com").save(validate: false)
//
//        and:
//        def mockedEmailService = Mock(EmailService)
//        def mockedUtil = Mock(Util)
//
//        and:
//        EmailDTO emailDTO = new EmailDTO(to:[user.email],subject:"new Subject for testing")
//
//        and:
//        controller.emailService = mockedEmailService
//        mockedEmailService.sendMail(emailDTO)
//
//        and:
//        User.metaClass.static.updatePassword={
//            newPassword,email -> return 1
//        }
//
//        when:
//        controller.forgotPassword(user.email)
//
//        then:
//        1 * mockedEmailService.sendMail(emailDTO)
//    }


}
