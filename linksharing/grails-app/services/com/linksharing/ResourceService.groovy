package com.linksharing

import com.link.sharing.core.Resource
import com.ttnd.linksharing.Co.ResourceSearchCo
import grails.transaction.Transactional

@Transactional
class ResourceService {

    def serviceMethod() {

    }

    List<Resource> search(ResourceSearchCo resourceSearchCo){
        Resource.resourceSearch(resourceSearchCo.getUser()).list() as List<Resource>
    }
}
