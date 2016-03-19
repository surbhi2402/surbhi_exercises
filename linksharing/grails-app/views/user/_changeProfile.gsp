<div class="panel panel-default">
    <div class="panel panel-heading">Profile</div>

    <div class="panel-body">
        <g:form class="form-horizontal" id="changeProfile" name="changeProfile" controller="user"
                action="modifyUserProfile" enctype="multipart/form-data" method="post">

            <div class="form-group">
                <label class="pull-left" style="margin-left: 10px">First Name*</label>

                <div class="col-xs-9">
                    <g:textField style="margin-left: 50px" name="firstName" class="form-control" id="inputFname" placeholder="${session.user.firstName}"/>
                </div>
            </div>

            <div class="form-group">
                <label class="pull-left" style="margin-left: 10px">Last Name*</label>

                <div class="col-xs-9">
                    <g:textField name="lastName" style="margin-left: 52px" class="form-control" id="inputLname" placeholder="${session.user.lastName}"/>
                </div>
            </div>

            <div class="form-group">
                <label class="pull-left" style="margin-left: 10px">Username*</label>

                <div class="col-xs-9">
                    <g:textField name="userName" style="margin-left: 55px" class="form-control" id="inputUsername" placeholder="${session.user.username}"/>
                </div>
            </div>

            <div class="form-group">
                <label class="pull-left" style="margin-left:10px">Photo</label>

                <div style="margin-left:50px">
                    <div class="col-xs-3">
                        <input type="file" id="pic" name="pic" width="60" height="60" style="margin-left: 90px">
                    </div>

                </div>
            </div>

            <div class="form-group">
                <div class="col-xs-9"></div>

                <div class="col-xs-3">
                    <g:actionSubmit action="modifyUserProfile" value="Update" type="submit"
                    class="btn btn-success">Submit</g:actionSubmit>
                </div>
            </div>
        </g:form>
    </div>
</div>