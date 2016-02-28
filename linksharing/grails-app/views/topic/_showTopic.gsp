<div class="col-xs-5">
    <!--Trending topics div starts here-->
    <div class="panel panel-default" style="height: 400px;width: 500px">
        <div class="panel panel-heading">Trending Topics</div>
        <div class="panel-body">
            <div style="float:left;font-size:70px" class="glyphicon glyphicon-user"></div>
            <div class="col-xs-offset-3" class="row">
                <a href="#" style="float:left"><u>Grails</u></a>
                <br>
                <div>
                    <a href="#" style="float:left;color:grey"><u>@Uday</u></a>
                    <inline>
                        <div class="col-sm-4" style="color:grey;margin-left: 40px">Subscription</div>
                        <div class="col-sm-4" style="color:grey">Topics</div>
                    </inline>
                    <inline>
                        <div style="float:left"><u><a href="#">Unsubscribe</a></u></div>
                        <div class="col-sm-3" style="color:grey; margin-left:45px"><a href="#">50</a></div>
                        <div class="col-sm-3" style="color:grey"><a href="#">30</a></div>
                    </inline>
                </div>
            </div>
        </div>
        <hr>
        <!--2nd div inside trending topics-->
        <div class="panel-body">
            <div style="float:left;font-size:70px" class="glyphicon glyphicon-user"></div>

            <div class="col-xs-offset-3" class="row">

                <div class="btn">
                    <div class="row">
                        <div class="col-md-offset-1">
                            <input type="text">
                            <g:actionSubmit value="submit" class="btn btn-success" type="submit">Save</g:actionSubmit>
                            <g:actionSubmit value="cancel" class="btn btn-default" type="submit">Cancel</g:actionSubmit>
                        </div>
                    </div>
                </div>
                <a href="#" style="float:left"><u>@Uday</u></a>
                <inline>
                    <div class="col-sm-4  " style="color:grey">Subscription</div>
                    <div class="col-sm-4" style="color:grey">Topics</div>
                </inline>
                <inline>
                    <div style="float:left"><u><a href="#">Unsubscribe</a></u></div>
                    <div class="col-sm-3" style="color:grey; margin-left:15px"><a href="#">50</a></div>
                    <div class="col-sm-3" style="color:grey"><a href="#">30</a></div>
                </inline>
            </div>
        </div>
        <div class="form-group">
            <div class="col-xs-4">
                <div class="row">
                    <select class="form-control" rows="4" id="topic1">
                        <option>Serious</option>
                        <option>A2</option>
                        <option>A3</option>
                        <option>A4</option>
                    </select>
                </div>
            </div>
            <div class="col-xs-4">
                <div class="row">
                    <select class="form-control" rows="4" id="topic">
                        <option>Private</option>
                        <option>A2</option>
                        <option>A3</option>
                        <option>A4</option>
                    </select>
                </div>
            </div>
            <div class="pull-right">
                <a href="#"><i class="fa fa-floppy-o fa-fw" style="font-size:20px"></i></a>
                <a href="#" data-target="#myModal4" data-toggle="modal"><i class="fa fa-envelope fa-fw" style="font-size:20px"></i></a>
                <a href="#"><i class="fa fa-trash fa-fw" style="font-size:20px"></i></a>
            </div>
        </div>
    </div>
</div>