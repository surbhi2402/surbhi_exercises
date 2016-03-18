<div class="panel panel-default">
    <div class="panel panel-heading" style="height: 40px">
        <div class="pull-left">${topic.name}</div>

        <div class="pull-right"><a href="#"><u>View All</u></a></div>
    </div>

    <div class="panel-body">
        <g:if test="${session.user}">
            <div class="left" style="float: left">
                <ls:userImage id="${session?.user?.id}"/>
            </div>

        </g:if>
        <g:else>
            <div></div>
        </g:else>
    </div>

    <div class="col-xs-offset-3" class="row">
        <a href="#" style="float:left"><u>${topic.name}</u></a>
        <br>

        <div>
            <a href="#" style="float:left;color:grey">@${topic.createdBy.username}</a>

            <inline>
                <div class="col-sm-4  " style="color:grey;margin-left: 40px">Subscription</div>

                <div class="col-sm-4" style="color:grey">Topics</div>
            </inline>

            <inline>
                <g:if test="${session.user}">
                    <div style="float:left"><ls:showSubscribe id="${topic.id}"/></div>
                </g:if>
                <g:else>
                    <div></div>
                </g:else>
                <div class="col-sm-3" style="color:grey; margin-left:45px"><ls:resourceCount
                        topicId="${topic.id}"/></div>

                <g:if test="${session.user}">

                    <div class="col-sm-3" style="color:grey"><ls:topicCount/></div>
                </g:if>
                <g:else>
                    <div></div>
                </g:else>
            </inline>
        </div>
        <br>

        <div class="form-group">

            <div class="col-xs-4">
                <div class="row">
                    <br>
                    <br>
                    <g:if test="${session.user}">
                        <ls:showSeriousness topicId="${topic.id}"/>
                    </g:if>
                    <g:else>
                        <div></div>
                    </g:else>
                </div>
            </div>
            %{--<g:if test="${session.user}">--}%
                %{--<ls:canUpdateTopic topicId="${topic.id}"/>--}%
            %{--</g:if>--}%
            %{--<g:else>--}%
                %{--<div></div>--}%
            %{--</g:else>--}%

            %{--<div class="pull-right">--}%
            %{--<a href="#myModal4" data-target="#myModal4" data-toggle="modal"><i class="fa fa-envelope fa-fw" style="font-size:20px" data-tooltip="true"--}%
            %{--title="It will open send invitation popup"></i></a>--}%
            %{--</div>--}%
        </div>

    </div>
</div>
</div>
