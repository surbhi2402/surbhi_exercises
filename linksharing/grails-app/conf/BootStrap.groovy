import com.link.sharing.core.DocumentResource
import com.link.sharing.core.LinkResource
import com.link.sharing.core.ReadingItem
import com.link.sharing.core.Resource
import com.link.sharing.core.ResourceRating
import com.link.sharing.core.Subscription
import com.link.sharing.core.Topic
import com.link.sharing.core.User
import com.ttnd.linksharing.Enum.Seriousness
import com.ttnd.linksharing.Enum.Visibillity
import com.ttnd.linksharing.constants.Constants

class BootStrap {

    def init = { servletContext ->

        List<User> users = createUsers()
        createTopic()
        List<Resource> resources = createResources()
        List<ReadingItem> readingItems =createReadingItems()
        //List<ResourceRating> resourceRatings = createResourceRatings()
    }


    List<User> createUsers() {

        List<User> users = []

        User normalUser = new User(email: "normal@tothenew.com", password: Constants.DEFAULT_PASSWORD, firstName: "normal", admin: false, username: "surbhi", lastName: "dhawan")
        User adminUser = new User(email: "admin@tothenew.com", password: "jitin", firstName: "admin", admin: true, username: "jitin", lastName: "dominic")

        if (User.count() == 0) {

            log.info "No users exist, hence add new users"
            if (normalUser.save(flush: true, failOnError: true) && adminUser.save(flush: true, failOnError: true)) {

                users.add(normalUser)

                users.add(adminUser)

                log.info "Users saved successfully"

            } else {
                log.error "Error in saving user"
            }

            return users
        }
    }

    void createTopic() {

        List<User> users = User.list()
        //List<Topic> topics= new Topic()

        users.each {

            user ->
                if (!user.topics?.count()) {

                    (1..5).each {

                        Topic topic = new Topic(name: "topic" + it, createdBy: user, visibility: Visibillity.PUBLIC)
                        user.addToTopics(topic)
                        topic.save()
                    }
                    user.save()
                }

        }

    }

    List<Resource> createResources() {
        List<Topic> topics = Topic.list()
        List<Resource> resources = []

        topics.each
                {
                    topic ->
                        if (!topic.resources?.count()) {
                            2.times
                                    {
                                        Resource documentResource = new DocumentResource(description: "${topic.name}Doc${it}", topic: topic, createdBy: topic.createdBy, filePath: "some/file/path")
                                        Resource linkResource = new LinkResource(description: "${topic.name}Link${it}", topic: topic, createdBy: topic.createdBy, url: "http://www.someurl.com")

                                        if (documentResource.save() && linkResource.save()) {
//                                            resources.add(documentResource)
//                                            resources.add(linkResource)
                                            topic.addToResources(documentResource)
                                            topic.addToResources(linkResource)
                                            log.info "${documentResource} and ${linkResource} saved successfully"
                                        } else
                                            log.error "Error saving ${documentResource.errors.allErrors} and ${linkResource.errors.allErrors}"
                                    }

                            if (topic.save())
                                log.info "Topic ${topic} saved successfully"
                            else
                                log.error "Error saving ${topic.errors.allErrors}"
                        }

                }
        return resources
    }

    void subscribeTopics() {
        List<User> users = User.list()
      //  List<Topic> topics = Topic.list()

        users.each { User user ->
                user.topics.each {Topic topic ->
                    if (topic.createdBy != this.user) {
                        Subscription subscription = new Subscription(seriousness: Seriousness.VERY_SERIOUS, user: user, topic: topic)
                        //subscription.validate()
                        if (subscription.hasErrors()) {
                            log.info "Subscrption has errors-> ${subscription.errors}"
                        } else {
                            subscription.save(flush: true)
                            log.info "${subscription} saved successfully"
                        }
                    }

                }
        }

    }

    List<ReadingItem> createReadingItems() {
        List<User> users = User.list()
        List<ReadingItem> readingItems = []

        users.each { User user ->
            user.topics.each { Topic topic ->

                    topic.resources.each { Resource resource ->
                        if ((resource.createdBy != user) && (!user.readingItems?.contains(resource))) {

                            ReadingItem readingItem = new ReadingItem(isRead: false, user: user, resource: resource)
                            if (readingItem.hasErrors()) {
                                log.info "Errors saving -> ${readingItem}"
                            } else {
                                readingItem.save(flush: true)
                                readingItems.add(readingItem)
                                log.info "${readingItem} saved successfully"
                            }
                        }
                    }
                }
            }
        

        return readingItems
        }

   /* List<ResourceRating> createResourceRatings(){
        List<User> users = User.list()
        List<ResourceRating> resourceRatings =[]

        users.each {User user->
            user.readingItems.each {
                ReadingItem readingItem ->
                    if(readingItem.isRead == false){
                        ResourceRating resourceRating = new ResourceRating(resource: readingItem.resource,user:readingItem.user ,score: 3)
                        if(resourceRating.hasErrors()){
                            log.info "Errors saving -> ${resourceRating}"
                        }
                        else {
                            resourceRating.save()
                            resourceRatings.add(resourceRating)
                            log.info "${resourceRating} saved successfully"
                        }
                    }
            }

        }
        return resourceRatings
    }*/






        def destroy = {

    }
}