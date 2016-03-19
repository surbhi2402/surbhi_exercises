import com.link.sharing.core.Employee
import com.ttnd.linksharing.CustomBean

// Place your Spring DSL code here
beans = {

    myBean(com.ttnd.linksharing.CustomBean){bean ->
        bean.scope = 'prototype'

        name = "surbhi"
    }

    customBean1(com.ttnd.linksharing.CustomBean,"Surbhi"){}

        demoBean2(Employee){
            firstName = "pawan"
            lastName = "dhawan"
        }
}
