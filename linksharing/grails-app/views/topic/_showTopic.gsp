%{--<div class="panel panel-default" style="float: left">--}%
    %{--<div class="panel panel-heading" style="height: 40px">--}%
        %{--<div class="pull-left">${topic.name}</div>--}%

        %{--<div class="pull-right"><a href="#"><u>View All</u></a></div>--}%
    %{--</div>--}%

    %{--<div class="panel-body">--}%
        %{--<div style="float:left;font-size:70px" class="glyphicon glyphicon-user"></div>--}%

        %{--<div class="col-xs-offset-3" class="row">--}%
            %{--<a href="#" style="float:left"><u>${topic.name}</u></a>--}%
            %{--<br>--}%

            %{--<div>--}%
                %{--<a href="#" style="float:left;color:grey"><u>@${topic.name}</u></a>--}%

                %{--<ls:showSubscribe id="${topic.id}"></ls:showSubscribe>--}%
                %{--<div class="col-sm-4  " style="color:grey;margin-left: 40px">Subscription</div>--}%
                %{--<div class="col-sm-4" style="color:grey">Resources</div>--}%
                %{----}%
                %{--<div class="col-sm-3" style="color:grey; margin-left:45px"><a href="#">50</a></div>--}%

                %{--<ls:resourceCount topicId="${topic.id}"></ls:resourceCount>--}%
                %{--<div class="col-sm-3" style="color:grey"><a href="#">30</a></div>--}%

            %{--</div>--}%
            %{--<br>--}%

            %{--<div class="form-group">--}%
                %{--<div class="col-xs-4">--}%
                    %{--<div class="row">--}%
                        %{--<select class="form-control" rows="4" id="topic" style="margin-left:170px"--}%
                                %{--data-tooltip="true"--}%
                                %{--title="If user is subscribed to this topic,user can send invitation">--}%
                            %{--<option>Serious</option>--}%
                            %{--<option>A2</option>--}%
                            %{--<option>A3</option>--}%
                            %{--<option>A4</option>--}%
                        %{--</select>--}%
                    %{--</div>--}%
                %{--</div>--}%

                %{--<div class="pull-right">--}%
                    %{--<a href="#myModal4" data-target="#myModal4" data-toggle="modal"><i class="fa fa-envelope fa-fw"--}%
                                                                                       %{--style="font-size:20px"--}%
                                                                                       %{--data-tooltip="true"--}%
                                                                                       %{--title="It will open send invitation popup"></i>--}%
                    %{--</a>--}%
                %{--</div>--}%
            %{--</div>--}%
        %{--</div>--}%
    %{--</div>--}%
%{--</div>--}%





























<div class="panel panel-default">
    <div class="panel panel-heading" style="height: 40px">
        <div class="pull-left">Topic:${topic.name}</div>
        <div class="pull-right"><a href="#"><u>View All</u></a></div>
    </div>
    <div class="panel-body">
        <div style="float:left;font-size:70px" class="glyphicon glyphicon-user"></div>

        <div class="col-xs-offset-3" class="row">
            <a href="#" style="float:left"><u>${topic.name}</u></a>
            <br>

            <div>
                <a href="#" style="float:left;color:grey"><u>@${topic.createdBy.username}</u></a>

                <inline>
                    <div class="col-sm-4  " style="color:grey;margin-left: 40px">Subscription</div>
                    <div class="col-sm-4" style="color:grey">Topics</div>
                </inline>

                <inline>
                    <div style="float:left"><ls:showSubscribe id="${topic.id}"/></div>
                    <div class="col-sm-3" style="color:grey; margin-left:45px"><ls:resourceCount topicId="${topic.id}"/></div>
                    <div class="col-sm-3" style="color:grey"><ls:topicCount/></div>
                </inline>
            </div>
            <br>
            <div class="form-group">
                <div class="col-xs-4">
                    <div class="row">
                        <select class="form-control" rows="4" id="topic" style="margin-left:170px"
                                data-tooltip="true" title="If user is subscribed to this topic,user can send invitation">
                            <option>Serious</option>
                            <option>A2</option>
                            <option>A3</option>
                            <option>A4</option>
                        </select>
                    </div>
                </div>
                <div class="pull-right">
                    <a href="#myModal4" data-target="#myModal4" data-toggle="modal"><i class="fa fa-envelope fa-fw" style="font-size:20px" data-tooltip="true"
                                                                                       title="It will open send invitation popup"></i></a>
                </div>
            </div>

        </div>
    </div>
</div>
