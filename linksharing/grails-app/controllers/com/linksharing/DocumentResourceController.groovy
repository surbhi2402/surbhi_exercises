package com.linksharing

import com.link.sharing.core.DocumentResource
import com.link.sharing.core.Resource
import com.link.sharing.core.Topic
import grails.transaction.Transactional

class DocumentResourceController extends ResourceController {

    def index() {
        render "inside document resource!"
    }

//    def save(String filePath, String description, Integer topic1) {
//        Topic topic = Topic.findById(topic1)
//        Resource resource = new DocumentResource(description: description, createdBy: session.user, topic: topic, filePath: filePath)
//        if (resource.validate()) {
//            resource.save(flush: true)
//            render "Document saved successfully"
//        } else {
//            render "Document not saved!!"
//        }
//    }


    @Transactional
    def save(DocumentResource documentResource) {
        documentResource.createdBy = session.user
        def file = params.file
        if (file.empty) {
            flash.error = "File is Empty"
        } else {
            String path = "${grailsApplication.config.grails.document.file.server}/${UUID.randomUUID()}.pdf"
            documentResource.contentType = params.file.contentType

            documentResource.filePath = path

            if (documentResource.validate()) {


                documentResource.save(flush: true)
                File destinationFile = new File(path)
                params.file.transferTo(destinationFile)
                flash.message = "Document Resource Saved"
            } else {
                flash.error = "Resource not Saved -- ${documentResource.errors.allErrors}"
            }
            //addToReadingItems(documentResource)
        }
        redirect(controller: 'login', action: 'index')
    }
}
