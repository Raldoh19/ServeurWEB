

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="listNoeud" type="java.util.List<model.Node>" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel= "stylesheet" href="styles/blueStyle.css">
</head>
<style>
    img
    {
        image-orientation: from-image;
    }
    .center img
    {
        vertical-align: top;
        max-width: inherit;
        max-height: inherit;
        image-orientation: from-image;
        text-align: center;
    }
    body
    {
        background-image: url("/images/misc/background.jpg");
        background-size: cover;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        -o-background-size: cover;
    }
    .center
    {
        width:auto;
        height: auto;
        max-width: 600px;
        max-height: 300px;
    }
    .floating-dir
    {
        position: absolute;
        top: 8px;
        right: 16px;
        font-family: sans-serif;
        background: yellowgreen;
        padding: 5px;
        width: 180px;
        z-index: 100;
    }
    .floating-dir h2
    {
        font-size: 0.9em;
        display: block;
        margin: 0 0.5em;
        color: white;
    }
    .floating-dir h3 {
        font-size: 1em;
        display: block;
        margin: 0 0.5em;
        color: white;
    }

    .floating-menu
    {
        font-family: sans-serif;
        background: yellowgreen;
        padding: 5px;;
        width: 180px;
        z-index: 100;
        position: fixed;
    }
    .floating-menu h2
    {
        font-size: 0.9em;
        display: block;
        margin: 0 0.5em;
        color: white;
    }
    .floating-menu h3 {
        font-size: 1em;
        display: block;
        margin: 0 0.5em;
        color: white;
    }
</style>
<main>
    <nav class="floating-menu">
        <h3>Pos. actuelle:</h3>
        <h2>Nom: <c:out value="${listNoeud[index].information.name}"/></h2>
        <h2>Type: <c:out value="${listNoeud[index].information.type}"/></h2>
        <img src="<c:out value="${listNoeud[index].information.image}"/>" width="180" height="220" />
    </nav>

    <div class="floating-dir">
        <h3>Prochain point:</h3>
        <h2> <c:out value="${listNoeud[index+1].information.name}" /></h2>
        <h3>Type de noeud:</h3>
        <h2><c:out value="${listNoeud[index+1].information.type}"/></h2>
        <c:choose>
            <c:when test="${listNoeud[index].directionToTake.toString() eq 'EAST'}">
                <img src=/images/direction/droite.png width="180" height="120">
            </c:when>
            <c:when test="${listNoeud[index].directionToTake.toString()  eq 'WEST'}">
                <img src=/images/direction/gauche.png width="180" height="120">
            </c:when>
            <c:when test="${listNoeud[index].directionToTake.toString()  eq 'NORTH'  }">
                <img src=/images/direction/haut.png width="180" height="120">
            </c:when>
            <c:when test="${listNoeud[index].directionToTake.toString()  eq 'SOUTH'  }">
                <img src=/images/direction/bas.png width="180" height="120">
            </c:when>
        </c:choose>
    </div>
    <center>
        <figure class="center">
            <i>
                Mettez vous dos à la salle que vous voyez à gauche.<br/>
                Suivez la direction indiquée à droite jusqu'à atteindre<br/>
                l'image de destination, puis cliquer sur 'Suivant'<br/>
            </i>
            <img src="<c:out value="${listNoeud[index+1 ].information.image}"/>">
            <figcaption>
                <form action="/Result" method="post">
                    <input type="hidden" name="index" value="${index}">
                    <input type="hidden" name="listsize" value="${listNoeud.size()}">
                    <input type="submit" class ="Button" name="submit" value="Suivant">
                </form>
            </figcaption>
        </figure>
    </center>
</main>
</html>