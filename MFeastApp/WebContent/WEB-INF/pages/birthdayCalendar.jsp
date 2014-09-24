<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>MFeast</title>

    <!-- Bootstrap Core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="resources/css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="resources/css/plugins/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resources/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="resources/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="resources/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
function imgError(image){
	image.onerror="";image.src="resources/css/mobiquitylogo.jpg";
	return true;
}


</script>



</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">MFeast</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
            <li>Welcome ${validatedUser.firstName} </li>
              
                <!-- /.dropdown -->
               
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down" ></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                    <li><a  id="Profile"  href= "getadminProfile" style="cursor: pointer; cursor: hand;"><i class="fa fa-user fa-fw"></i>  Profile</a>
                        </li>
                        <li><a href="changePassword"><i class="fa fa-sign-out fa-fw"></i> Change Password</a>
                        </li>
                        <li><a href= "logout" style="cursor: pointer; cursor: hand;"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                         
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="#" ><i class="fa fa-bar-chart-o fa-fw"></i> Create Survey<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                            
                                <li>
                                    <a data-toggle="modal" data-target="#myModal" style="cursor: pointer; cursor: hand;">Feast Poll</a>
                                </li>
                                <li>
                                    <a data-toggle="modal" data-target="#feedback" style="cursor: pointer; cursor: hand;">FeedBack</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
   
                        
                           
                            <!-- /.nav-second-level -->
                       
                        <li>
                            <a href="calendarDisplay"><i class="fa fa-table fa-fw"></i> Calendar Event</a>
                        </li>
                
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">MFeast App</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
           <%@ include file="calendar.jsp" %>
            <div class="row" Style="Display:none">
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-bar-chart-o fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">26</div>
                                    <div>Yes</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6" Style="Display:none">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-tasks fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">12</div>
                                    <div>No</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    <!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Feast Survey</h4>
      </div>
      <form action="submitSurvey" method="POST" commandName="surveyDetails">
       <div class="modal-body">
      Feast Name: <input type="text" name="surveyName" size="63"></input><br> <br>
      Description:<br>
       <textarea type="text" name="description" rows="5" cols="65" style="margin-left:80px;"></textarea><br><br>
      VegOption:<input type="text" name="surveyName" size="63"></input><br> <br>
      JainOption:<input type="text" name="surveyName" size="63"></input><br> <br>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <button type="submit" class="btn btn-primary" >Save</button>
      </div>
        </form>
    </div>
  </div>
</div>


<div class="modal fade" id="feedback" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Feast Survey</h4>
      </div>
      <form action="submitSurveyFeed" method="POST" commandName="surveyDetailsFeed">
      <div class="modal-body">
      Feast Name: <input type="text" name="surveyName" size="63"></input><br> <br>
      Description:<br>
       <textarea type="text" name="description" rows="5" cols="65" style="margin-left:80px;"></textarea><br><br>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <button type="submit" class="btn btn-primary" >Save</button>
      </div>
        </form>
    </div>
  </div>
</div>






    <!-- jQuery Version 1.11.0 -->
    <script src="resources/js/jquery-1.11.0.js"></script>
    <script src="resources/js/main.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="resources/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="resources/js/plugins/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="resources/js/sb-admin-2.js"></script>

     
      
</body>

</html>
