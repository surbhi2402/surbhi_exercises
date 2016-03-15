<div class="modal fade" id="forgotPassword" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Forgot Password</h4>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="row">
                    <!--form for modal-->
                        <g:form class="form-horizontal" controller="user" action="forgotPassword">
                            <div class="form-group">
                                <label for="inputLink" class="control-label col-xs-2">Email</label>
                                <div class="col-xs-10">
                                    <input type="email" name="email" class="form-control" id="inputLink" placeholder="Email"/>
                                </div>
                            </div>

                            <div class="row">
                                <div class="modal-footer">
                                    <g:submitButton name="submit" value="Send Email" type="submit"
                                                    class="btn btn-primary">Send Mail</g:submitButton>
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