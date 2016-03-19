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

<a href="#" data-toggle="modal" data-target="#editResource" data-tooltip="true"
   title="Edit Resource Description"></a>


    <div class="col-xs-6" style="float: left">
        <g:render template="viewResource" model="[readingItemList: readingItemList, resource: resource]"/>
        <g:render template="/resource/edit" model="[post: resource]"/>
    </div>

    %{--<div class="col-xs-6">--}%
        <ls:trendingTopics/>
    %{--</div>--}%


</body>
</html>