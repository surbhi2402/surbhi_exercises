package com.link.sharing.core

import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }


    @Unroll("#description")
    def "testing user spec"() {

        given: "a user"
        User user = new User(email: email, firstName: fname, lastName: lname, password: passwd, username: uname)

        when:
        Boolean result = user.validate()

        then:
        //user.hasErrors()
        result == expectedOutput

        where:
        description | email             | fname     | lname     | passwd     | uname   || expectedOutput
        "passed"    | "test@gmail.com"  | "surbhi"  | "dhawan"  | "abcd12"   | "test1" || true
        "failed"    | "abcd"            | "shalika" | "singhal" | "xyz123"   | "test2" || false
        "failed"    | null              | "saloni"  | "sharma"  | "abcdefgh" | "test3" || false
        "failed"    | "sui@gmail.com"   | "ecbdfd"  | "fdfwv"   | ""         | "test4" || false
        "failed"    | "abcd@gnmail.com" | null      | "dhawan"  | "gtshdt"   | "test5" || false


    }

    def "email id of user should be unique"() {
        given:
        User user = new User(firstName: "sakshi", lastName: "singhal", email: "sakshi@tothenew.com", password: "sakshi", username: "ss")

        when:
        user.save()


        then:
        user.count() == 1

        when:
        User user2 = new User(firstName: "priyanka", lastName: "gupta", email: "sakshi@tothenew.com", password: "sakshi", username: "pg")
        user2.save()

        then:
        User.count() == 1
        user2.errors.allErrors.size() == 1
        user2.errors.getFieldErrorCount("email") == 1

    }


    def "test name property that is transient"() {

        given:
        User user = new User(firstName: fname, lastName: lname, email: mail, password: passwod, username: uname)

        when:
        user.getName()

        then:
        user.name == result

        where:
        fname    | lname    | mail                  | passwod   | uname || result
        "surbhi" | "dhawan" | "surbhi@tothenew.com" | "abcdef"  | "sd"  || "surbhi dhawan"
        "sakshi" | null     | "sakshi@tothenew.com" | "avdferv" | "ss"  || "sakshi"
    }
}
