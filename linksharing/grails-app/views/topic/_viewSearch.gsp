<g:each in="${post}" var="topicPost">
    <div class="panel-body" style="height:150px">
        <div style="float:left;font-size:60px" class="glyphicon glyphicon-user"></div>

        <div class="col-xs-offset-2">
            <h4>${topicPost.topic.name}<i style="color: grey">@${topicPost.createdBy.username} @5pm</i><a
                    style="float:right"><u>${topicPost.topic.name}</u></a></h4>

            <p>${topicPost.description}</p>
            <a href="#"><i class="fa fa-facebook fa-fw"></i></a>
            <a href="#"><i class="fa fa-twitter fa-fw"></i></a>
            <a href="#"><i class="fa fa-google-plus fa-fw"></i></a>
            <a href="#" style="margin-left: 180px">
                <a href="#"><u>Download</u>
                    %{--<ls:checkType id="${topicPost.id}" url="${topicPost}"--}%
                    %{--filePath="${inbox.filePath}"/>--}%
                </a></a> <a href="#"><u>View full
        site</u></a> <a href="#">
            %{--<ls:markRead isRead="${}" resourceId="${topicPost.id}"/>--}%
        </a> <a href="#"><u>View Posts</u></a></a>
        </div>
    </div>
    <hr>
</g:each>