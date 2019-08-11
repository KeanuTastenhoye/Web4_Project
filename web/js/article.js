deleteCookie("loggedIn");

//deletes the cookie on call
function deleteCookie(name){
    document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT; path=/;';
}

var webSocket;
var backButton = document.getElementById("backButton")
var sendButton = document.getElementById("postCommentButton")

backButton.onclick = closeSocket;
sendButton.onclick = send;

window.onload = openSocket;

function openSocket() {
    webSocket = new WebSocket("ws://localhost:8080/Comment");

    webSocket.onmessage = function(event) {
        writeResponse(event.data);
    }
}

function send() {
    var comment = "Rating: " + document.getElementById("rating").value +
                  " - Username: " + document.getElementById("username").value +
                  " - Comment: " + document.getElementById("comment").value;
    webSocket.send(comment);
}

function closeSocket() {
    webSocket.close();
}

function writeResponse(text) {
    var commentSection = document.getElementById("commentSection");
    var commentDiv = document.createElement("div");
    var comment = document.createTextNode(text);
    var elementComment = document.createElement("p");

    commentDiv.id = "card";

    elementComment.appendChild(comment);
    commentDiv.appendChild(elementComment);
    commentSection.appendChild(commentDiv);
}