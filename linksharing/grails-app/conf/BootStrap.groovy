import com.link.sharing.core.*
import com.ttnd.linksharing.Enum.Seriousness
import com.ttnd.linksharing.Enum.Visibility
import com.ttnd.linksharing.constants.Constants

class BootStrap {

    def init = { servletContext ->
        createUsers()
        createTopic()
        List<Resource> resources = createResources()
        subscribeTopics()
        List<ReadingItem> readingItems = createReadingItems()
        List<ResourceRating> resourceRatings = createResourceRatings()
    }


    void createUsers() {
        User normalUser = new User(email: "normal@tothenew.com", password: Constants.DEFAULT_PASSWORD, firstName: "normal", admin: false, username: "surbhi", lastName: "dhawan", confirmPassword: "surbhidhawan", active: true)
        User adminUser = new User(email: "admin@tothenew.com", password: "jitin", firstName: "admin", admin: true, username: "jitin", lastName: "dominic", confirmPassword: "jitin",active: true)

        if (User.count() == 0) {
            normalUser.save()
            adminUser.save()
        }
    }

    void createTopic() {
        User.findAllByEmailInList(["normal@tothenew.com", "admin@tothenew.com"]).each {
            user ->
                if (!user.topics?.size()) {
                    (1..5).each {
                        Topic topic = new Topic(name: "topic" + it, createdBy: user, visibility: Visibility.PUBLIC)
                        topic.save(flush: true, failOnError: true)
                        user.addToTopics(topic)
                    }
                }
        }
    }

    void createResources() {
        List<Topic> topics = Topic.list()
        topics.each { Topic topic ->
            if (!topic.resources?.size()) {
                2.times {
                    Resource documentResource = new DocumentResource(description: "${topic.name}Doc${it}", topic: topic, createdBy: topic.createdBy, filePath: "some/file/path" ,contentType: "application/pdf")
                    Resource linkResource = new LinkResource(description: "${topic.name}Link${it}", topic: topic, createdBy: topic.createdBy, url: "http://www.someurl.com")
                    if (documentResource.save(flush: true, failOnError: true) && linkResource.save(flush: true, failOnError: true)) {
                        topic.addToResources(documentResource)
                        topic.addToResources(linkResource)
                        log.info "${documentResource} and ${linkResource} saved successfully"
                    } else
                        log.error "Error saving ${documentResource.errors.allErrors} and ${linkResource.errors.allErrors}"
                }
            }
        }
    }

    void subscribeTopics() {
        List<User> users = User.list()
        List<Topic> topics = Topic.list()

        users.each { User user ->
            topics.each { Topic topic ->
                if (topic.createdBy != user) {
                    Subscription subscription = new Subscription(seriousness: Seriousness.VERY_SERIOUS, user: user, topic: topic)
                    //subscription.validate()
                    if (subscription.hasErrors()) {
                        log.info "Subscrption has errors-> ${subscription.errors}"
                    } else {
                        subscription.save(flush: true, failOnError: true)
//                        topic.addToSubscrition(subscription)
//                        user.addToSubscription(subscription)
                        log.info "${subscription} saved successfully"
                    }
                }

            }
        }

    }


    List<ReadingItem> createReadingItems() {
        List<User> users = User.list()
        List<Topic> topics = Topic.list()
        List<ReadingItem> readingItems = []
        users.each { User user ->
            topics.each { Topic topic ->
                if (Subscription.findByUserAndTopic(user, topic)) {

                    topic.resources.each { Resource resource ->

                        if ((resource.createdBy != user) && (!user.readingItems?.contains(resource))) {
                            // log.info "*****"
                            ReadingItem readingItem = new ReadingItem(isRead: false, user: user, resource: resource)
                            if (readingItem.hasErrors()) {
                                log.info "Errors saving -> ${readingItem}"
                            } else {
                                readingItem.save(flush: true, failOnError: true)
                                readingItems.add(readingItem)
                                log.info "${readingItem} saved successfully"
                                user.addToReadingItems(readingItem)
                                user.addToReadingItems(readingItem)
                            }
                        }
                    }
                }
            }
        }

        return readingItems
    }

    List<ResourceRating> createResourceRatings() {
        List<User> users = User.list()
        List<ResourceRating> resourceRatings = []

        users.each { User user ->

            user.readingItems?.each {
                ReadingItem readingItem ->
                    if (!readingItem.isRead) {
                        ResourceRating resourceRating = new ResourceRating(resource: readingItem.resource, user: readingItem.user, score: 3)

                        if (resourceRating.hasErrors()) {
                            log.info "Errors saving -> ${resourceRating}"
                        } else {
                            resourceRating.save()
                            resourceRatings.add(resourceRating)
                            log.info "${resourceRating} saved successfully"
                            readingItem.resource.addToResourceRatings(resourceRating)

                        }
                    }
            }

        }
        return resourceRatings
    }

    def destroy = {

    }
}