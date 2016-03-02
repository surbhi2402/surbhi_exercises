<!-- Modal -->
<div class="modal fade" id="submitDocument" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Share Document</h4>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="row">
                    <!--form for modal-->
                        <g:form class="form-horizontal" controller="documentResource" action="save">
                            <div class="form-group">
                                <label for="inputLink" class="control-label col-xs-2">Document</label>
                                <div class="col-xs-5">
                                    <g:textField name="filePath" type="path" class="form-control" id="inputLink" placeholder="File Path"/>
                                </div>
                                <div class="col-xs-5">
                                    <button type="submit" class="btn btn-primary">Browse</button>
                                </div>
                            </div>
                            <!--row 2-->
                            <div class="form-group">
                                <label for="comment" class="control-label col-xs-2">Description</label>
                                <div class="col-xs-10">
                                    <g:textArea name="description" class="form-control" rows="5" id="comment"></g:textArea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="topic1" class="control-label col-xs-2">Topic*</label>
                                <div class="col-xs-10">
                                    <g:select name="topic1" from="${subscribeTopics}" optionKey="id"
                                              value="${subscribeTopics}" noSelection="['':'select Topic']"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="modal-footer">
                                    <g:actionSubmit action="save" value="save" type="submit" class="btn btn-primary">Share</g:actionSubmit>
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
