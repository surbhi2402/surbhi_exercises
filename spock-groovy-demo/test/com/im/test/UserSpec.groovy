package com.im.test

import groovyjarjarantlr.collections.List
import spock.lang.Ignore
import spock.lang.IgnoreRest
import spock.lang.Specification


class UserSpec extends Specification {

    @IgnoreRest
    def "get users full name #fname #lname"(){
        given: "We have user object"
        User user = new User(firstName: fname , lastName: lname)

        when:
        String fullname = user.getFullName()

        then:
        fullname != null
        fullname == result

        where:
        fname       | lname     || result
        "Surbhi"    |"Dhawan"   ||"Surbhi Dhawan"
        null        |null       || "null null"
        ""          | ""        || " "
        "Surbhi"    | null      || "Surbhi null"
    }

    def "Display user name"() {
        given: "display name"
        User user1 = new User(firstName: "surbhi", lastName: "Dhawan")

        and:
        user1.gender = "Female"

        when:
        user1.displayName()

        then:
        user1.displayName() == "Ms surbhi Dhawan"
    }

    def "Is valid password"() {

        given:
        User user2 = new User(firstName: "surbhi", lastName: "Dhawan")

        when:
        boolean result = user2.isValidPassword("axschgvafsf")

        then:
        result == true

    }

    def "encrypt pasword mocking"() {

        given:
        User user = new User()

        and:
        def mockedEncrypterService = Mock(PasswordEncrypterService)
        user.passwordEncrypterService = mockedEncrypterService

        and: "creating a stub"
        mockedEncrypterService.encrypt(_) >> { result }

        when:
        String result1 = user.encryptPassword(password)

        then:
        result1 == result

        where:
        password | result
        "test" | null
        "afsvfvdesw" | "ok"


    }


    def "reset Password And Send Email"(){
    given:
    User user=new User(password:"abcdefghi")

        and:
        def mockedEmailService = Mock(EmailService)

        user.emailService = mockedEmailService

        when:
        user.resetPasswordAndSendEmail()

        then:
        user.emailService.sendCancellationEmail(user, _ as String)
    }


    def "get income group spec"() {

        given:
        User user = new User(incomePerMonth:i)


        expect:
        result3 == useuserr.getIncomeGroup()

        //then:
        // result3 == expectedresult

        where:
        i | result3
        2000 | "MiddleClass"
        10000|"Lower MiddleClass"
        11000|"Lower MiddleClass"

    }


    def "Product purchased"(){

            given:
            User user=new User()

            and:
            Product product =new Product()

            when:
            user.purchase(product)

            then:
            user.purchasedProducts.contains(product) == true


        }

        def "cancel purchase"(){

            given:
            User user=new User()

            and:
            Product product = new Product()

            when:
            user.cancelPurchase(product)

            then:
            user.purchasedProducts.contains(product) != true

        }

    def "to get sorted interested categories"(){

        given:
        User user = new User()
        user.metaClass.getInterestedInCategories = {return ['c','b','a']}

        when:
        def sortedCategories = user.getSortedInterestedInCategories()

        then:
        sortedCategories == ['a','b','c']


    }

}


