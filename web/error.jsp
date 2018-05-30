<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="errorMsg" type="java.lang.String" scope="request"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Erreur</title>
    <link rel= "stylesheet" href="styles/blueStyle.css">

</head>

<body>
    <h6>
        Impossible de joindre l'application centrale, assurez vous que le fichier:<br />
        <i>/tmp/server.cfg</i> est bien configuré et que l'application centrale est lancée <br />
        Redemarrez par la suite le serveur grace a la commande <i>service tomcat8 restart</i> <br />
        <i><c:out value="${errorMsg}"/></i><br />
        Note: Si l'erreur indique "Permission non accordée", executez la commande <i>chown tomcat8:tomcat8 /tmp/server.cfg</i>
    </h6>
</body>
</html>
