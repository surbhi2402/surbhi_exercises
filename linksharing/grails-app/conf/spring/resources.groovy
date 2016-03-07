import com.ttnd.linksharing.CustomBean

// Place your Spring DSL code here
beans = {

    myBean(com.ttnd.linksharing.CustomBean){bean ->
        bean.scope = 'prototype'

        name = "surbhi"
    }

    customBean1(com.ttnd.linksharing.CustomBean,"Surbhi"){}
}
