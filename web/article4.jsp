<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Article 4: Welke muziek luister je meestal?"/>
</jsp:include>
<body onload="openSocket()">
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Article 4: Welke muziek luister je meestal?"/>
</jsp:include>
<main>
    <a href="Controller" id="backButton">
        <button type="submit" onclick="closeSocket()">Back</button>
    </a>

    <div>
        <h1>Welke muziek luister je meestal?</h1>
    </div>

    <div>
        <h3>Comments</h3>
        <div id="commentSection">

        </div>
    </div>

    <div>
        <h3>Post a comment</h3>
        <p>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username"/>
        </p>
        <p>
            <label for="rating">Rating:</label>
            <input type="number" min="0" max="10" id="rating" name="rating"/>
        </p>
        <p>
            <label for="comment">Comment:</label>
            <input type="text" id="comment" name="comment"/>
        </p>
        <p>
            <button type="submit" onclick="send()">Send</button>
        </p>
    </div>

</main>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Article 4: Welke muziek luister je meestal?"/>
</jsp:include>
</body>
</html>