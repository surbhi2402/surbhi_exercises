<%--
  Created by IntelliJ IDEA.
  User: surbhi
  Date: 13/3/16
  Time: 7:42 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Users</title>
    <meta name="layout" content="main"/>
</head>

<body>
<div class="panel panel-default panel-default" id="adminPaginate">
    <div class="panel-heading">
        <div class="row">
            <div class="col-md-3">
                Users
            </div>
            <g:form controller="user" action="list">
                <div class="col-md-3">
                    <select class="btn btn-default" name="active">
                        <option value="null">All user</option>
                        <option value="true">Active</option>
                        <option value="false">In active</option>
                    </select>
                </div>

                <div class="col-sm-3">
                    <div id="custom-search-input">
                        <div class="input-group col-md-10">
                            <input type="text" id="topic-post-search-textbox" name="q" class="form-control"
                                   placeholder="Search.."/>
                            <span class="input-group-btn">
                                <button class="btn btn-info" type="submit">
                                    <i class="glyphicon glyphicon-search"></i>
                                </button>
                                <button class="btn btn-info" id="topic-post-search-clear-button" type="button">
                                    <i class="glyphicon glyphicon-remove"></i>
                                </button>
                            </span>
                        </div>
                    </div>
                </div>
            </g:form>
        </div>
    </div>

    <div class="panel-body">
        <div class="table-responsive">
            <table class="table table-condensed table-hover">
                <thead>
                <tr>
                    <g:sortableColumn property="id" title="Id"/>
                    <g:sortableColumn property="userName" title="User name"/>
                    <g:sortableColumn property="email" title="Email"/>
                    <g:sortableColumn property="firstName" title="First name"/>
                    <g:sortableColumn property="lastName" title="Last name"/>
                    <g:sortableColumn property="active" title="Active"/>
                    <th>Manage</th>
                </tr>
                </thead>
                <g:each in="${users}" var="user">
                    <g:if test="${user.isActive}">
                        <g:set var="bootstrapAlertClass" value="alert alert-success"/>
                    </g:if>
                    <g:else>
                        <g:set var="bootstrapAlertClass" value="alert alert-danger"/>
                    </g:else>

                    <tr class="${bootstrapAlertClass}">
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>${user.fname}</td>
                        <td>${user.lname}</td>
                        <td>${user.isActive}</td>
                        <td>
                            <g:if test="${user.isActive}">
                                <g:link controller="user" action="toggleActive"
                                        params='[id: "${user.id}"]'>De-activate</g:link>
                            </g:if>
                            <g:else>
                                <g:link controller="user" action="toggleActive"
                                        params='[id: "${user.id}"]'>Activate</g:link>
                            </g:else>

                        </td>
                    </tr>
                </g:each>
            </table>
            <util:remotePaginate controller="user" action="list" total="${total}" update="adminPaginate" params="[userSearchCO:userSearchCO]"/>

        </div>
    </div>
</div>
</body>
</html>