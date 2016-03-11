<div class="panel panel-default">
    <div class="panel panel-heading" style="height: 40px">
        <div class="pull-left">Subscriptions</div>

        <div class="pull-right"><a href="#"><u>View All</u></a></div>
    </div>

<div class="panel-body">
    <g:each in="${posts}" var="post">
        <div class="left" style="float: left">
            <ls:userImage id="${session.user.id}"/>
        </div>
        </div>
        <br>
        <div class="col-xs-offset-3" class="row">
            <a href="#" style="float:left"><u>${post.topic}</u></a>
            <br>

            <div>

                <a href="#" style="float:left;color:grey"><u>@${post.createdBy.username}</u></a>

                <div class="col-sm-4" style="color:grey">Subscription</div>

                <div class="col-sm-4" style="color:grey">Topics</div>


                <div class="col-sm-3" style="color:grey"><a href="#">50</a></div>

                <div class="col-sm-3" style="color:grey"><a href="#">30</a></div>

            </div>

            <br>
            <br>
            <!--Drop downs of subscription panel-->
            <ls:canUpdateTopic topicId="${post.topic.id}"/>
        </div>
        <br>
        <hr>

    </g:each>
</div>


</div>
