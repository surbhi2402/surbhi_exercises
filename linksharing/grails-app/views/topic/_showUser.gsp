<div class="col-xs-5" style="float: left;width: 500px;height: 500px">
<div class="panel panel-default">
    <div class="panel panel-heading">User:Post</div>

    <g:each in="${subscribedUsers}" var="user">

        <div class="panel-body" style="height:150px">
        <div style="float:left;font-size:60px" class="glyphicon glyphicon-user"></div>
         <div class="col-xs-offset-2">

        <h4>Surbhi<i style="color: grey">@uday 5pm</i><a
        style="float:right"><u>${user.email}</u></a></h4>

        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been
    the industry's standard dummy text ever since the 1500s..</p>
    <a href="#"><i class="fa fa-facebook fa-fw"></i></a>
    <a href="#"><i class="fa fa-twitter fa-fw"></i></a>
    <a href="#"><i class="fa fa-google-plus fa-fw"></i></a>
    <a href="#" style="margin-left: 180px"><a href="#"><u>Download</u></a></a> <a href="#"><u>View full
site</u></a> <a href="#"><u>Mark as read</u></a> <a href="#"><u>View Posts</u></a>
                 </div>
        </div>
        <hr>
</g:each>


</div>
</div>