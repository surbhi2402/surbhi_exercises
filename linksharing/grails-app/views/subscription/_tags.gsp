%{--<div class="form-group">--}%


<div style="display: none" id="editForm${topicId}">
    <span class="row">
        <g:textField name="topicName" id="name${topicId}" value="${topicId}"/>

        <g:hiddenField name="topicId" id="topicId${topicId}" value="${topicId}"/>

        <span class="row">
            <button class="saveTopicNameButton btn-primary" topicId="${topicId}">Save</button>

            <button class="cancelTopicNameButton btn-primary" topicId="${topicId}">Cancel</button>
        </span>
    </span>
</div>


<div class="col-xs-4">
        <div class="row">

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




    <div class="pull-right">
        <a href="#myModal4" data-toggle="modal" data-target="#myModal4"><i class="fa fa-envelope fa-fw"
                                                                           style="font-size:20px"></i></a>

        <a href="#"><span class="glyphicon glyphicon-pencil col-xs-1 font-size-md edit-topic"
    data-topic-id="${topicId}"></span></a>

        <g:link controller="topic" action="delete" params="[id:topicId]"><i class="fa fa-trash fa-fw" style="font-size:20px"></i></g:link>

    </div>



%{--%{---}%

%{--</span>--}%

%{--<div style="display: none" id="editForm${topic.id}" >--}%
    %{--<span class="row">--}%
        %{--<g:textField name="topicName" id="name${topic.id}" value="${topic.name}"/>--}%


        %{--<g:hiddenField name="topicId" id="topicId${topic.id}" value="${topic.id}"/>--}%

        %{--<span class="row">--}%
            %{--<button class="saveTopicNameButton btn-primary" topicId="${topic.id}">Save</button>--}%


            %{--<button class="cancelTopicNameButton btn-primary" topicId="${topic.id}">Cancel</button>--}%
        %{--</span>--}%
    %{--</span>--}%
%{--</div>--}%
