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
<g:render template='/login/form' model="[recentShares:recentShares]"></g:render>
<g:render template='/user/registration' model="[user:user]"></g:render>
<ls:topPosts/>
</body>
</html>