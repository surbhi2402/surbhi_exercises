package com.link.sharing.core

import com.ttnd.linksharing.constants.Constants
import grails.transaction.Transactional

class DocumentResource extends Resource {

    String filePath
    String fileName
    String contentType

    static transients = ['contentType', 'fileName']

    static constraints = {
        filePath(blank: false)
        fileName(bindable:true,nullable:true,blank:true)
        contentType(bindable: true, blank: false, validator: { val, obj ->
            return val.equals(Constants.DOCUMENT_CONTENT_TYPE)
        })
    }

    String toString() {
        filePath
    }

       String getContentType() {
           this.contentType
       }

    void setContentType(String cType) {
        contentType = cType
    }

    @Transactional
    Boolean deleteFile() {
        String filePath = createCriteria().get {
            projections {
                property('filePath')
            }
            eq('id', this.id)
        }
        boolean fileDeleted = new File(filePath).delete()
        if (fileDeleted) {
            this.delete(flush: true)
            return true
        } else {
            return false
        }
    }

}
