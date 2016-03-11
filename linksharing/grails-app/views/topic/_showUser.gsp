    <div class="col-xs-5" style="float: left;width: 500px">
        <div class="panel panel-default">
            <div class="panel panel-heading">User:${topic.name}</div>

            <g:each in="${subscribedUsers}" var="user">

                <div class="panel-body" style="height:150px">
                    <div style="float:left;font-size:60px" class="glyphicon glyphicon-user"></div>

                    <div class="col-xs-offset-2">

                        <h4>${user.username}<i style="color: grey">@${topic.createdBy.username} 5pm</i><a
                                style="float:right"><u>${user.email}</u></a></h4>

                        <p>${topic.visibility}</p>
                        <br>
                        <br>
                        <a href="#"><i class="fa fa-facebook fa-fw"></i></a>
                        <a href="#"><i class="fa fa-twitter fa-fw"></i></a>
                        <a href="#"><i class="fa fa-google-plus fa-fw"></i></a>
                        <a href="#" style="margin-left: 70px"><a href="#"><u>Download</u></a></a> <a
                            href="#"><u>View full
                        site</u></a><a href="#"><u>View Posts</u></a>
                    </div>
                </div>
                <hr>
            </g:each>

        </div>
    </div>