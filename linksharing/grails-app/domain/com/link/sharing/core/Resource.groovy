package com.link.sharing.core

import com.ttnd.linksharing.Co.ResourceSearchCo
import com.ttnd.linksharing.Vo.RatingInfoVo

abstract class Resource {

    String description
    User createdBy
    Topic topic
    Date dateCreated
    Date lastUpdated

    static hasMany=[resourceRatings:ResourceRating,readingItems:ReadingItem]

    static belongsTo = [topic:Topic]

    static transients = ['ratingInfo']

    RatingInfoVo getRatingInfo(){
            List result = ResourceRating.createCriteria().get{
                'resource'{
                    eq('id',this.id)
                }
                projections {
                    sum('score')
                    avg('score')
                    count('score')
                }
            }
        RatingInfoVo ratingInfoVo = new RatingInfoVo(totalVotes: result[0],totalScore: result[2],averageScore: result[1])
        ratingInfoVo
    }

    static mapping = {
        description(type:'text')
    }
    static namedQueries = {
        search { ResourceSearchCo co ->
            if(co.topicId) {
                'topic'{
                    eq('id',co.topicId)
                    eq('visibility',co.visibility)
                }
            }
        }
    }

   static List<Resource> showTopPost(){
        List topicsss = ResourceRating.topPost()
        List ids=[]
        topicsss.each {
            ids.add(it[0])
        }
        List<Resource> resources=Resource.getAll(ids)
        resources
    }

    String toString(){
        createdBy
    }

}





