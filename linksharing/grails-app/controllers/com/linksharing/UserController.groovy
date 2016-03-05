package com.linksharing

import com.link.sharing.core.ReadingItem
import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Co.UserCo
import com.ttnd.linksharing.Vo.PostVO
import com.ttnd.linksharing.Vo.TopicVo

class UserController {

    def index() {
        User user = session.user
        List<TopicVo> trendingTopics = Topic.getTrendingTopics()
        List<PostVO> readingItems =ReadingItem.getInboxItems(user)
        render(view: 'dashboard' ,model:[subscribeTopics:user.subscribeTopics,trendingTopics:trendingTopics,readingItemList:readingItems])
        //render "User Dashboard ${params.username}"
    }

    def register(UserCo userCo) {
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

    def forgotPassword(){
        render(view: '/user/forgotPassword')
    }

}
