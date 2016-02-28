<!-- Modal -->
<div class="modal fade" role="dialog" id="createtopic">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Create Topic</h4>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="row">
                    <!--form for modal-->
                        <g:form class="form-horizontal" controller="topic" action="save">
                            <div class="form-group">
                                <label class="control-label col-xs-2">Name</label>
                                <div class="col-xs-10">
                                    <g:textField name="name" class="form-control" id="inputLink" placeholder="URL"/>
                                </div>
                            </div>
                            <!--row2-->
                            <div class="form-group">
                                <label class="control-label col-xs-2">Visibility</label>
                                <div class="col-xs-10">
                                    <g:select name="visibility" from="${com.ttnd.linksharing.Enum.Visibility.values()}"
                                             value="${com.ttnd.linksharing.Enum.Visibility.values()}" noSelection="['':'select visibility']"/>
                                </div>
                            </div>

                            <div class="row">
                                <div class="modal-footer">
                                    <g:actionSubmit value="save" type="submit" class="btn btn-primary">Save</g:actionSubmit>
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


