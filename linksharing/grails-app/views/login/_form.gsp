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