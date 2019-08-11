var xHRObjectFriends = new XMLHttpRequest();

function getFriends() {
    xHRObjectFriends.open("GET", "Controller?action=GetFriends", true);
    xHRObjectFriends.onreadystatechange = getData;
    xHRObjectFriends.send(null);
}

function getData() {
    var aantalOnline = 0;
    var aantalOffline = 0;
    if (xHRObjectFriends.readyState === 4) {
        if (xHRObjectFriends.status === 200 || xHRObjectFriends.status === 500) {
            var serverResponse = JSON.parse(xHRObjectFriends.responseText);
            var html = "";
            for (var i = 0; i < serverResponse.length; i++) {
                var userId = serverResponse[i].userId;
                html += "<tr>" + "<td>" + serverResponse[i].userId  + "</td>" + "<td>" + serverResponse[i].userStatus + "</td>" + "<td>" + "<button id='chatknop' onclick='createChatPopUp(\"" + userId + "\")'>Chat</button>" + "</td>" + "</tr>"
                if (serverResponse[i].userStatus === "Offline") {
                    aantalOffline += 1;
                } else {
                    aantalOnline += 1;
                }
            }
            document.getElementById("friends").innerHTML = html;
            document.getElementById("onlineFriends").innerHTML = aantalOnline;
            document.getElementById("offlineFriends").innerHTML = aantalOffline;

            setTimeout(getFriends, 2000);
        }
    }
}

//Create Chat popup
function createChatPopUp(userId) {
    var html = "<div id=\'" + userId + "\'>" +
                    "<h4>" + userId + "</h4>" +
                    "<div id='message'>" +
                    "</div>" +
                    "<div id='messageDIV" + userId + "'>" +
                        "<input type='text' id='chatMessage" + userId + "'>" +
                        "<button id='chatMessageSend' onclick='sendChatMessage(\"" + userId + "\")'>Send Message</button>" +
                    "</div>" +
               "</div>";

    document.getElementById("chatBody").innerHTML = html;
}

//Send input after button click
function sendChatMessage(userId) {
    $.ajax({
        type: "POST",
        url: "Controller?action=SendMessage",
        data: {
            userId: userId,
            chatMessage: document.getElementById("chatMessage" + userId).value
        },
        dataType: "json",
        success: function() {
            setInterval(getChatMessage(userId), 600);
        }
    });
}

//Get Messages
function getChatMessage(userId) {
    $('#message').empty();
    $.ajax({
        type: "GET",
        url: "Controller?action=GetMessage&chatBuddy=" + userId,
        dataType: "json",
        success: function(msgJSON) {
            $(msgJSON).each(function(index, b) {
                $('#message').append($('<p />').text(b.writer + ": " + b.bericht));
            });
        },
        error: function() {
            alert("Ai");
        }
    });
}