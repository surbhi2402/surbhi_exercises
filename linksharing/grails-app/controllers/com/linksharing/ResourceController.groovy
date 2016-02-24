package com.linksharing

import com.link.sharing.core.Resource
import com.ttnd.linksharing.Co.ResourceSearchCo
import com.ttnd.linksharing.Enum.Visibility

class ResourceController {

    def index() {}

//    def delete(){
//        if(!resource.load(params.id)){
//
//        }

    def search(ResourceSearchCo co){
        if(co.q){
            co.visibility = Visibility.PUBLIC
        }
        List<Resource> resources = Resource.search(co).list()
        render resources
    }
    }

