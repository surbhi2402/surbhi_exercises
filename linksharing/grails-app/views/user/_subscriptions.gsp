<div class="panel panel-default">
    <div class="panel panel-heading" style="height: 40px">
        <div class="pull-left">Subscriptions</div>

        <div class="pull-right"><a href="#"><u>View All</u></a></div>
    </div>

<div class="panel-body">
    <g:each in="${subscribeTopics}" var="topic">
        <div class="left" style="float: left">
            <ls:userImage id="${session.user.id}"/>
        </div>
        </div>
        <br>

        <div class="col-xs-offset-3" class="row">
            <g:link controller="topic" action="show" params='[topicId: "${topic.id}"]'>${topic.name}</g:link>
    <br>
            <div>
                <a href="#" style="float:left;color:grey"><u>@${topic.createdBy.username}</u></a>

                <div class="col-sm-4" style="color:grey">Subscription</div>

                <div class="col-sm-4" style="color:grey">Topics</div>

                <div>
                    <ls:showSubscribe id="${topic.id}"></ls:showSubscribe>
                    <div class="col-sm-3" style="color:grey;margin-left: 70px"><ls:subscriptionCount userId="${userDetails.id}"/></div>

                    <div class="col-sm-3" style="color:grey"><ls:topicCount/></div>
                </div>
            </div>


            <!--Drop downs of subscription panel-->
            <ls:canUpdateTopic topicId="${topic.id}"/>
        </div>
        <br>
        <hr>
    </g:each>
</div>


</div>



%{--<div class="panel panel-default ">--}%
%{--<div class="panel panel-heading" style="height: 40px">--}%
%{--<div class="pull-left">Subscriptions</div>--}%

%{--<div class="pull-right"><a href="#"><u>View All</u></a></div>--}%
%{--</div>--}%


%{--<div class="panel-body">--}%
%{--<g:each in="${subscribeTopics}" var="subscriber">--}%
%{--<div style="float:left">--}%
%{--<ls:userImage id="${userDetails.id}"/>--}%
%{--</div>--}%

%{--<div >--}%
%{--<a href="#"><u>${subscriber.name}</u></a>--}%
%{--<br>--}%
%{--<div>--}%
%{--<a href="#" style="float:left;color:grey"><u>${subscriber.name}</u></a>--}%
%{--<inline>--}%
%{--<div class="col-sm-4" style="color:grey;margin-left: 15px">Subscription</div>--}%

%{--<div class="col-sm-4" style="color:grey">Topics</div>--}%
%{--</inline>--}%
%{--<inline>--}%
%{--<div style="float:left">--}%
%{--<ls:showSubscribe id="${subscriber.id}"></ls:showSubscribe>--}%
%{--</div>--}%


%{--<div class="col-sm-3" style="color:grey; margin-left:15px">--}%
%{--<ls:subscriptionCount userId="${session.user.id}"/>--}%
%{--</div>--}%

%{--<div class="col-sm-3" style="color:grey"><a href="#">30</a></div>--}%

%{--<div class="col-sm-3" style="color:grey; margin-left:15px">--}%
%{--<ls:topicCount/>--}%
%{--</div>--}%
%{--</inline>--}%
%{--</div>--}%
%{--<br>--}%
%{--<!--Drop downs of subscription panel-->--}%
%{--<ls:canUpdateTopic topicId="${subscriber.id}"/>--}%

%{--</div>--}%
%{--<br/></div><hr>--}%
%{--</g:each>--}%
%{--</div>--}%

%{--</div>--}%