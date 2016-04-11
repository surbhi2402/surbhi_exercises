

%{--Login module--}%
    <div class="panel panel-default">
        <div class="panel panel-heading">Login</div>

        <div class="panel-body">

            <form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
                <p>
                    <label for='username'><g:message code="springSecurity.login.username.label"/>:</label>
                    <input type='text' class='text_' name='j_username' id='username'/>
                </p>

                <p>
                    <label for='password'><g:message code="springSecurity.login.password.label"/>:</label>
                    <input type='password' class='text_' name='j_password' id='password'/>
                </p>

                <p id="remember_me_holder">
                    <input type='checkbox' class='chk' name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/>
                    <label for='remember_me'><g:message code="springSecurity.login.remember.me.label"/></label>
                </p>

                <p>
                    <input type='submit' id="submit" value='${message(code: "springSecurity.login.button")}'/>
                </p>
            </form>








            %{--<g:form class="form-horizontal" controller="login" action="login">
                <div class="form-group">
                    <label class="control-label col-xs-3">Username</label>

                    <div class="col-xs-9">
                        <g:textField name="username" class="form-control" placeholder="Username"/>
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

                        --}%%{--<g:render template="/user/forgotPasswd"></g:render>--}%%{--
                    --}%%{--<g:actionSubmit value="forgot paswword"--}%%{--
                        --}%%{--<g:link controller="user" action="forgotPassword">Forgot Password</g:link>--}%%{--
                        <g:actionSubmit value="Login" type="submit" action="login" controller="login"
                                        class="btn btn-primary" style="float:right">Login</g:actionSubmit>
                    </div>
                </div>
            </g:form>--}%
        </div>
    </div>