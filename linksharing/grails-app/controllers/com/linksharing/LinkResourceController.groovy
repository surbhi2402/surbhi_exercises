package com.linksharing

import com.link.sharing.core.LinkResource
import com.link.sharing.core.Resource
import com.link.sharing.core.Topic
import com.link.sharing.core.User


class LinkResourceController extends ResourceController {

    def index() {
        render "inside Link Resource"
    }

    def save(String link, String description, Integer topic1) {
        Topic topic = Topic.findById(topic1)
        LinkResource linkResource = new LinkResource(description: description, createdBy: session.user, topic: topic, url: link)
        if (linkResource.validate()) {
            linkResource.save(flush: true)

            addToReadingItems(linkResource)
            println "succesfullyy saved linkbdgyuedhbdft"

            render "link saved successfully"
        } else {
            render "link not saved!!"
        }
    }

    def viewFullSite(Long id)

    {
        LinkResource linkResource = LinkResource.findById(id)

        if (linkResource)
            redirect(url: linkResource.url)
        else
            render "cant view full site"


    }
}
