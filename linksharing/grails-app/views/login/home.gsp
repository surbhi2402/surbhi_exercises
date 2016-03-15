<%--
  Created by IntelliJ IDEA.
  User: surbhi
  Date: 26/2/16
  Time: 5:21 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main">
</head>

<body>

<div class="container-fluid">

    <div class="col-xs-6" style="float: left">
        <g:render template="/login/recentShares" model="[recentShares: recentShares]"/>

        <ls:topPosts/>
    </div>

    <div class="col-xs-6 pull-right">
        <g:render template="/login/form"/>

        <g:render template="/user/forgotPasswd"></g:render>

        <g:render template='/user/registration' model="[user: user]"></g:render>
    </div>

</div>
</body>
</html>