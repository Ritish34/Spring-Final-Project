<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Dashboard</title>
</head>
<body>
	<input type="hidden" id="userid" name="userid" value= <#if id?has_content>${id}</#if> />
	
  	<#include "Profile.ftl">

</body>
</html>