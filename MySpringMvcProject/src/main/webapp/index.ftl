<html>
<head>

<link rel="stylesheet" href="CSS/Login.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body id="LoginForm">
	<div class="container">
		<!-- <h1 class="form-heading">login Form</h1> -->
		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<h2>Login Here</h2>
				</div>
				<form id="Login" action="login">

					<div class="form-group">


						<input type="text" class="form-control" id="inputText"
							placeholder="Username" name="username">

					</div>

					<div class="form-group">

						<input type="password" class="form-control" id="inputPassword"
							placeholder="Password" name="password">

					</div>
					<br>
					<div>
						<a href="reset" class="forgot">Forgot password?</a> 
						<a href="direct" class="registerhere">Register Here</a>
					</div>

					<br>

					<button type="submit" class="btn btn-primary">Login</button>

				</form>
			</div>
		</div>
	</div>


</body>
</html>