package com.linksharing

import com.link.sharing.core.LinkResource
import com.link.sharing.core.Resource
import com.link.sharing.core.Topic

class LinkResourceController {

    def index() {
        render "inside Link Resource"
    }

    def save(String link, String description, Integer topic1) {
        Topic topic = Topic.findById(topic1)
        Resource resource = new LinkResource(description: description, createdBy: session.user, topic: topic, url: link)
        if (resource.validate()) {
            resource.save(flush: true)
            render "link saved successfully"
        } else {
            render "link not saved!!"
        }
    }
}
