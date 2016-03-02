package com.linksharing

import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Co.UserCo
import com.ttnd.linksharing.Vo.TopicVo

class UserController {

    def index() {
        List<TopicVo> trendingTopics = Topic.getTrendingTopics()
        render(view: 'dashboard' ,model:[subscribeTopics:session.user.subscribeTopics,trendingTopics:trendingTopics])
        //render "User Dashboard ${params.username}"
    }

    def register(UserCo userCo) {
        println "inside register"

        if (session.user) {
            render "You are already Registered"
        } else {
            User user = new User(email:userCo.email,firstName: userCo.firstName,lastName: userCo.lastName,password: userCo.password,username: userCo.username,confirmPassword: userCo.confirmPassword )

            if (user?.hasErrors()) {
                    render "validation failed!!!"
                } else {
                    user.save(flush: true)
                    render "validation succeeded"
                }
            }

        render "-----"
        }


    def createForm(){
        render (view: 'myForm.gsp')
    }
}
