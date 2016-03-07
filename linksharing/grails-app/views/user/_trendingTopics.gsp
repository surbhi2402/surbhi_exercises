<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Trending topics</h3>
    </div>

    <div class="panel-body ">
        <g:each in="${trendingTopics}" var="topic">
            <div>
                <div class="row">
                    <div class="list-group col-xs-3">
                        <div class="img-thumbnail" style="float:left">
                            <span class="glyphicon glyphicon-user" style="font-size:80px"></span>
                        </div>
                    </div>

                    <div class="col-xs-9">
                        <div class="row">
                            <g:link controller="topic" action="show" params='[topicId: "${topic.id}"]'>${topic}</g:link>
                        </div>
                        <br/><br/>

                        <div class="row">
                            <div class="col-xs-4">
                                <small class="col-xs-12">@${topic.name}</small>
                                <small class="col-xs-12"><a>Subscribe</a></small>
                            </div>

                            <div class="col-xs-4">
                                <small class="col-xs-12">Subscriptions</small>
                                <small class="col-xs-12">50</small>
                            </div>

                            <div class="col-xs-4">
                                <small class="col-xs-12">${topic.name}</small>
                                <small class="col-xs-12">10</small>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div>
            </div>
            <hr/>

            <div class="row">
                <div class="list-group col-xs-3">

                    <div class="img-thumbnail" style="float:left">
                        <span class="glyphicon glyphicon-user" style="font-size:80px"></span>
                    </div>
                </div>

                <div class="col-xs-9">
                    <div class="row">
                        <form class="form-inline" role="form">
                            <div class="form-group">

                                <input type="text" class="form-control col-xs-4" placeholder="Grails" id="name">
                                <button type="button" class="btn ">save</button>
                                <button type="button" class="btn btn-default">cancel</button>

                            </div>
                        </form>
                    </div>
                    <br/>

                    <div class="row">
                        <div class="col-xs-4">
                            <small class="col-xs-12">@${topic.name}</small>
                            <small class="col-xs-12"><a>Subscribe</a></small>
                        </div>

                        <div class="col-xs-4">
                            <small class="col-xs-12">Subscriptions</small>
                            <small class="col-xs-12">${topic.count}</small>
                        </div>

                        <div class="col-xs-4">
                            <small class="col-xs-12">Topics</small>
                            <small class="col-xs-12">10</small>
                        </div>
                    </br>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="dropdown col-sm-4">
                    <div class="row">
                        <g:select name="visibility" from="${com.ttnd.linksharing.Enum.Visibility.values()}"
                                  value="${com.ttnd.linksharing.Enum.Visibility.values()}"
                                  noSelection="['': 'select visibility']"/>
                    </div>

                    %{--<ul class="dropdown-menu">--}%
                    %{--<li><a href="#">Public</a></li>--}%
                    %{--</ul>--}%
                </div>

                <div class="dropdown col-sm-4">
                    <div class="row">
                        <g:select name="visibility" from="${com.ttnd.linksharing.Enum.Visibility.values()}"
                                  value="${com.ttnd.linksharing.Enum.Visibility.values()}"
                                  noSelection="['': 'select visibility']"/>
                    </div>
                </div>
                <i class="fa fa-envelope-o nav_icon "></i>
                <span class="glyphicon glyphicon-edit nav_icon "></span>
                <span class="glyphicon glyphicon-trash nav_icon "></span>
            </div>
        </g:each>
    </div>
</div>