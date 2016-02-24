package com.linksharing

import com.link.sharing.core.Resource
import com.ttnd.linksharing.Co.ResourceSearchCo
import com.ttnd.linksharing.Enum.Visibility

class ResourceController {

    def index() {
        render "Inside resource!"
    }

    def delete(Long id) {
        Resource resource = Resource.get(id)
        if (!resource) {
            render "Resource does not exists"
        }else {
            resource.delete()
            render "Resource deleted successfully!"
        }
    }

        def search(ResourceSearchCo co) {
            if (co.q) {
                co.visibility = Visibility.PUBLIC
            }
            List<Resource> resources = Resource.search(co).list()
            render resources
        }

}

