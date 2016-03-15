<div class="panel panel-default">
    <div class="panel panel-heading">Change Password</div>

    <div class="panel-body">
        <g:form class="form-horizontal" id="updatePassword" name="updatePassword" controller="user"
                action="updatePassword" method="post">
            <input type="hidden" name="userId" value="${session.user.id}"/>
            <div class="form-group">
                <label class="pull-left" style="margin-left:10px">Old Password*</label>

                <div class="col-xs-9">
                    <g:passwordField name="oldPassword"  style="margin-left: 25px" class="form-control" id="oldPassword" placeholder="New Password"/>
                </div>
            </div>

            <div class="form-group">
                <label class="pull-left" style="margin-left: 10px">New Password*</label>

                <div class="col-xs-9">
                    <g:passwordField name="password" class="form-control" id="password" style="margin-left: 20px"
                                 placeholder="Confirm Password"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-xs-9"></div>

                <div class="col-xs-3">
                    <g:actionSubmit action="updatePassword" value="Update" type="submit"
                                    class="btn btn-success">Update</g:actionSubmit>
                </div>
            </div>
        </g:form>
    </div>
</div>
