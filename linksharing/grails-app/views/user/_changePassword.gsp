<div class="panel panel-default">
    <div class="panel panel-heading">Change Password</div>

    <div class="panel-body">
        <g:form class="form-horizontal" id="changePassword" name="changePassword" controller="user"
                action="changePasswordOfUser" method="post">

            <div class="form-group">
                <label class="pull-left" style="margin-left:10px">Password*</label>

                <div class="col-xs-9">
                    <g:passwordField name="newPassword"  style="margin-left: 85px" class="form-control" id="inputPassword" placeholder="New Password"/>
                </div>
            </div>

            <div class="form-group">
                <label class="pull-left" style="margin-left: 10px">Change Password*</label>

                <div class="col-xs-9">
                    <g:passwordField name="confirmUserPassword" class="form-control" id="confirmPassword" style="margin-left: 30px"
                                 placeholder="Confirm Password"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-xs-9"></div>

                <div class="col-xs-3">
                    <g:actionSubmit action="changePasswordOfUser" value="Update" type="submit"
                                    class="btn btn-success">Update</g:actionSubmit>
                </div>
            </div>
        </g:form>
    </div>
</div>
