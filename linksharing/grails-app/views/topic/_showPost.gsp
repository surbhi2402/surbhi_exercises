<div class="panel panel-default">
    <div class="panel panel-heading" data-tooltip="true" title="Unread Items">Post:${topic.name}
        <div class="input-group"> <span class="input-group-btn" style="width: 30%">
        <button id = "findSearchPostBox" topicId = "${topic.id}" class="btn btn-primary glyphicon glyphicon-search searchButtons" style="margin-left: 200px"> </button> </span>
        <input type="text" id = "searchPostBox" class="form-control input-group" placeholder="Search">
        <span class="input-group-btn"> <button id = "clearSearchPostBox" class="btn btn-primary glyphicon-searchphicon glyphicon-remove searchButtons"> </button>
        </span> </div>

    </div>

    <div id = "topicPosts" class="panel-body">
        <g:render template = "/topic/viewSearch" model = "[post : post]" />

    </div>

</div>

