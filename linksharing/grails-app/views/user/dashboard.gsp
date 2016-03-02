<%--
  Created by IntelliJ IDEA.
  User: surbhi
  Date: 26/2/16
  Time: 6:19 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main">
</head>
<body>
    %{--<g:render template="inbox"></g:render>--}%


<div class="col-xs-5">
    <div class="row" style="margin:9px">
        <g:render template="/user/userInfo"/>
    </div>

    <div class="row" style="margin:9px">
        <g:render template="/user/subscriptions"/>
    </div>

    <div class="row" style="margin:9px">
        <g:render template="/user/trendingTopics"/>
    </div>
</div>


</body>
</html>