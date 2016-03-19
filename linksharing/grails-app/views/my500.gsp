<%--
  Created by IntelliJ IDEA.
  User: surbhi
  Date: 11/3/16
  Time: 12:36 AM
--%>

<!DOCTYPE html>
<html>
<head>
    <title><g:if env="development">Internal Server Error</g:if><g:else>Error</g:else></title>
    <meta name="layout" content="main">
    <g:if env="development"><asset:stylesheet src="errors.css"/></g:if>
</head>
<body>


<p align="center">
    <asset:image src="uh_oh_1x.png" width="500" height="500"/>
</p>

<g:if env="development">
    <g:renderException exception="${exception}" />
</g:if>
<g:else>
    <ul class="errors">
        <li>An error has occurred</li>
    </ul>
</g:else>
</body>
</html>
