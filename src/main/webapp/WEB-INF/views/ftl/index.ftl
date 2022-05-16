<!DOCTYPE html>
<html lang="en">
<head>
<title>Login </title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png"
	href="resources/login/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/login/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/login/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/login/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/login/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="resources/login/css/util.css">
<link rel="stylesheet" type="text/css"
	href="resources/login/css/main.css">
<!--===============================================================================================-->
    <!-- custom alert cdn -->
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
	<input type="hidden" id="response" value="<#if msg?has_content>${msg}</#if>">
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<!-- show Image at Left side of screen -->
				<div class="login100-pic js-tilt" data-tilt>
					<img src="resources/login/images/img-01.png" alt="IMG">
				</div>

				<form class="login100-form validate-form" method="POST" action="login">
					<span class="login100-form-title"> User Login </span>

					<!-- Email Address Field Code -->
					<!-- Data-Validation field is show error message -->
					<div class="wrap-input100 validate-input"
						data-validate="Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" name="email" id="email"
							placeholder="Email" value="<#if email?has_content>${email}</#if>"
							> <span class="focus-input100"></span>
						<span class="symbol-input100"> <i class="fa fa-envelope"
							aria-hidden="true"></i>
						</span>
					</div>

					<!-- Password Field -->

					<div class="wrap-input100 validate-input" id="pass"
						data-validate="">
						<input class="input100" type="password" name="password" id="pass"
							placeholder="Password"> <span class="focus-input100"></span>
						<span class="symbol-input100"> <i class="fa fa-lock"
							aria-hidden="true"></i>
						</span>
					</div>

					<!-- Login button  -->
					<div class="container-login100-form-btn">
						<button type="submit" class="login100-form-btn">Login</button>
					</div>

					<div class="text-center p-t-12">
						<span class="txt1"> Forgot </span> <a class="txt2" href="ForgetPassword.jsp">
							Username / Password? </a>
					</div>

					<div class="text-center p-t-136">
						<a class="txt2" href="registration-page"> Create your Account <i
							class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>




	<!--===============================================================================================-->
	<script
		src="resources/login/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script
		src="resources/login/vendor/bootstrap/js/popper.min.js"></script>
	<script
		src="resources/login/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script
		src="resources/login/vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script
		src="resources/login/vendor/tilt/tilt.jquery.min.js"></script>
	<script>
		$('.js-tilt').tilt({
			scale : 1.1
		})
	</script>
	<!--===============================================================================================-->
	<script src="resources/login/js/custom.js"></script>
	<script src="resources/login/js/main.js"></script>

</body>
</html>