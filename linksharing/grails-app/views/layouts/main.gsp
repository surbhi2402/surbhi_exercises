<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Link Sharing"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <asset:javascript src="jquery-2.2.1.min.js"/>
    <asset:stylesheet src="application.css"/>

    <asset:javascript src="jquery.validate.min.js"/>
    <g:layoutHead/>
</head>

<body>
<g:if test="${session.user}">
    <div class="container-fluid" style="height:100px">

        <nav class="navbar header" style="background-color:lightsteelblue">
            <a class="navbar-brand" href="#">Link sharing</a>

            <form class="navbar-form navbar-right" role="search">
                <span class="glyphicon glyphicon-search"></span>
                <input type="text" class="form-control" placeholder="Search">
                <span class="badge" class="glyphicon glyphicon-remove"></span>
            </input>

                %{--<i class="fa fa-comment" data-target="#createtopic" data-toggle="modal"></i>--}%
                <a href="#" data-toggle="modal" data-target="#createtopic" data-tooltip="true"
                   title="Send Invitation"><i
                        class="fa fa-comment fa-fw" style="font-size:20px"></i></a>

                <a href="#" data-toggle="modal" data-target="#myModal4" data-tooltip="true" title="Send Invitation"><i
                        class="fa fa-envelope fa-fw" style="font-size:20px"></i></a>

                <a href="#" data-toggle="modal" data-target="#submitLink" data-tooltip="true" title="Create Resource"><i
                        class="fa fa-link fa-fw" style="font-size:20px"></i></a>

                <a href="#" data-toggle="modal" data-target="#submitDocument" data-tooltip="true"
                   title="Send Document"><i class="fa fa-floppy-o fa-fw" style="font-size:20px"></i></a>

                <a class="glyphicon glyphicon-user" style="font-size:30px"></a>

                <div class="dropdown" style="float:right">
                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">${session.user.firstName}<span
                            class="caret">
                    </span></button>
                    <ul class="dropdown-menu">
                        <li><g:link controller="user" action="profile" params="[id:session.user.id,topicId:0,visibility:com.ttnd.linksharing.Enum.Visibility.PUBLIC]">Profile</g:link></li>
                        <li><g:link controller="user" action="list">Users</g:link></li>
                        <li><a href="#">Topics</a></li>
                        <li><a href="#">Posts</a></li>
                        <li><a href="/login/logout">Logout</a></li>
                    </ul>
                </div>
            </form>
        </nav>
    </div>
    <g:render template="/topic/createTopic"></g:render>
    <g:render template="/linkResource/submitLink"></g:render>
    <g:render template="/documentResource/submitDocument"></g:render>
</g:if>
<g:else>
    <div class="container-fluid" style="height: 100px">
        <div class="row">
            <div class="col-md-2">
                <a class="navbar-brand" href="#">Link sharing</a>

            </div>

            <div class="col-md-8"></div>

            <div class="col-md-3 pull-right">
                <form class="navbar-form" role="search">
                    <div class="input-group">
                        <div class="input-group-btn">
                            <button class="btn btn-default" type="submit" style="height: 34px"><i
                                    class="glyphicon glyphicon-search"></i></button>
                        </div>
                        <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">

                        <div class="input-group-btn">
                            <button class="btn btn-default" type="submit" style="height: 34px"><i
                                    class="glyphicon glyphicon-remove"></i></button>
                        </div>

                    </div>
                </form>
            </div>
        </div>
    </div>

</g:else>
<div class = "container">
    <div class = "jsonResponse" style = "display:none"></div>
</div>
<g:layoutBody/>
<asset:javascript src="application.js"/>
</body>
</html>



