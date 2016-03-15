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
<div class="container-fluid">

    <div class="col-xs-6" style="float: left">
        <g:render template="/user/userInfo" model="[userDetails: userDetails]"/>

        <g:render template="/user/subscriptions"
                  model="[userDetails: userDetails, subscribeTopics: subscribeTopics]"/>

        <ls:trendingTopics/>
    </div>

    <div class="col-xs-6 pull-right">
        <g:render template="/user/inbox" model="[readingItemList: readingItemList]"/>
    </div>

</div>
</body>
</html>