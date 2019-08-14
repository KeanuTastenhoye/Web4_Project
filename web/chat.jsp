<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Chat" />
</jsp:include>
<body>
    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Chat" />
    </jsp:include>
    <main>

        <h2>Welcome <span id="user">${user.getUserId()}</span></h2>

        <style>
            div.status {text-align: right;}
            button.stoemeKnop {text-align: left;}
        </style>

        <div class="status">
            <p>Current Status: <span id="currentStatus"> </span></p>
        </div>

        <br>

        <c:forEach var="error" items="${friendErrors}">
            <li>${error}</li>
        </c:forEach>

        <button class="stoemeKnop" id="fancyShow">Show friendslist</button>
        <br>
        <button class="stoemeKnop" id="fancyHide">Hide friendslist</button>

        <br>

        <h3>Friends Overview</h3>

        <br>

        <h5>Online: <span id="onlineFriends"></span></h5>
        <h5>Offline: <span id="offlineFriends"></span></h5>

        <table>
            <thead>
                <tr>
                    <th>User Id</th>
                    <th>Status</th>
                    <th>Chat</th>
                </tr>
            </thead>
            <tbody id="friends">

            </tbody>
            </table>

        <br>

        <p>Change status: </p>
            <input type="text" name="newStatus" id="newStatus" list="userStatus">
            <datalist id="userStatus">
                <option value="Online">
                <option value="Offline">
                <option value="Away">
            </datalist>
        <button type="submit" onclick="changeStatus()">Change Status</button>

        <br>

        <p>Add friend: </p>
        <input id="newFriend" type="text">
        <button type="submit" onclick="addFriend(), getFriends()">Add Friend</button>

        <br>

        <h3>Chat</h3>

        <div id="chatBody">
        </div>

    </main>
    <br>
    <jsp:include page="footer.jsp">
        <jsp:param name="title" value="Chat" />
    </jsp:include>
</body>
</html>
