<%@ page import="model.Information" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Welcome in DI</title>
        <link rel= "stylesheet" href="styles/blueStyle.css">
        <script type="text/javascript" src="script/jquery.min.js"> </script>
        <script type = "text/javascript" src="script/translateRoute.js"> </script>
        <script type = "text/javascript">
            function msg()
            {
              var name=document.getElementById("name");
              name.innerHTML="Recherche en cours...\n Veuillez patienter";
            }
        </script>
        <jsp:useBean id="informations" type="java.util.ArrayList" scope="request" />
    </head>

    <body>
        <ul>
            <li>
                <a class="lang" key="language">Language</a>
                <ul>
                    <li id="en" class="translate"><a>English</a></li>
                    <li id="fr" class="translate"><a>Français</a></li>
                    </ul>
            </li>
        </ul>

        <br/>
        <br/>
        <center>
        <h1 class="lang" key="welcome">Welcome in DI</h1>
        <br/>
        <h3 class="lang" key="chooseItinerary"> Choose your itinerary  </h3>

        <form method="post" action="/ResultEnd">

            <h3 class="lang" key="PointStarting" > Choose your starting point </h3>
            <div class="select-field">
                <select name="pointDepart">
                    <c:forEach var="point" items="${informations}">
                        <option value="<c:out value="${point.name}" />"><c:out value="${point.name}" /></option>
                    </c:forEach>
                </select>
            </div>
            
            <br/>

            <h3 class="lang" key="destination" > Choose your point of arrival </h3>
            <div class="select-field">
                <select name="pointArrive">
                    <c:forEach var="point" items="${informations}">
                        <option value="<c:out value="${point.name}" />"><c:out value="${point.name}" /></option>
                    </c:forEach>
                </select>
            </div>
            <br/>
            <input key="buttonItinerary" type="submit" class ="Button" onclick="msg()" value="Search itinerary" />

        </form>
        </center>
    </body>
</html>
