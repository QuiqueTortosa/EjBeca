<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="css/welcome.css">

</head>
<body>
	<div class="circle">
		<div>
			<h1 class="header">Bienvenido a tus ejercicios ${param.nombre}</h1>
		</div>
		<div id="prueba">
		</div>
		<div id="buttonDiv">
			<button class="button"
				onclick="window.location.href='Ejercicio02/index.html'">Ejercicio02</button>
			<button class="button"
				onclick="window.location.href='Ejercicio03/index.html'">Ejercicio03</button>
		</div>
	</div>
</body>
</html>