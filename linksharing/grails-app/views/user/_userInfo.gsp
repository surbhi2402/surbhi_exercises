
<div class="well well-lg" style="height:130px">
    <div class="left" style="float: left">
    <ls:userImage id="${session.user.id}"/>
    </div>
    </div>
    <div class="col-xs-offset-3">

        <div style="color:black">${userDetails.username}</div>
        <div style="color:grey">@${userDetails.fname}</div>

        <inline>
            <div class="col-sm-4" style="color:grey;margin-left:0px">Subscription</div>
            <div class="col-sm-4" style="color:grey">Topics</div>
        </inline>
        <inline>
            <div class="col-sm-3" style="color:grey; margin-left:45px"><ls:subscriptionCount userId="${userDetails.id}"/></div>
            <div class="col-sm-3" style="color:grey"><ls:topicCount/></div>
        </inline>

    </div>
</div>