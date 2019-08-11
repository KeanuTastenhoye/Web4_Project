<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
	<jsp:param name="title" value="Home"/>
</jsp:include>
<body>
	<jsp:include page="header.jsp">
		<jsp:param name="title" value="Home"/>
	</jsp:include>
	<main>
<c:if test="${errors.size()>0 }">
	<div class="danger">
		<ul>
			<c:forEach var="error" items="${errors}">
				<li>${error}</li>
			</c:forEach>
		</ul>
	</div>
</c:if> <c:choose>
	<c:when test="${user!=null}">
		<p>Welcome ${user.getFirstName()}!</p>
		<form method="post" action="Controller?action=LogOut">
			<p>
				<input type="submit" id="logoutbutton" value="Log Out">
			</p>
		</form>

		<br>

		<p> Er zijn <span id="aantalOnline"> </span> vrienden online.</p>
		<p> Er zijn <span id="aantalOffline"> </span> vrienden offline.</p>

	</c:when>
	<c:otherwise>
		<form method="post" action="Controller?action=LogIn">
			<p>
				<label for="username">Your username </label>
				<input type="text" id="username" name="username" value="keanu">
			</p>
			<p>
				<label for="password">Your password</label>
				<input type="password" id="password" name="password" value="t">
			</p>
			<p>
				<input type="submit" id="loginbutton" value="Log in">
			</p>
		</form>
	</c:otherwise>
</c:choose>

		<br>

		<div>
			<h3>Blog posts</h3>
			<div>
				<ul>
					<li>
						<a href="Controller?action=GetArticle&articleNr=1">Hoe was de projectweek?</a>
					</li>
					<li>
						<a href="Controller?action=GetArticle&articleNr=2">Wat vond je van de les?</a>
					</li>
					<li>
						<a href="Controller?action=GetArticle&articleNr=3">Wat zijn je plannen na je studies?</a>
					</li>
					<li>
						<a href="Controller?action=GetArticle&articleNr=4">Welke muziek luister je meestal?</a>
					</li>
					<li>
						<a href="Controller?action=GetArticle&articleNr=5">Wat ga je doen vandaag?</a>
					</li>
					<li>
						<a href="Controller?action=GetArticle&articleNr=6">Wat vond je van het examen Web4?</a>
					</li>
					<li>
						<a href="Controller?action=GetArticle&articleNr=7">Wat is een aangename kamer temperatuur?</a>
					</li>
				</ul>
			</div>
		</div>

		<br>

	</main>

	<jsp:include page="footer.jsp">
		<jsp:param name="title" value="Home" />
	</jsp:include>
</body>
</html>