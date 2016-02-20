import com.link.sharing.core.DocumentResource
import com.link.sharing.core.LinkResource
import com.link.sharing.core.ReadingItem
import com.link.sharing.core.Resource
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

  /*  void subscribeTopics() {
        List<User> users = User.list()
        List<Topic> topics = Topic.list()

        users.each {
            user ->
                topics.each { topic ->

                    if (topic.createdBy != user) {

                        Subscription subscription = new Subscription(seriousness: Seriousness.VERY_SERIOUS, user: user, topic: topic)

                        subscription.validate()
                        if (subscription.hasErrors()) {
                            log.info "Subscrption has errors-> $subscription.errors"
                        } else {
                            subscription.save(flush: true)
                            log.info "${subscription} saved successfully"
                        }
                    }

                }
        }

    }*/

    void createReadingItems() {
        List<User> users = User.list()
        users.each { User user ->
            user.subscriptions.each {Subscription subscription ->
                subscription.topic.resources.each {
                    ReadingItem readingItem = new ReadingItem(isRead: false, user: user, resource: resource)
                    readingItem.save()
                }
            }
        }
    }


    def destroy = {

    }
}

