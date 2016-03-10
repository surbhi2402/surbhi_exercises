%{--<div class="form-group">--}%
    <div class="col-xs-4">
        <div class="row">
            <g:select name="visibility" from="${com.ttnd.linksharing.Enum.Visibility.values()}"
                      value="${com.ttnd.linksharing.Enum.Visibility.values()}"
                      noSelection="['': 'select visibility']"/>
        </div>

    </div>

    <div class="col-xs-4">
        <div class="row">
            <ls:showSeriousness topicId="${topicId}" userId="${session.user.id}"/>
            %{--<g:select class="seriousness" name="visibility" from="${com.ttnd.linksharing.Enum.Seriousness.values()}"--}%
            %{--value="${com.ttnd.linksharing.Enum.Seriousness.values()}"--}%
            %{--noSelection="['': 'select seriousness']"/>--}%
        </div>
    </div>

    <!--glyphicons-->
    <div class="pull-right">
        <a href="#myModal4" data-toggle="modal" data-target="#myModal4"><i class="fa fa-envelope fa-fw"
                                                                           style="font-size:20px"></i></a>
        <a href="#"><i class="fa fa-file fa-fw" style="font-size:20px"></i></a>
        <a href="#"><i class="fa fa-trash fa-fw" style="font-size:20px"></i></a>
    </div>
%{--</div>--}%
