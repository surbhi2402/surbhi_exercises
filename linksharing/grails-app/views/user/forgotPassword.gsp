<%--
  Created by IntelliJ IDEA.
  User: surbhi
  Date: 3/3/16
  Time: 10:42 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main">
</head>

<body>
<div class="panel panel-default" style="float:left;width: 600px;height: 300px;margin-left: 350px">
    <div class="panel panel-heading">Reset Password</div>
    <div class="panel-body">
        <form class="form-horizontal">

            <div class="form-group">
                <label class="pull-left" style="margin-left: 50px">Old Password*</label>
                <div class="col-xs-9">
                    <input class="form-control pull-right" id="old" style="width:400px"
                           placeholder="Old Password">
                </div>
            </div>
            <div class="form-group">
                <label class="pull-left" style="margin-left: 41px">New Password*</label>
                <div class="col-xs-9">
                    <input class="form-control pull-right" id="new" style="width:400px"
                           placeholder="New Password">
                </div>
            </div>
            <div class="form-group">
                <label class="pull-left" style="margin-left: 20px">Confirm Password*</label>
                <div class="col-xs-9">
                    <input class="form-control pull-right" id="inputLname" style="width:400px"
                           placeholder="Confirm Password">
                </div>
            </div>

            <div class="form-group">
                <div class="col-xs-9"></div>
                <div class="col-xs-3">
                    <button type="submit" class="btn btn-success">Update</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>