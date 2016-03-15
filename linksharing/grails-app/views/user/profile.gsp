<%--
  Created by IntelliJ IDEA.
  User: surbhi
  Date: 11/3/16
  Time: 4:43 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>User Public Profile</title>
    <meta name="layout" content="main">
</head>

<body>
<div class="container-fluid">

    <div class="col-xs-5" style="float: left">
        <g:render template="/user/userInfo" model="[userDetails:userDetails]"/>

        <g:render template="/user/topics" model="[topicsCreated:topicsCreated]"/>

        <g:render template="/user/userSubscriptions" model="[subscribedTopics:subscribedTopics]"/>

    </div>

    <div class="col-xs-6 pull-right">
        <g:render template="/user/userPost" model="[posts:posts]"/>
    </div>

</div>
</body>
</html>