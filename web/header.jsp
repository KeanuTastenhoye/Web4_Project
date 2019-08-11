<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header role="banner">
    <img alt="Hackerman" src="images/hackerman.jpg">
    <img alt="Hackerman" src="images/hackerman.jpg">
    <img alt="Hackerman" src="images/hackerman.jpg">

    <h1>
        <span>Chat App</span>
    </h1>

    <nav>
        <ul>
            <c:choose>
                <c:when test="${param.title=='Home'}">
                    <li id="actual">
                        <a href="Controller?action=Index">Home</a>
                    </li>
                    <li>
                    <a href="Controller?action=NaarChat">Chat</a>
                    </li>
                </c:when>
                <c:when test="${param.title=='Chat'}">
                    <li>
                        <a href="Controller?action=Index">Home</a>
                    </li>
                    <li id="actual">
                        <a href="Controller?action=NaarChat">Chat</a>
                    </li>
                </c:when>
            </c:choose>
        </ul>
    </nav>

    <h2>${param.title}</h2>
</header>