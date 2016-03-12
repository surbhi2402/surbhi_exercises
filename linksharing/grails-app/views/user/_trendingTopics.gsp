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
            <a href="#" style="float:left;color:grey"><u>@${topic.createdBy.username}</u></a>

            <inline>
                <div class="col-sm-4" style="color:grey;margin-left: 40px">Subscription</div>

                <div class="col-sm-4" style="color:grey">Topics</div>
            </inline>

            <inline>
                <div style="float:left"><ls:showSubscribe id="${topic.id}"/></div>

                <div class="col-sm-3" style="color:grey; margin-left:45px"><ls:subscriptionCount
                        userId="${userDetails.id}"/></div>

                <div class="col-sm-3" style="color:grey"><ls:topicCount/></div>

                <ls:canUpdateTopic topicId="${topic.id}"/>
            </inline>

        </div>
    </div>

    </div>
    <hr>
</g:each>
</div>