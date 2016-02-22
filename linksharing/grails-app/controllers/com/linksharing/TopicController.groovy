package com.linksharing

import com.link.sharing.core.Topic
import com.ttnd.linksharing.Enum.Visibillity

class TopicController {

    def index() {

        render "inside index"
    }
    def show() {
        println "under show"
        def topic
        topic = Topic.get(params.id)

        if(!topic){
            redirect(controller: "user", action: "index")
            flash.error = "No topic in database"
        }
        else {
            if(Visibillity.PUBLIC){
                render "success"
            }
            else if(Visibillity.PRIVATE) {
                if (session.user) {

                render "Can not see the topic as it's private topic"
            }
                else {
                    redirect(controller: "user",action: "login")
                    flash.error = "user not subscribed to this private topic"
                }
            }
        }
    }
}
