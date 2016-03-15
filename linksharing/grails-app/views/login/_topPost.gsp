    <div class="panel panel-default">
        <div class="panel panel-heading" style="height:40px">Top Posts</div>

        <div class="panel-body">
            <g:each in="${resources}" var="post">
                <div style="float:left;font-size:60px" class="glyphicon glyphicon-user img thumbnail"></div>
                <div class="col-xs-offset-2">
                <h4>${post.createdBy.firstName}<a href="#" style="float:right">${post.topic.name}</a></h4>

                <p>${post.description}</p>
                <a href="#"><i class="fa fa-facebook fa-fw"></i></a>
                <a href="#"><i class="fa fa-twitter fa-fw"></i></a>
                <a href="#"><i class="fa fa-google-plus fa-fw"></i></a>
                <a href="#" style="float:right">View Posts</a>
                </div>
                <hr>
            </g:each>
        </div>
    </div>
