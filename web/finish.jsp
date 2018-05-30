<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="listNoeud" type="java.util.List<model.Node>" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel= "stylesheet" href="styles/blueStyle.css">
</head>
<style>
    body
    {
        background-image: url("/images/misc/background.jpg");
        background-size: cover;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        -o-background-size: cover;
    }
    img
    {
        image-orientation: from-image;
    }
</style>
<main>
    <center>
        <figure>
            <img src="<c:out value="${listNoeud[index].information.image}"/>" width="460" height="345">
            <figcaption>
                Destination atteinte: <c:out value="${listNoeud[index].information.name}" />
            </figcaption>
        </figure>

        <form action="index.html" method="post">
            <input type="submit" class ="Button" name="submit" value="Retour a l'accueil">
        </form>

    </center>
</main>
</html>