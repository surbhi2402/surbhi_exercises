<div class="panel panel-default">
           <div class="panel panel-heading">Trending Topics</div>
<g:each in="${trendingTopics}" var="topic">
    <div class="panel-body">

        <div class="left" style="float: left">
            <ls:userImage id="${session.user.id}"/>
        </div>
    </div>

    <div class="col-xs-offset-3" class="row">
        <g:link controller="topic" action="show" params='[topicId: "${topic.id}"]'>${topic}</g:link>
        <br>

        <div>
            <g:link controller="user" action="profile" style="float: left"
                    params="[id: session.user.id, topicId: 0, visibility: com.ttnd.linksharing.Enum.Visibility.PUBLIC]">@${topic.createdBy.username}</g:link>



            <div class="col-sm-4" style="color:grey;margin-left: 40px">Subscription</div>

                <div class="col-sm-4" style="color:grey">Topics</div>


                <div style="float:left"><ls:showSubscribe id="${topic.id}"/></div>

                <div class="col-sm-3" style="color:grey; margin-left:45px"><ls:subscriptionCount
                        topicId="${topic.id}"/></div>

                <div class="col-sm-3" style="color:grey"><ls:topicCount/></div>
            <br>
            <br>
            <br>


                <ls:canUpdateTopic topicId="${topic.id}"/>


        </div>
    </div>

    </div>
    <hr>
</g:each>
</div>