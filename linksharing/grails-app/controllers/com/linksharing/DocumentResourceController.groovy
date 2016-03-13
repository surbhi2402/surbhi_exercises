package com.linksharing

import com.link.sharing.core.DocumentResource
import com.link.sharing.core.Resource
import com.link.sharing.core.Topic
import grails.transaction.Transactional

class DocumentResourceController extends ResourceController {

    def index() {
        render "inside document resource!"
    }

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
                addToReadingItems(documentResource)
                flash.message = "Document Resource Saved"
            } else {
                flash.error = "Resource not Saved -- ${documentResource.errors.allErrors}"
            }
            //addToReadingItems(documentResource)
        }
        redirect(controller: 'login', action: 'index')
    }

    def download(Long id){
        DocumentResource documentResource = (DocumentResource)Resource.get(id)
        if(!documentResource){
            render "resource not found!!"
        }
        if(Resource.canViewBy(session.user,id)){
            def file = new File(documentResource.filePath)

            if (file.exists()) {
                response.setContentType("application/pdf")
                response.setHeader("Content-disposition", "filename=${file.name}")
                response.outputStream << file.bytes
                redirect controller: 'login' ,action: 'index'
            }
        }
    }
}
