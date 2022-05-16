<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header File</title>
<!-- Bootstrap -->
    <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- custom css -->
<link href="resources/css/header.css" rel="stylesheet">
</head>
<body>
		<nav class="navbar navbar-default navbar-static-top">
	        <div class="container">
	          <!-- Brand and toggle get grouped for better mobile display -->
	          <div class="navbar-header">
	            <a class="navbar-brand" href="#">${website_name}</a>
	          </div>      
	          <!-- Collect the nav links, forms, and other content for toggling -->
	          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	            <ul class="nav navbar-nav">
              		<li class="active"><a href="${home_page}">Home <span class="sr-only">(current)</span></a></li>
					<#if role == "admin">		
						<li><a href="${profile_page}">Profile</a></li>
					</#if>
	              	<li><a href="logout">Logout</a></li>
	            </ul>
	          </div><!-- /.navbar-collapse -->
	        </div><!-- /.container -->
	    </nav>

	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>