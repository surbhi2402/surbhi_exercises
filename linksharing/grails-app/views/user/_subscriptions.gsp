<div class="panel panel-default">
    <div class="panel panel-heading" style="height: 40px">
        <div class="pull-left">Subscriptions</div>
        <div class="pull-right"><a href="#"><u>View All</u></a></div>
    </div>
    <div class="panel-body">
        <div style="float:left;font-size:70px" class="glyphicon glyphicon-user"></div>
        <div class="col-xs-offset-3" class="row">
            <a href="#" style="float:left"><u>Grails</u></a>
            <br>
            <div>
                <a href="#" style="float:left;color:grey"><u>@Uday</u></a>
                <inline>
                    <div class="col-sm-4" style="color:grey">Subscription</div>
                    <div class="col-sm-4" style="color:grey">Topics</div>
                </inline>
                <inline>
                    <div style="float:left"><u><a href="#">Unsubscribe</a></u></div>
                    <div class="col-sm-3" style="color:grey; margin-left:15px"><a href="#">50</a></div>
                    <div class="col-sm-3" style="color:grey"><a href="#">30</a></div>
                </inline>
            </div>
            <br>
            <!--Drop downs of subscription panel-->
            <div class="form-group">
                <div class="col-xs-4">
                    <div class="row">
                        <g:select name="visibility" from="${com.ttnd.linksharing.Enum.Visibility.values()}"
                                  value="${com.ttnd.linksharing.Enum.Visibility.values()}" noSelection="['':'select visibility']"/>
                    </div>
                </div>


                <div class="col-xs-4">
                    <div class="row">
                        <g:select name="visibility" from="${com.ttnd.linksharing.Enum.Visibility.values()}"
                                  value="${com.ttnd.linksharing.Enum.Visibility.values()}" noSelection="['':'select visibility']"/>
                    </div>
                </div>
                <!--glyphicons-->
                <div class="pull-right">
                    <a href="#myModal4" data-toggle="modal" data-target="#myModal4"><i class="fa fa-envelope fa-fw" style="font-size:20px"></i></a>
                    <a href="#"><i class="fa fa-file fa-fw" style="font-size:20px"></i></a>
                    <a href="#"><i class="fa fa-trash fa-fw" style="font-size:20px"></i></a>
                </div>
            </div>

        </div>
    </div>
    <hr>
    <!--Second div(same as above)-->
    <div class="panel-body">
        <div style="float:left;font-size:70px" class="glyphicon glyphicon-user"></div>

        <div class="col-xs-offset-3" class="row">
            <a href="#" style="float:left"><u>Grails</u></a>
            <br>

            <div>
                <a href="#" style="float:left;color:grey"><u>@Uday</u></a>

                <inline>
                    <div class="col-sm-4  " style="color:grey;margin-left: 40px">Subscription</div>
                    <div class="col-sm-4" style="color:grey">Topics</div>
                </inline>

                <inline>
                    <div style="float:left"><u><a href="#">Unsubscribe</a></u></div>
                    <div class="col-sm-3" style="color:grey; margin-left:45px"><a href="#">50</a></div>
                    <div class="col-sm-3" style="color:grey"><a href="#">30</a></div>
                </inline>
            </div>
            <br>
            <div class="form-group">
                <div class="col-xs-4">
                    <div class="row">
                        <g:select name="visibility" from="${com.ttnd.linksharing.Enum.Visibility.values()}"
                                  value="${com.ttnd.linksharing.Enum.Visibility.values()}" noSelection="['':'select visibility']"/>
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