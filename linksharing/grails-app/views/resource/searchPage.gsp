<%--
  Created by IntelliJ IDEA.
  User: surbhi
  Date: 13/3/16
  Time: 1:25 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Resource Search Page</title>
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
        <g:render template="/resource/search" model="[resourceList:resourceList,total:total,max:10,offset:0,queryString:queryString]"></g:render>
</div>

</body>
</html>