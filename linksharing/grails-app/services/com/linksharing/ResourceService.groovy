package com.linksharing

import com.link.sharing.core.Resource
import com.ttnd.linksharing.Co.ResourceSearchCo
import grails.transaction.Transactional

class ResourceService {

    static transactional = false

    def serviceMethod() {

    }

    List<Resource> search(ResourceSearchCo resourceSearchCo) {
        Resource.resourceSearch(resourceSearchCo.getUser()).list() as List<Resource>
    }

    def editResourceDescription(Resource resource, String description) {
        if (resource && description) {
            resource.description = description
            if (resource.hasErrors()) {
                return false
            } else {
                resource.save(flush: true)
                println "${resource.properties}"
                return true
            }
        }
    }
}
