<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>

<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/admin.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.css">
	
    <!-- custom alert cdn -->
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>	
</head>
<body>
			<header>
				<#include "Header.ftl">
				<input type="hidden" id="response" value="<#if msg?has_content>${msg}</#if>">
				<h3 class="capitalize">Hello ${username}</h3>
			</header>
			<main>
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div>
								<table id="table_id" class="display">
									<thead>
										<tr>
											<th>UserId</th>
											<th>FirstName</th>
											<th>LastName</th>
											<th>Dob</th>
											<th>MobailNo</th>
											<th>Gender</th>
											<th>language</th>
											<th>Email</th>
											<th>Delete</th>
											<th>Update</th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
							</div>
						</div>
						<div class="col-md-12">
							<form name="main1"  method="get" action="adduser">
								<input type="submit" name="ter" value="Add New User" >
							</form>
						</div>
					</div>
				</div>
			</main>
			<footer>
				<#include "Footer.ftl">
			</footer>
			
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>
	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/datatable.js"></script>
	<script type="text/javascript" src="resources/js/showmessage.js"></script>
</body>
</html>