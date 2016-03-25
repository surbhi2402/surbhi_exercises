<div class="panel panel-default">
    <div class="panel panel-heading">Recent shares</div>

    <g:each in="${recentShares}" var="share">
        <div class="panel-body">
            <div style="float:left;font-size:60px" class="glyphicon glyphicon-user"></div>

            <div class="col-xs-offset-2">
                <h4>${share.createdBy.firstName}</h4>

                <div style="float: right">
                    <g:link controller="topic" action="show"
                            params='[topicId: "${share.topic.id}"]'>${share.topic.name}</g:link>
                </div>

                <p>${share.description}</p>
                <a href="#" class="share_button"><i class="fa fa-facebook fa-fw"></i></a>

                <a href="https://twitter.com/share" class="fa fa-twitter fa-fw" target="_blank"></a>
                <script>!function (d, s, id) {
                    var js, fjs = d.getElementsByTagName(s)[0], p = /^http:/.test(d.location) ? 'http' : 'https';
                    if (!d.getElementById(id)) {
                        js = d.createElement(s);
                        js.id = id;
                        js.src = p + '://platform.twitter.com/widgets.js';
                        fjs.parentNode.insertBefore(js, fjs);
                    }
                }
                (document, 'script', 'twitter-wjs');</script>
                %{--<a href="#"><i class="fa fa-twitter fa-fw"></i></a>--}%

                e<a href="https://plus.google.com/share?url={URL}" onclick="javascript:window.open(this.href,
                        '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');return false;"><img
                        src="https://www.gstatic.com/images/icons/gplus-16.png" alt="Share on Google+"/></a>


                %{--<a href="#" style="float:right">--}%
                <g:link controller="resource" action="viewPostOnHome" style="float: right"
                        params='[id: "${share.topic.id}"]'>View Post</g:link>

                %{--</a>--}%
            </div>
            <hr>
        </div>
    </g:each>
</div>
