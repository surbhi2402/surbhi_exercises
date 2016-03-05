<div class="col-xs-7" style="float: right;width: 700px">
    <div class="panel panel-default" style="height:430px">
        <div class="panel panel-heading" data-tooltip="true" title="Unread Items">Inbox</div>
        <g:each in="${readingItemList}" var="inbox">
            <div class="panel-body" style="height:150px">
                <div style="float:left;font-size:60px" class="glyphicon glyphicon-user"></div>

                <div class="col-xs-offset-2">
                    <h4>${inbox.topicName}<i style="color: grey">${inbox.isRead}</i><a href="#" style="float:right"><u>${inbox.topicName}</u></a>
                    </h4>

                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been
                    the industry's standard dummy text ever since the 1500s..</p>
                    <a href="#"><i class="fa fa-facebook fa-fw"></i></a>
                    <a href="#"><i class="fa fa-twitter fa-fw"></i></a>
                    <a href="#"><i class="fa fa-google-plus fa-fw"></i></a>
                    <a href="#" style="margin-left: 180px">
                        %{--<a href="#"><u>Download</u></a></a>--}%
                  <ls:checkType id="${inbox.resourceID}" url="${inbox.url}" filePath="${inbox.filePath}"></ls:checkType>
                    %{--<a href="#"><u>View full site</u></a>--}%
                    <ls:markRead isRead="${inbox.isRead}" resourceId="${inbox.resourceID}"></ls:markRead>
                    <g:link controller="resource" action="viewPost" params='[id:"${inbox.resourceID}"]'>View Post</g:link>
                    %{--<g:link controller="resource" action="viewPost"><u>View Posts</u></g:link></a>--}%

                </div>
                <hr>
            </div>
        </g:each>
    </div>
</div>


%{--Long resourceID--}%
    %{--Integer resourceRating--}%
    %{--String description--}%
    %{--String url--}%
    %{--String filePath--}%
    %{--byte[] userPhoto--}%
    %{--boolean isRead--}%
    %{--String topicName--}%
    %{--String userUserName--}%
    %{--String userFirstName--}%
    %{--String userLastName--}%