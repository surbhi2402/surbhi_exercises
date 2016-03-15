<div class="panel panel-default">
    <div class="panel panel-heading" data-tooltip="true" title="Unread Items">User Posts</div>

<g:each in="${posts}" var="post">
    <div class="panel-body">
        <div class="left" style="float: left">
            <ls:userImage id="${session.user.id}"/>
        </div>
    </div>

    <div class="col-xs-offset-2">
        <h4>${post.topic.name}<i style="color: grey">       ${post.createdBy.username}</i>
            <g:link style="float: right" controller="topic" action="show" params='[topicId: "${post.topic.id}"]'>${post.topic.name}</g:link>
        </h4>

        <p>${post.description}</p>
        <a href="#"><i class="fa fa-facebook fa-fw"></i></a>
        <a href="#"><i class="fa fa-twitter fa-fw"></i></a>
        <a href="#"><i class="fa fa-google-plus fa-fw"></i></a>
        <a href="#" style="margin-left: 180px">
            %{--<ls:checkType id="${post.id}" url="${post.}"--}%
                          %{--filePath="${inbox.filePath}"/>--}%
            %{--<ls:markRead isRead="${post.}" resourceId="${inbox.resourceID}"/>--}%
            <g:link controller="resource" action="viewPost"
                    params='[id: "${post.id}"]' style="float: right">View Post</g:link>
    </div>
    <hr>
    </div>
</g:each>
</div>