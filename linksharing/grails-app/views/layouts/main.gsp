<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>

    <meta property="og:url"           content="http://localhost:8080/" />
    <meta property="og:type"          content="website" />
    <meta property="og:title"         content="LinkSharing" />
    <meta property="og:description"   content="Your description" />
    %{--<meta property="og:image"         content="http://www.your-domain.com/path/image.jpg" />--}%



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

<body style="background-color:#f5f5f5">

<script>
    window.fbAsyncInit = function() {
        FB.init({
            appId      : '255292208140512',
            xfbml      : true,
            version    : 'v2.5'
        });
    };

    (function(d, s, id){
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) {return;}
        js = d.createElement(s); js.id = id;
        js.src = "//connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));
</script>





<g:if test="${session.user}">
    <div class="container-fluid" style="height:100px">

        <nav class="navbar header">
            <a class="navbar-brand" href="#"><g:link controller="user" action="index" style="font-size: x-large">Link sharing</g:link></a>

            <g:form controller="resource" action="globalSearch" class="navbar-form navbar-right" role="search">
                <g:actionSubmit action="globalSearch" value="Search" type="submit" class="form-control">
                %{--<span class="glyphicon glyphicon-search"></span>--}%
                </g:actionSubmit>
                <input type="text" class="form-control" placeholder="Enter Value" name="queryString">
                <span class="badge" class="glyphicon glyphicon-remove"></span>


            %{--<i class="fa fa-comment" data-target="#createtopic" data-toggle="modal"></i>--}%
                <a href="#" data-toggle="modal" data-target="#createtopic" data-tooltip="true"
                   title="Create Topic"><i
                        class="fa fa-comment fa-fw" style="font-size:20px"></i></a>

                <a href="#" data-toggle="modal" data-target="#sendInvitation" data-tooltip="true"
                   title="Send Invitation"><i
                        class="fa fa-envelope fa-fw" style="font-size:20px"></i></a>

                <a href="#" data-toggle="modal" data-target="#submitLink" data-tooltip="true" title="Create Resource"><i
                        class="fa fa-link fa-fw" style="font-size:20px"></i></a>

                <a href="#" data-toggle="modal" data-target="#submitDocument" data-tooltip="true"
                   title="Send Document"><i class="fa fa-floppy-o fa-fw" style="font-size:20px"></i></a>

            %{--<a class="glyphicon glyphicon-user" style="font-size:20px"></a>--}%

                <div class="dropdown" style="float:right">
                    <button class="btn btn-primary dropdown-toggle" type="button"
                            data-toggle="dropdown">${session.user.firstName}<span
                            class="caret">
                    </span></button>
                    <ul class="dropdown-menu">
                        <li><g:link controller="user" action="privateProfile"
                                    params="[id: session.user.id, topicId: 0, visibility: com.ttnd.linksharing.Enum.Visibility.PUBLIC]">Profile</g:link></li>
                        <li><g:link controller="user" action="list">Users</g:link></li>
                        <li><a href="#">Topics</a></li>
                        <li><a href="#">Posts</a></li>
                        <li><a href="/j_spring_security_logout">Logout</a></li>
                    </ul>
                </div>
            </g:form>
        </nav>
    </div>
    <g:render template="/topic/createTopic"></g:render>
    <g:render template="/topic/sendInvite"></g:render>
    <g:render template="/user/forgotPasswd"></g:render>
    <g:render template="/linkResource/submitLink"></g:render>
    <g:render template="/documentResource/submitDocument"></g:render>
</g:if>
<g:else>
    <div class="container-fluid" style="height: 100px">
        <div class="row">
            <div class="col-md-2">
                <a class="navbar-brand" href="#"><g:link controller="login" action="index" style="font-size: x-large">Link sharing</g:link></a>

            </div>

            <div class="col-md-8"></div>

            <div class="col-md-3 pull-right">
                <g:form controller="resource" action="globalSearch" class="navbar-form navbar-right" role="search">
                    <g:actionSubmit action="globalSearch" value="Search" type="submit" class="form-control">
                    </g:actionSubmit>
                    <input type="text" class="form-control" placeholder="Enter Value" name="queryString">
                    <span class="badge" class="glyphicon glyphicon-remove"></span>
                </g:form>
            </div>
        </div>
    </div>

</g:else>
<div class="container">
    <div class="jsonResponse" style="display:none"></div>
</div>
<g:layoutBody/>
<asset:javascript src="application.js"/>
<asset:javascript src="additional-methods.min.js"/>
<asset:javascript src="jquery.validate.min.js"/>
</body>
</html>



