<%--
  Created by IntelliJ IDEA.
  User: surbhi
  Date: 3/3/16
  Time: 3:12 PM
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
        %{--<div class="row" style="margin:9px">--}%
        <g:render template="viewResource" model="[readingItemList: readingItemList, resource: resource]"/>
        %{--</div>--}%
    </div>

    <div class="col-xs-5" style="float: right">
        %{--<g:render template="/user/trendingTopics"/>--}%
        <ls:trendingTopics/>
    </div>
</div>

</body>
</html>