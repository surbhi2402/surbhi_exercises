<%--
  Created by IntelliJ IDEA.
  User: surbhi
  Date: 13/3/16
  Time: 10:43 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Private Profile</title>
    <meta name="layout" content="main">
</head>

<body>
<div class="container-fluid">

    <div class="col-xs-5" style="float: left">
        <g:render template="/user/userInfo" model="[userDetails:userDetails]"/>

        <g:render template="/user/topics" model="[topicsCreated:topicsCreated]"/>

    </div>

    <div class="col-xs-6 pull-right">

        <g:render template="changeProfile"/>
        <g:render template="changePassword"/>
    </div>

</div>

</body>
</html>