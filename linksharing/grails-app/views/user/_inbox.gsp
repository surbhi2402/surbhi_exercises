%{--<div class="panel panel-default" style="height:370px">--}%
%{--<div class="panel panel-heading" data-tooltip="true" title="Unread Items">Inbox</div>--}%

%{--<div class="panel-body" style="height:130px">--}%
%{--<div style="float:left;font-size:60px" class="glyphicon glyphicon-user"></div>--}%

%{--<div class="col-xs-offset-2">--}%
%{--<h4>Uday Pratap singh <i style="color: grey">@uday 5pm</i><a href="#" style="float:right"><u>Grails</u>--}%
%{--</a></h4>--}%

%{--<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been--}%
%{--the industry's standard dummy text ever since the 1500s..</p>--}%
%{--<a href="#"><i class="fa fa-facebook fa-fw"></i></a>--}%
%{--<a href="#"><i class="fa fa-twitter fa-fw"></i></a>--}%
%{--<a href="#"><i class="fa fa-google-plus fa-fw"></i></a>--}%
%{--<a href="#" style="margin-left: 180px"><a href="#"><u>Download</u></a></a> <a href="#"><u>View full--}%
%{--site</u></a> <a href="#"><u>Mark as read</u></a> <a href="#"><u>View Posts</u></a></a>--}%

%{--</div>--}%
%{--</div>--}%
%{--<hr>--}%

%{--<div class="panel-body" style="height:130px">--}%
%{--<div style="float:left;font-size:60px" class="glyphicon glyphicon-user"></div>--}%

%{--<div class="col-xs-offset-2">--}%
%{--<h4>Uday Pratap singh <i style="color: grey">@uday</i><a href="#" style="float:right"><u>Grails</u></a>--}%
%{--</h4>--}%

%{--<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been--}%
%{--the industry's standard dummy text ever since the 1500s..</p>--}%
%{--<a href="#"><i class="fa fa-facebook fa-fw"></i></a>--}%
%{--<a href="#"><i class="fa fa-twitter fa-fw"></i></a>--}%
%{--<a href="#"><i class="fa fa-google-plus fa-fw"></i></a>--}%
%{--<a href="#" style="margin-left: 180px"><a href="#"><u>Download</u></a>--}%
%{--<a href="#"><u>View full site</u></a>--}%
%{--<a href="#"><u>Mark as read</u></a>--}%
%{--<a href="#"><u>View Posts</u></a>--}%
%{--</a>--}%

%{--</div>--}%
%{--</div>--}%

%{--</div>--}%



















%{--<div class="col-xs-6" style="width: 700px">--}%
<div class="panel panel-default">
    <div class="panel panel-heading" data-tooltip="true" title="Unread Items">Inbox</div>

    <g:each in="${readingItemList}" var="inbox">
        <div class="panel-body" style="height:150px">
            <div style="float:left;font-size:60px" class="glyphicon glyphicon-user"></div>

            <div class="col-xs-offset-2">
                <h4>${inbox.topicName}<i style="color: grey">${inbox.userFirstName}</i><a href="#"
                                                                                          style="float:right"><u>${inbox.topicName}</u>
                </a>
                </h4>

                <p>${inbox.description}</p>
                <a href="#"><i class="fa fa-facebook fa-fw"></i></a>
                <a href="#"><i class="fa fa-twitter fa-fw"></i></a>
                <a href="#"><i class="fa fa-google-plus fa-fw"></i></a>
                <a href="#" style="margin-left: 180px">
                <ls:checkType id="${inbox.resourceID}" url="${inbox.url}"
                              filePath="${inbox.filePath}"/>

                <ls:markRead isRead="${inbox.isRead}" resourceId="${inbox.resourceID}"></ls:markRead>
                <g:link controller="resource" action="viewPost"
                        params='[id: "${inbox.resourceID}"]'>View Post</g:link>
            </div>
            <hr>
        </div>
    </g:each>
</div>
%{--</div>--}%

