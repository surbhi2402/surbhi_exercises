<div class="col-xs-7" style="float: right;width: 700px;height: 700px">
    <div class="panel panel-default" style="height:430px">
        <div class="panel panel-heading" data-tooltip="true" title="Unread Items">Post:</div>

        <g:each in="${post}" var="topicPost">
        <div class="panel-body" style="height:150px">
            %{--<g:each in="${topics}" var="topic">--}%
                <div style="float:left;font-size:60px" class="glyphicon glyphicon-user"></div>

                <div class="col-xs-offset-2">
                    <h4>${topicPost.topic}<i style="color: grey">@${topicPost.createdBy} @5pm</i><a
                    style="float:right"><u>${topicPost.topic.name}</u></a></h4>

                <p>${topicPost.description}</p>
                <a href="#"><i class="fa fa-facebook fa-fw"></i></a>
                <a href="#"><i class="fa fa-twitter fa-fw"></i></a>
                <a href="#"><i class="fa fa-google-plus fa-fw"></i></a>
                <a href="#" style="margin-left: 180px"><a href="#"><u>Download</u></a></a> <a href="#"><u>View full
            site</u></a> <a href="#"><u>Mark as read</u></a> <a href="#"><u>View Posts</u></a></a>
            </div>

        </div>
        </g:each>
        <hr>
    </div>
</div>
