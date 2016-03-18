<div class="col-xs-6" style="float: left;width: 500px">
    <div class="panel panel-default">
        <div class="panel panel-heading">Users</div>


        <div class="panel-body">
            <g:each in="${subscribedUsers}" var="user">
                <div style="float:left;font-size:60px" class="glyphicon glyphicon-user"></div>

                <div class="col-xs-offset-2">

                    <h4>${user.username}<i style="color: grey">@${topic.createdBy.username} 5pm</i></h4>

                    <p>${topic.name}</p>
                    <br>
                    <br>
                    <a href="#"><i class="fa fa-facebook fa-fw"></i></a>
                    <a href="#"><i class="fa fa-twitter fa-fw"></i></a>
                    <a href="#"><i class="fa fa-google-plus fa-fw"></i></a>

                </div>

                <hr>
            </g:each>
        </div>
    </div>
</div>