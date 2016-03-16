<%--
  Created by IntelliJ IDEA.
  User: surbhi
  Date: 16/3/16
  Time: 1:55 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Topics Listing</title>
    <meta name="layout" content="main"/>
</head>

<body>


<div class="panel panel-default">
    <div class="panel panel-heading" style="height: 40px">
        <div class="pull-left">Topics</div>

        <div class="pull-right"><a href="#"><u>View All</u></a></div>
    </div>

<div class="panel-body">
    <g:each in="${topics}" var="topic">
        <div class="left" style="float: left">
            <ls:userImage id="${session.user.id}"/>
        </div>
        </div>
        <br>

        <div class="col-xs-offset-3" class="row">
            <g:link controller="topic" action="show" params='[topicId: "${topic.id}"]'>${topic.name}</g:link>
            <br>

            <div>
                <g:link controller="user" action="profile" style="float: left"
                        params="[id: session.user.id, topicId: 0, visibility: com.ttnd.linksharing.Enum.Visibility.PUBLIC]">@${topic.createdBy.username}</g:link>

                <div class="col-sm-4" style="color:grey">Subscription</div>

                <div class="col-sm-4" style="color:grey">Topics</div>

                <div>
                    <ls:showSubscribe id="${topic.id}"></ls:showSubscribe>
                    %{--<div class="col-sm-3" style="color:grey;margin-left: 70px"><ls:subscriptionCount--}%
                    %{--userId="${userDetails.id}"/></div>--}%

                    <div class="col-sm-3" style="color:grey"><ls:topicCount/></div>
                </div>
            </div>

            <br>
            <br>
            <!--Drop downs of subscription panel-->
            <ls:canUpdateTopic topicId="${topic.id}"/>
        </div>
        <br>
        <hr>
    </g:each>
</div>
</div>


</body>
</html>