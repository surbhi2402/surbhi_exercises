<%--
  Created by IntelliJ IDEA.
  User: surbhi
  Date: 3/3/16
  Time: 8:55 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main">
</head>

<body>
<div class="container-fluid">
    <div class="col-xs-6">
        <div class="row" style="margin:9px">
            <g:render template="/topic/showTopic" model="[topic: topic]"/>
        </div>

        <div class="row" style="margin:0px">
            <g:render template="/topic/showUser" model="[subscribedUsers: subscribedUsers, topic: topic]"/>
        </div>
    </div>

    <div class="col-xs-6">
        <g:render template="/topic/showPost" model="[post: post, topics: topic]"/>
    </div>
</div>
</body>
</html>