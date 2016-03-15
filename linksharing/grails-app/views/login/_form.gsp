

%{--Login module--}%
    <div class="panel panel-default">
        <div class="panel panel-heading">Login</div>

        <div class="panel-body">
            <g:form class="form-horizontal" controller="login" action="login">
                <div class="form-group">
                    <label class="control-label col-xs-3">Username</label>

                    <div class="col-xs-9">
                        <g:textField name="username" class="form-control" placeholder="Name"/>
                    </div>
                </div>


                <div class="form-group">
                    <label for="inputPassword" class="control-label col-xs-3">Password</label>

                    <div class="col-xs-9">
                        <g:passwordField name="password" class="form-control" id="inputPassword"
                                         placeholder="Password"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-xs-offset-3 col-xs-9">
                        <g:link controller="user" action="forgotPassword">
                        <a href="#" data-toggle="modal" data-target="#forgotPassword" data-tooltip="true"
                           title="forgot Password">Forgot Password</a></g:link>

                        %{--<g:render template="/user/forgotPasswd"></g:render>--}%
                    %{--<g:actionSubmit value="forgot paswword"--}%
                        %{--<g:link controller="user" action="forgotPassword">Forgot Password</g:link>--}%
                        <g:actionSubmit value="login" type="submit" action="login" controller="login"
                                        class="btn btn-primary" style="float:right">Login</g:actionSubmit>
                    </div>
                </div>
            </g:form>
        </div>
    </div>