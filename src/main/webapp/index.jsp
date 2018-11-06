<%--
  Created by IntelliJ IDEA.
  User: fernando
  Date: 14/10/18
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome!</title>
    <link rel="stylesheet" href="resources/css/style.css"/>
    <script src="resources/js/script.js" type="text/javascript"></script>
</head>

<body>
    <form id="login-form" onsubmit="return validar_login()" method="post" action="login" >
        <label for="user-email" >Ingrese su email: </label>
        <input name="user-email" id="user-email"  />

        <label for="user-password">Ingrese su password:</label>
        <input type="password"  name="user-password" id="user-password"/>

        <button type="submit" >Ingresar</button>
    </form>
    <p id="validation_error" ></p>
    <p>${loginError}</p>
</body>
</html>
