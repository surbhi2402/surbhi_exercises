package com.link.sharing.core

import com.ttnd.linksharing.Co.UserSearchCO
import com.ttnd.linksharing.Vo.UserVO
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService

	String username
	String password
    String email
    String firstName
    String lastName
    Byte[] photo
    String confirmPassword
    Date dateCreated
    Date lastUpdated
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	User(String username, String password) {
		this()
		this.username = username
		this.password = password
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this)*.role
	}

//	def beforeInsert() {
//		encodePassword()
//	}
//
//	def beforeUpdate() {
//		if (isDirty('password')) {
//			encodePassword()
//		}
//	}

//	protected void encodePassword() {
//		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
//	}

	static transients = ['springSecurityService', 'name', 'confirmPassword', 'subscribeTopics']

	static constraints = {
		username blank: false, unique: true
		password blank: false
        email(unique: true, blank: false, nullable: false, email: true)
        password(nullable: false, blank: false, minSize: 5, validator: { value, object -> if (value.size() < 5) return false })
//        confirmPassword nullable: true, blank: true, minSize: 5, bindable: true,
//                validator: { val, obj ->
////                    !obj.id &&
//                    if (val != obj.password) {
//                        // return "object.password.not.match"
//                        return false
//                    } else {
//                        return true
//                    }

//                }
        firstName(nullable: false, blank: false)
        photo(nullable: true)

    }

	static mapping = {
		password column: '`password`'
        photo(sqlType: 'blob')
        sort id: 'desc'
	}


    static hasMany = [topics: Topic, subscriptions: Subscription, readingItems: ReadingItem, resources: Resource]

    String getName() {


        [firstName, lastName].findAll { it }.join(' ')
        //return "${firstName}${lastName}"
    }

    List<Topic> getSubscribeTopics() {
        List<Topic> topics = Subscription.createCriteria().list() {
            projections {
                property('topic')
            }
            eq('user.id', this.id)
        }
        return topics
    }

    User save() {
        User user = this
        user.validate()
        if (user.hasErrors()) {
            log.error("Error in saving user: ${user.errors}")
        } else {
            user.save(flush: true)
            log.info "Users saved successfully"
        }
        return user
    }

    Boolean canDeleteResource(Long id) {
        Resource resource = Resource.read(id)
        println "=====${resource.id}================"
        if ( resource.createdBy.id == this.id) {
            return true
        } else {
            return false
        }
    }

    Boolean canDeleteTopic(Long id){
        Topic topic = Topic.get(id)
        if(this.admin || topic.createdBy.id == this.id){
            return true
        }else {
            return false
        }
    }

    Boolean isSubscribed(Long topicId) {
        Topic topic = Topic.load(topicId)
        if (Subscription.findByUserAndTopic(this, topic)) {
            return true
        } else {
            return false
        }
    }

    static namedQueries = {
        search { UserSearchCO userSearchCO ->
//            eq('admin', false)
            if (userSearchCO.active != null) {
                eq("active", userSearchCO.active)
            }

            if (userSearchCO.q) {
                or {
                    ilike("firstName", "%${userSearchCO.q}%")
                    ilike("lastName", "%${userSearchCO.q}%")
                    ilike("email", "%${userSearchCO.q}%")
                    ilike("username", "%${userSearchCO.q}%")

                }
            }
        }
    }

    UserVO getUserDetails() {
        return new UserVO(id:id,email: email, username: username, fname: firstName, lname: lastName, photo: photo)
    }


    Subscription getSubscription(Long topicId){
        Topic topic = Topic.get(topicId)
        return Subscription.findByUserAndTopic(this,topic)
    }

    public Boolean equals(Long userId){
        User user = User.get(userId)
        if(this == user){
            return true
        }
        else {
            return false
        }
    }

    static Integer updatePassword(String newPassword, String email) {
        return executeUpdate("update User set password=:newPassword where email=:email",
                [newPassword: newPassword, email: email])
    }


    List<Resource> unreadResources() {
        return ReadingItem.createCriteria().list {
            projections {
                property('resource')
            }
            eq('user', this)
            eq('isRead', false)
        }
    }

    Boolean isAdmin(){
        if( this.authorities.contains(Role.findByAuthority('ROLE_ADMIN')))
            return true
        else
            false
          }

}
