<div class="panel panel-default">
    <div class="panel panel-heading" style="height: 40px">
        <div class="pull-left">Topics</div>

        <div class="pull-right"><a href="#"><u>View All</u></a></div>
    </div>

<div class="panel-body">
    <g:each in="${topicsCreated}" var="topic">
        <div class="left" style="float: left">
            <ls:userImage id="${session.user.id}"/>
        </div>
        </div>
        <br>
        <div class="col-xs-offset-3" class="row">
            <g:link controller="user" action="profile" style="float: left"
                    params="[id: session.user.id, topicId: 0, visibility: com.ttnd.linksharing.Enum.Visibility.PUBLIC]">@${topic.createdBy.username}</g:link>

            %{--<a href="#" style="float:left"><u>${topic.createdBy.firstName}</u></a>--}%
            <br>

            <div>

                <a href="#" style="float:left;color:grey">@${topic.name}</a>

                <div class="col-sm-4" style="color:grey">Subscription</div>

                <div class="col-sm-4" style="color:grey">Topics</div>


                    <ls:showSubscribe id="${topic.id}"></ls:showSubscribe>


                <div class="col-sm-3" style="color:grey;margin-left: 90px"><ls:subscriptionCount topicId="${topic.id}"/></div>

                <div class="col-sm-3" style="color:grey"><ls:topicCount/></div>

            </div>

            <br>
            <br>
            <!--Drop downs of subscription panel-->
            <ls:canUpdateTopic topicId="${topic.id}"/>
        </div>
        <br>
        <hr>

    </g:each>
</div>


</div>
