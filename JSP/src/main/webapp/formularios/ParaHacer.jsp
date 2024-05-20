<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formularios</title>
</head>
<body>
<!-- 

Ejercicios
1- Validación usuario y contraseña. Revisar y cambiar (o no) servlet por jsp

2- Calcular la nota media de los resultados de tres pruebas que se recogen en un formulario
indicando si está o no aprobado. Validar los datos que se recogen del formulario.

3- Usando la clase persona, mostrar los datos de una persona que se han enviado desde un formulario.
Tú decides los datos de la persona.

 -->
 <h2>Validación de usuario y contrasenha (Pista -> admin, 123)</h2>
 <form action="validarJSP.jsp" method="post">
 Usuario: <input type="text" name="user">
 Contrasenha: <input type="text" name="pwd">
 <input type="submit" value="Iniciar Sesión">
 </form>
 
 <h2>Calcular nota media</h2>
 <form action="notaMedia.jsp" method="post">
 Literatura: <input type=text name="literatura"><br>
 Ciencia: <input type="text" name="ciencia"><br>
 Historia: <input type="text" name="historia"><br>
 <input type="submit" value="Nota media">
 </form>
 
 
  <h2>Registrar Persona</h2>
 <form action="datosPersona.jsp" method="post">
 Nombre: <input type=text name="nombre"><br>
 Apellido: <input type="text" name="ape"><br>
 Edad: <input type="text" name="edad"><br>
 DNI: <input type="text" name="dni"><br>
 Puesto: <input type="text" name="puesto"><br>
 <input type="submit" value="Registro">
 </form>
 
</body>
</html>