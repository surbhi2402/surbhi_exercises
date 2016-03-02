<div class="col-xs-7">
    <div class="panel panel-default">
        <div class="panel panel-heading" style="height:40px">Top Posts</div>
        <div class="panel-body">
            <g:each in="${resources}" var="post">
                <div style="float:left;font-size:60px" class="glyphicon glyphicon-user img thumbnail"></div>
                <h4>${post.createdBy.name}<a href="#" style="float:right">Grails</a></h4>
                <p>${post.description}</p>
                <a href="#"><i class="fa fa-facebook fa-fw"></i></a>
                <a href="#"><i class="fa fa-twitter fa-fw"></i></a>
                <a href="#"><i class="fa fa-google-plus fa-fw"></i></a>
                <a href="#" style="float:right"><u>View Posts</u></a>
                <hr>
            </g:each>
        </div>
    </div>
</div>