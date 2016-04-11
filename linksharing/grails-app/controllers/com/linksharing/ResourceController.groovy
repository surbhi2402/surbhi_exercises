package com.linksharing

import com.link.sharing.core.LinkResource
import com.link.sharing.core.ReadingItem
import com.link.sharing.core.Resource
import com.link.sharing.core.ResourceRating
import com.link.sharing.core.Subscription
import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Co.ResourceSearchCo
import com.ttnd.linksharing.Enum.Visibility
import com.ttnd.linksharing.Vo.PostVO
import com.ttnd.linksharing.Vo.RatingInfoVo
import com.ttnd.linksharing.Vo.TopicVo
import com.ttnd.linksharing.Vo.UserVO
import grails.plugin.springsecurity.annotation.Secured
import net.sf.ehcache.search.expression.Criteria

@Secured(['ROLE_ADMIN','ROLE_USER'])

class ResourceController {

    def resourceService
    def index() {
        render(view: 'resourceSearch')
    }

    def delete(Long id) {
        User user = session.user
        if (user.canDeleteResource(id)) {
            Resource resource = Resource.get(id)
            resource.delete(flush: true)
            UserVO userDetails = user.getUserDetails()
            List<PostVO> readingItems = ReadingItem.getInboxItems(session.user)
            println "${readingItems}"
            render(view: '/user/dashboard', model: [subscribeTopics: user.subscribeTopics, readingItemList: readingItems, userDetails: userDetails])
        } else {
            render "Resource does not exists"
        }
    }

    def search(ResourceSearchCo co) {
        User user = session.user
        if (co.q) {
            co.visibility = Visibility.PUBLIC
        }
        UserVO userDetails = user.getUserDetails()
        List<Resource> resources = Resource.search(co).list()
        render(template: '/topic/viewSearch', model: [post: resources])
    }


    def viewPost(Long id) {
        User user = session.user
        List<PostVO> readingItems = ReadingItem.getInboxItems(user)
        Resource resource = Resource.read(id)
        UserVO userDetails = user.getUserDetails()
        if (Resource.canViewBy(user, id)) {
            render(view: '/resource/resourceSearch', model: [readingItemList: readingItems, resource: resource, userDetails: userDetails])
        } else {
            render "you cannot view this resource"
        }
    }


    private def addToReadingItems(Resource resource) {
        Topic topic = resource.topic
        List userList = topic.getSubscribedUsers()

        userList.each {
            User user ->
                if (Subscription.findByUserAndTopic(user, topic)) {
                    if (resource.createdBy.id == user.id) {
                        ReadingItem readingItem = new ReadingItem(isRead: true, user: user, resource: resource)
                        user.addToReadingItems(readingItem)
                        readingItem.save(flush: true)
                    } else {
                        ReadingItem readingItem = new ReadingItem(isRead: false, user: user, resource: resource)
                        user.addToReadingItems(readingItem)
                        readingItem.save(flush: true)
                    }
                }
        }
    }

    def ViewPostOnHome(Long id) {
//        List<PostVO> readingItems = ReadingItem.getInboxItems(user)
        Resource resource = Resource.read(id)
//        UserVO userDetails = user.getUserDetails()

        render(template: 'viewResource', model: [resource: resource])
    }


    def save(Long id, String description) {
        if (session.user) {
            Resource resource = Resource.get(id)
            if (resource) {
               boolean isUpdated =Resource.executeUpdate("update Resource as r set r.description=:description where r.id=:id",[description:description,id:id])

                if (isUpdated) {
                    resource.refresh()
//                    flash.message = "Resource Description Updated!"
                    redirect(controller:'user',action: 'index')
                } else {
                    flash.error = "Resource Description is not Updated"
                    render flash.error
                }
            } else {
                flash.error = "Resource not Found"
                render flash.error
            }
        } else {
            flash.error = "Session User not Set"
            render flash.error
        }

    }


//def editResource(Long resourceId,String description){
//
//}


    def edit(String description, Long resourceId) {
        Resource resource = Resource.get(resourceId)
        User user = session.user
        if (user && resource) {
            if (resource.createdBy == user) {
                resource.description = description
                resource.save(flush: true)
            } else {
                flash.message = "existing user doesn't have permission to update"
            }
        } else {
            flash.error = "not found"
        }
    }


    def globalSearch(String queryString){
        println "---------${queryString}-----------"
            List<Resource> resourceList = Resource.findAllByDescriptionIlike("%${queryString}%")
        List<Resource> resourceList2=Resource.createCriteria().list([max:10,offset:0]){
            ilike("description","%${queryString}%")
        }
        render (view: '/resource/searchPage',model: [resourceList:resourceList2,total:resourceList.size(),queryString:queryString])
    }
    def globalSearch1(String queryString){
        List<Resource> resourceList = Resource.findAllByDescriptionIlike("%${queryString}%")
        List<Resource> resourceList2=Resource.createCriteria().list([max:10,offset:params.offset]){
            ilike("description","%${queryString}%")
        }
        render (template: '/resource/search',model: [resourceList:resourceList2,total:resourceList.size()])
    }

}