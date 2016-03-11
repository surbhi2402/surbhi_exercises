%{--<div class="panel panel-default">--}%
%{--<div class="panel-heading" style="height: 35px">--}%
%{--<h3 class="panel-title">Trending topics</h3>--}%
%{--</div>--}%

%{--<div class="panel-body ">--}%
%{--<g:each in="${trendingTopics}" var="topic">--}%
%{--<div>--}%
%{--<div class="row">--}%
%{--<div class="list-group col-xs-3">--}%
%{--<div class="left" style="float: left">--}%
%{--<ls:userImage id="${session.user.id}"/>--}%
%{--</div>--}%
%{--</div>--}%
%{--</div>--}%

%{--<div class="col-xs-9">--}%
%{--<div class="row">--}%
%{--<g:link controller="topic" action="show" params='[topicId: "${topic.id}"]'>${topic}</g:link>--}%
%{--</div>--}%
%{--<br/><br/>--}%

%{--<div class="row">--}%
%{--<div class="col-xs-4">--}%
%{--<small class="col-xs-12">@${topic.name}</small>--}%
%{--<small class="col-xs-12"><a>Subscribe</a></small>--}%
%{--</div>--}%

%{--<div class="col-xs-4">--}%
%{--<small class="col-xs-12">Subscriptions</small>--}%
%{--<small class="col-xs-12">50</small>--}%
%{--</div>--}%

%{--<div class="col-xs-4">--}%
%{--<small class="col-xs-12">${topic.name}</small>--}%
%{--<small class="col-xs-12">10</small>--}%
%{--</div>--}%
%{--</div>--}%
%{--</div>--}%
%{--</div>--}%
%{--</div>--}%

%{--<div>--}%
%{--</div>--}%
%{--<hr>--}%
%{--</g:each>--}%
%{--</div>--}%
%{--</div>--}%





<div class="panel panel-default">
           <div class="panel panel-heading">Trending Topics</div>
<g:each in="${trendingTopics}" var="topic">
    <div class="panel-body">

        <div class="left" style="float: left">
            <ls:userImage id="${session.user.id}"/>
        </div>
    </div>

    <div class="col-xs-offset-3" class="row">
        <g:link controller="topic" action="show" params='[topicId: "${topic.id}"]'>${topic}</g:link>
        <br>

        <div>
            <a href="#" style="float:left;color:grey"><u>@${topic.createdBy.username}</u></a>

            <inline>
                <div class="col-sm-4" style="color:grey;margin-left: 40px">Subscription</div>

                <div class="col-sm-4" style="color:grey">Topics</div>
            </inline>

            <inline>
                <div style="float:left"><ls:showSubscribe id="${topic.id}"/></div>

                <div class="col-sm-3" style="color:grey; margin-left:45px"><ls:subscriptionCount userId="${userDetails.id}"/></div>

                <div class="col-sm-3" style="color:grey"><ls:topicCount/></div>
            </inline>

        </div>
    </div>

    </div>
    <hr>
</g:each>
</div>