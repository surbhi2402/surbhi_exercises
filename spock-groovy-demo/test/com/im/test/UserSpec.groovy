package com.im.test

import groovyjarjarantlr.collections.List
import spock.lang.Ignore
import spock.lang.IgnoreRest
import spock.lang.Specification

import java.awt.geom.FlatteningPathIterator


class UserSpec extends Specification {


    def "testing get gender"() {

        given: "a user"
        User user = new User(gender: g)

        when: "get gender is called"
        Boolean result = user.getGender()

        then: "expected result is true or false"
        result == expectedOutput

        where:
        g        || expectedOutput
        "Male"   || true
        "Female" || true
    }


    def "get users full name #fname #lname"() {
        given: "We have user object"
        User user = new User(firstName: fname, lastName: lname)

        when: "get full name is called"
        String fullname = user.getFullName()

        then: "result given out is"
        fullname == result

        where:
        fname    | lname    || result
        "Surbhi" | "Dhawan" || "Surbhi Dhawan"
        null     | null     || "null null"
        ""       | ""       || " "
        "Surbhi" | null     || "Surbhi null"
    }


    def "Display user name"() {

        given: "a user"
        User user1 = new User(firstName: fname, lastName: lname, gender: g)


        when:
        String result = user1.displayName()

        then:
        result == expectedOutput

        where:
        fname    | lname    | g        || expectedOutput
        "Surbhi" | "Dhawan" | "Female" || "Ms Surbhi Dhawan"
        "Nitin"  | "Kumar"  | "Male"   || "Mr Nitin Kumar"
        null     | "Kumar"  | "Male"   || "Mr null Kumar"

    }


    def "Is valid password"() {

        given: "a user"
        User user = new User(firstName: fname, lastName: lname, password: p)

        when: "function is called"
        Boolean result = user.isValidPassword(p)

        then: "expected result is a boolen value"
        result == expectedOutput

        where:
        fname    | lname    | p          || expectedOutput
        "Surbhi" | "Dhawan" | "xyz"      || false
        "Saloni" | "Sharma" | "abcdefgh" || true
        "Surbhi" | "Goyal"  | null       || false
    }


    def "encrypt pasword mocking"() {

        given: "a user"
        User user = new User()

        and: "mocked password encrypt service"
        def mockedEncrypterService = Mock(PasswordEncrypterService)
        user.passwordEncrypterService = mockedEncrypterService

        and: "creating a stub"
        mockedEncrypterService.encrypt(_) >> { result }

        when:
        String result1 = user.encryptPassword(password)

        then:
        result1 == result

        where:
        password     | result
        "test"       | null
        "afsvfvdesw" | "ok"
        null         | null


    }


    def "reset Password And Send Email"() {
        given:
        User user = new User(password: "abcdfgh")

        and:
        def mockedEmailService = Mock(EmailService)
        user.emailService = mockedEmailService

        when:
        user.resetPasswordAndSendEmail()

        then:
        mockedEmailService.sendCancellationEmail(user, _ as String)


    }


    def "get income group spec"() {

        given: "a user"
        User user = new User(incomePerMonth: income)

        when: "get income group called"
        user.getIncomeGroup()

        then: "expected result is gropu"
        expectedOutput

        where:
        income | expectedOutput
        2000   | "MiddleClass"
        10000  | "Lower MiddleClass"
        11000  | "Upper MiddleClass"

    }


    def "Product purchased"() {

        given: "a user"
        User user = new User()

        and: "a product"
        Product product = new Product(name: name)

        when: "purchased a product"
        Boolean result = user.purchase(product)

        then: "it is added to a list"
        user.purchasedProducts.contains(product)

        where:
        name   || output
        "abcd" || true
        null   || false


    }


    def "cancel purchase"() {

        given:
        User user = new User()

        and:
        Product product = new Product(name: name)

        when:
        user.cancelPurchase(product)

        then:
        !user.purchasedProducts.contains(product)

        where:
        name   || output
        "abcd" || false
        null   || true


    }


    def "to get sorted interested categories"() {

        given:
        User user = new User()
        user.metaClass.getInterestedInCategories = { return ['c', 'b', 'a'] }

        when:
        def sortedCategories = user.getSortedInterestedInCategories()

        then:
        sortedCategories == ['a', 'b', 'c']


    }

}


