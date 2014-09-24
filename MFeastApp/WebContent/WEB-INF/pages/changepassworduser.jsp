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
                    <li><a   href= "userProfile" style="cursor: pointer; cursor: hand;"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a  href= "logout" style="cursor: pointer; cursor: hand;"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
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
                            <a href="#" ><i class="fa fa-bar-chart-o fa-fw"></i> View Current Survey<span class="fa arrow"></span></a>
                            
                            <!-- /.nav-second-level -->
                        </li>
   
                        
                           
                            <!-- /.nav-second-level -->
                       
                       
                
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
            <img src="showimg/${validatedUser.userId}" alt="Your Image" id="imageadmin" onerror="imgError(this)" />
            <div >
            <ul>
            <li>FirstName: ${validatedUser.firstName} </li>
            <li>LastName: ${validatedUser.lastName} </li>
            <li>Phone Number: ${validatedUserContactDetail.mobileNumber} </li>
            <li>Permanent Address: ${validatedUserContactDetail.permenantAddress} </li>
            <li>Temporary Address:${validatedUserContactDetail.temporaryAddress}</li>
            </ul>
       
               <form:form action="newPassword" role="form" method="post" commandName="contactDetail" enctype="multipart/form-data">
                <input type="password" name="oldPassword" placeholder="current password"></input><br><br>
                <input type="password" name="newPassword" placeholder="new password"></input><br><br>
                <input type="submit" ></input>
                <a href="cancelPassword" class="btn btn-success">Cancel</a>
            </form:form>
            
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>

    <!-- jQuery Version 1.11.0 -->
    <script src="resources/js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="resources/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="resources/js/plugins/metisMenu/metisMenu.min.js"></script>
     <script src="resources/js/jquery-1.11.0.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="resources/js/sb-admin-2.js"></script>

     
      
</body>

</html>
