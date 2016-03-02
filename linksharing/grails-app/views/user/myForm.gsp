<%--
  Created by IntelliJ IDEA.
  User: surbhi
  Date: 25/2/16
  Time: 10:53 AM
--%>

<%@ page import="com.link.sharing.core.User" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>New Registration Form</title>
    <meta name="layout" content="main">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>

<body>
<g:renderErrors bean="${user}">
    <g:eachError><p><g:message error="${it}"/></p></g:eachError>
</g:renderErrors>
<g:form action="register">
    <label>First Name:</label>
    <g:textField name="firstName"></g:textField><br>
    <label>LastName:</label>
    <g:textField name="latsName"></g:textField><br>
    <label>Password:</label>
    <g:textField name="password"></g:textField><br>
    <label>Email:</label>
    <g:textField name="email"></g:textField><br>
    <label>Username:</label>
    <g:textField name="username"></g:textField><br>
    <g:actionSubmit name="Submit" value="Save"></g:actionSubmit>
</g:form>


<tl:showAdmin admin="${session.user.admin}">I am Admin</tl:showAdmin>
<tl:showUsers/>

</body>
</html>