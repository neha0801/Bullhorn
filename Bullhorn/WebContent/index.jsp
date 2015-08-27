<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bullhorn</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style>
body {
	font-family: "Bookman Old Style";
	color: black;
	background-color: #a6d2d2;
}
h1{
	font-family:Edwardian Script ITC;
	font-size: 60px;
}
table{
	text-align:center;
	border-color:#00ffff;
	background-color: grey;
	border-collapse: seperate;
	color: light blue;
	width:40%;
}
</style>
</head>
<body>
<div class="container">
	<div class="jumbotron" align=center style=background-color:grey>
		<h1 align = center style=color:black><b>Bullhorn Blog</b></h1><br></br>
			${input}
	${message}
	</div>
	</div>
</body>
</html>