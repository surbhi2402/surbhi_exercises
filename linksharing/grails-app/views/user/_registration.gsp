<div class="col-xs-5 col-xs-offset-9" style="float: right">
<div class="panel panel-default">
    <div class="panel panel-heading">Register</div>
    <div class="panel-body">
        <g:form class="form-horizontal" controller="user" action="register">

            <div class="form-group">
                <label class="control-label col-xs-3">First Name*</label>
                <div class="col-xs-9">
                    <g:textField name="firstName" class="form-control" id="inputFname" placeholder="First Name"/>
                </div>
            </div>
            <div class="form-group">
                <label for="inputLname" class="control-label col-xs-3">Last Name*</label>
                <div class="col-xs-9">
                    <g:textField name="lastName" class="form-control" id="inputLname" placeholder="Last Name"/>
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="control-label col-xs-3">Email*</label>
                <div class="col-xs-9">
                    <g:textField name="email" type="email" class="form-control" id="inputEmail" placeholder="Email"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-3">Username*</label>
                <div class="col-xs-9">
                    <g:textField name="username" class="form-control" id="inputUname" placeholder="User Name"/>
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="control-label col-xs-3">Password*</label>
                <div class="col-xs-9">
                    <g:passwordField name="password" type="password" class="form-control" id="inputPass" placeholder="******"/>
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="control-label col-xs-3">Confirm Password*</label>
                <div class="col-xs-9">
                    <g:passwordField name="confirmPassword" class="form-control" id="inputConfirm" placeholder="*****"/>
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="control-label col-xs-3">Photo</label>
                <div class="col-xs-4">
                    <g:textField name="photo" class="form-control" id="inputPhoto" placeholder="Upload"/>
                </div>

                <div class="col-xs-4">
                    <g:actionSubmit action="register" value="Browse" type="submit" class="btn btn-default">Browse</g:actionSubmit>
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-9"></div>
                <div class="col-xs-3">
                    <g:actionSubmit action="register" value="submit" type="submit" class="btn btn-success">Submit</g:actionSubmit>
                </div>
            </div>
        </g:form>
    </div>
</div>
</div>