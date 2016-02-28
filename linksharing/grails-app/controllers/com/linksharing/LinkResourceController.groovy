package com.linksharing

import com.link.sharing.core.LinkResource
import com.link.sharing.core.Resource
import com.link.sharing.core.Topic

class LinkResourceController {

    def index() {
        render "inside Link Resource"
    }

    def save(String link, String description,Topic topic){
        Resource resource = new LinkResource(description: description,createdBy: session.user,topic: topic,url: link)
//        println "${description}  ${session.user}  ${topic} ${link}"
        if(resource.validate()){
            resource.save(flush: true)
            render "link saved successfully"
        }
        else {
            render "link not saved!!"
        }
    }



//    def save(String name, String visibility) {
//        println "***inside save of topic"
//
//        Topic topic = new Topic(name: name, createdBy: session.user, visibility: Visibility.convert(visibility))
//        if (topic.validate()) {
//            topic.save(flush: true)
//            flash.message = "Success"
//            render flash.message
//        } else {
//            render topic.errors
//            log.error(" Could not save Topic ${topic.name}")
//            flash.message = "Topic ${topic.name} does not satisfied constraints"
//            render flash.message
//
//        }
//
//    }
}
