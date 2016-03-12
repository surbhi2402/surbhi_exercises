%{--<div class="form-group">--}%
    <div class="col-xs-4">
        <div class="row">
            %{--<g:select class="visibility" name="visibility" id="${topicId}" from="${com.ttnd.linksharing.Enum.Visibility.values()}"--}%
                      %{--value="${com.ttnd.linksharing.Enum.Visibility.values()}"--}%
                      %{--noSelection="['': 'select visibility']"/>--}%
            <ls:showVisibility id="${topicId}"/>
        </div>

    </div>

    <div class="col-xs-4">
        <div class="row">
            <ls:showSeriousness topicId="${topicId}"/>
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
        <g:link controller="topic" action="delete" params="[id:topicId]"><i class="fa fa-trash fa-fw" style="font-size:20px"></i></g:link>
    </div>
%{--</div>--}%
