<div class="panel panel-default">
    <div class="panel panel-heading">Recent shares</div>

    <g:each in="${recentShares}" var="share">
        <div class="panel-body">
            <div style="float:left;font-size:60px" class="glyphicon glyphicon-user"></div>

            <div class="col-xs-offset-2">
                <h4>${share.createdBy.firstName}</h4>

                <div style="float: right">
                    <g:link controller="topic" action="show"
                            params='[topicId: "${share.topic.id}"]'>${share.topic.name}</g:link>
                </div>

                <p>${share.description}</p>
                <a href="#"><i class="fa fa-facebook fa-fw"></i></a>
                <a href="#"><i class="fa fa-twitter fa-fw"></i></a>
                <a href="#"><i class="fa fa-google-plus fa-fw"></i></a>

                %{--<a href="#" style="float:right">--}%
                    <g:link controller="resource" action="viewPostOnHome" style="float: right"
                            params='[id: "${share.topic.id}"]'>View Post</g:link>

            %{--</a>--}%
            </div>
            <hr>
        </div>
    </g:each>
</div>
