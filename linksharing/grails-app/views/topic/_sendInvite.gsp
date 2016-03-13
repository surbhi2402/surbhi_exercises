<div class="modal fade" id="sendInvitation" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Send Invitation</h4>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="row">
                        <!--form for modal-->
                        <g:form class="form-horizontal" controller="topic" action="invite">
                            <div class="form-group">
                                <label for="inputLink" class="control-label col-xs-2">Email</label>
                                <div class="col-xs-10">
                                    <input type="link" class="form-control" id="inputLink" placeholder="URL">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="topic1" class="control-label col-xs-2">Topic*</label>
                                <div class="col-xs-10">
                                    <g:select name="topic1" from="${subscribeTopics}" optionKey="id"
                                              value="${subscribeTopics}" noSelection="['': 'select Topic']"/>
                                </div>
                            </div>

                            <div class="row">
                                <div class="modal-footer">
                                    <g:submitButton name="submit" value="save" type="submit"
                                                    class="btn btn-primary">Invite</g:submitButton>
                                    <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
                                </div>
                            </div>
                        </g:form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>