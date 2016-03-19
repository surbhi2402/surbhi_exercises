<%@ page import="com.link.sharing.core.ResourceRating" %>

<div class="well well-lg" style="height:200px">
    <div class="left" style="float: left">
        <ls:userImage id="${session.user.id}"/>
    </div>
</div>
    <div class="col-xs-offset-2">

        <div style="color:black;font-size: medium">${resource.createdBy.username}
            <a href="#" class="pull-right"><u>${resource.topic.name}</u></a></div>

        <div style="color:grey">@${resource.createdBy.firstName}
            <p class="pull-right">2:45 PM 24 Feb 2016</p></div>
        <br>

        <div style="float: right">
            <g:formRemote url="[controller: 'user', action: 'getScore']" name="scoreForm">
                <g:select name="score" from="${1..5}"
                          value="${com.link.sharing.core.ResourceRating.findByResource(resource)?.score}"
                          noSelection="['': 'Select Score']"/>
                <g:hiddenField name="resourceId" value="${resource.id}"/>
                <g:actionSubmit value="Score"/>
                <div id="test"/>
            </g:formRemote>

        </div>
        <br>
        <br>
        <br>

    </div>

    <p style="font-size: medium">
        ${resource.description}
    </p>

    <br>
    <a href="#"><i class="fa fa-facebook fa-fw"></i></a>
    <a href="#"><i class="fa fa-twitter fa-fw"></i></a>
    <a href="#"><i class="fa fa-google-plus fa-fw"></i></a>

    <div style="float: right">
        <a href="#" style="margin-left:180px">
            <ls:resourceDelete id="${resource.id}"></ls:resourceDelete>



            <ls:editResource id="${resource.id}">
                <g:link controller="resource" action="save" params="[id:resource.id]">
                    <a href="#" data-toggle="modal" data-target="#editResource" data-tooltip="true"
                       title="Edit Resource">
                        Edit
                    </a></g:link></a>
            </ls:editResource>
            <ls:checkType id="${resource.id}" url="${resource.class}"
                          filePath="${resource.class}"></ls:checkType>

    </div>
</div>