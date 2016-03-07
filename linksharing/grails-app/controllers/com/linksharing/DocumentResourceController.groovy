package com.linksharing

import com.link.sharing.core.DocumentResource
import com.link.sharing.core.Resource
import com.link.sharing.core.Topic

class DocumentResourceController {

    def index() {
        render "inside document resource!"
    }

    def save(String filePath, String description, Integer topic1) {
        Topic topic = Topic.findById(topic1)
        Resource resource = new DocumentResource(description: description, createdBy: session.user, topic: topic, filePath: filePath)
        if (resource.validate()) {
            resource.save(flush: true)
            render "Document saved successfully"
        } else {
            render "Document not saved!!"
        }
    }
}
