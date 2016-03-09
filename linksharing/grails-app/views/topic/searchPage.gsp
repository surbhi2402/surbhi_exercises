<%--
  Created by IntelliJ IDEA.
  User: surbhi
  Date: 3/3/16
  Time: 11:17 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main">
</head>

<body>
<div class="col-xs-5">
    <div class="row" style="margin:9px">
        <ls:trendingTopics/>
    </div>

    <div class="row" style="margin:9px">
        <ls:topPosts/>
    </div>
</div>

<div class="col-xs-7">
    <g:render template="/topic/showPost"/>
</div>
</body>
</html>