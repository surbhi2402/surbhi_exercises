package com.im.test

import spock.lang.Ignore
import spock.lang.IgnoreRest
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class TransactionSpec extends Specification {

@IgnoreRest
        def "selling a product to customer:when values are correct"(){

            given:"a user"
            User user = new User(balance: 1000)

            and:"a product"
            Product product = new Product(price: 500)

            and:"a transaction"
            Transaction transaction = new Transaction()

            when:"called sell method"
            transaction.sell(product,user)

            then:"no exeption should be thrown"
            //user.balance==user.balance-product.price
            notThrown(SaleException)

        }

    def "selling a product to customer:when values are incorrect"(){

        given:"a user"
        User user = new User(balance: 200)

        and:"a product"
        Product product = new Product(price: 500)

        and:"a transaction"
        Transaction transaction = new Transaction()

        when:"called sell method"
        transaction.sell(product,user)

        then:"no exeption should be thrown"
        thrown(SaleException)
    }

        def "cancellation of sale"(){

            given:
            Product product = new Product(name: "xyz",price: 576)

            and:
            User user = new User(balance: 1000)

            and:
            Transaction transaction = new Transaction()

            and:
            def mockedEmailService = Mock(EmailService)
            transaction.emailService = mockedEmailService

            when:
            transaction.cancelSale(product,user)

            then:
            transaction.emailService.sendCancellationEmail(user,_ as String)


        }


            def "calculating discount"(){

                given:
                Product product = new Product(name: "abcd",price: p, discountType: "PRIVELLEGE_ONLY")

                and:
                User user = new User(isPrivellegedCustomer: true,balance: 100)

                and:
                Transaction transaction = new Transaction()

                when:
                def result = transaction.calculateDiscount(product,user)

                then:
                result == expectedResult

            where:
            p |expectedResult
            50|15

            }

      /*
        //!!!! doubt!!!!!
    @IgnoreRest
    def "get popular products"(){

        given:
        Product product = new Product(name: "handbag",isPopular: true)

        Transaction transaction = new Transaction()

        and:
        product.metaClass.getCurrentProducts = {return }

        when:
       List<Product> l1 =transaction.getAllPopularProducts()

        then:
        l1.contains(p1)==true
    }*/










 /*   @Shared transaction = new Transaction()

    void "Sell subtracts the balance of a user by the price of the product and adds product to the purchased products"(){
        setup:
        Product product = new Product(price: 100)
        User user = new User(balance: 200)

        when:
        transaction.sell(product, user)

        then:
        user.balance ==  100.toBigDecimal()
    }


    void "Improvement #1 Sell subtracts the balance of a user by the price of the product and adds product to the purchased products"(){
        given:
        Product product = new Product(price: 100)

        and:
        User user = new User(balance: 200)

        when:
        transaction.sell(product, user)

        then:
        user.balance ==  100.toBigDecimal()
    }


    void "Improved #2 Sell subtracts the balance of a user by the price of the product and adds product to the purchased products"(){
        given:
        Product product = new Product(price: 100)

        and:
        User user = new User(balance: 200)

        expect:
        !user.isPrivellegedCustomer
        product.discountType == DiscountType.NONE

        when:
        transaction.sell(product, user)

        then:
        user.balance ==  100.toBigDecimal()
    }


    void "An exception is thrown if user's balance is not enough"(){
        given:
        Product product = new Product(price: 100)

        and:
        User user = new User(balance: 50)

        when:
        transaction.sell(product, user)

        then:
        def e =thrown(SaleException)
        e.message == "Not enough account balance"
    }

    void "Improvement #1 An exception is thrown if user's balance is not enough"(){
        given:
        Product product = new Product(price: 100)

        and:
        User user = new User(balance: balance)

        when:
        transaction.sell(product, user)

        then:
        def e =thrown(SaleException)
        e.message == "Not enough account balance"

        where:
        balance << [50, 0]
    }

    @Unroll("An exception is thrown when #description")
    void "Improvement #2 An exception is thrown if user's balance is not enough"(){
        given:
        Product product = new Product(price: 100)

        and:
        User user = new User(balance: balance)

        when:
        transaction.sell(product, user)

        then:
        def e =thrown(SaleException)
        e.message == "Not enough account balance"

        where:
        balance << [50, 0]

        description = balance==50?'less than product cost': 'user has no balance'
    }*/


}
