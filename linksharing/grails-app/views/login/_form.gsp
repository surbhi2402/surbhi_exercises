<div class="col-xs-7">
    <div class="panel panel-default">
        <div class="panel panel-heading">Recent shares</div>
        <div class="panel-body">
            %{--<div style="float:left;font-size:60px" class="glyphicon glyphicon-user img thumbnail"></div>--}%
            <div class="panel-body">
                <g:each in="${recentShares}" var="share">
                    <div style="float:left;font-size:60px" class="glyphicon glyphicon-user img thumbnail"></div>
                    <h4>${share.createdBy.username}<a href="#" style="float:right">${share.topic}</a></h4>
                    <p>${share.description}</p>
                    <a href="#"><i class="fa fa-facebook fa-fw"></i></a>
                    <a href="#"><i class="fa fa-twitter fa-fw"></i></a>
                    <a href="#"><i class="fa fa-google-plus fa-fw"></i></a>
                    <a href="#" style="float:right"><u>View Posts</u></a>
                    <hr>
                </g:each>
            </div>
        </div>
    </div>
    <hr>
</div>


%{--Login module--}%
<div class="col-xs-5" style="float: right">
    <div class="panel panel-default">
        <div class="panel panel-heading">Login</div>
        <div class="panel-body">
            <g:form class="form-horizontal">
                <div class="form-group">
                    <label class="control-label col-xs-3">Username</label>
                    <div class="col-xs-9">
                        <g:textField name="username" class="form-control" placeholder="Name"/>
                    </div>
                </div>


                <div class="form-group">
                    <label for="inputPassword" class="control-label col-xs-3">Password</label>
                    <div class="col-xs-9">
                        <g:passwordField name="password" class="form-control" id="inputPassword" placeholder="Password"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-xs-offset-3 col-xs-9">
                        <a href="#">Forgot Password</a>
                        <g:actionSubmit value="login" type="submit" action="login" controller="login" class="btn btn-primary" style="float:right">Login</g:actionSubmit>
                    </div>
                </div>
            </g:form>
        </div>
    </div>
</div>