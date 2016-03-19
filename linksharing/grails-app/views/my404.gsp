<%--
  Created by IntelliJ IDEA.
  User: surbhi
  Date: 10/3/16
  Time: 1:33 PM
--%>

<!DOCTYPE html>
<html>
<head>
    <title><g:if env="development">Runtime Exception</g:if><g:else>Error</g:else></title>
    <meta name="layout" content="main">
    <g:if env="development"><asset:stylesheet src="errors.css"/></g:if>
</head>
<body>


<p align="center">
<asset:image src="404-error.jpg" width="500" height="500"/>
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
