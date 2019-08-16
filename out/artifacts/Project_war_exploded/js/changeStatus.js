var changeStatusRequest = new XMLHttpRequest();

var logOut = document.getElementById("logoutbutton");
logOut.onclick = setOffline;

window.onload = start;

//Creates a simple cookie with only one value: loggedIn
//This allows us to properly know if the user is logged in or not
function setCookie(boolLoggedIn) {
    document.cookie = "loggedIn=" + boolLoggedIn.toString()
}

//Deletes the cookie on call
function deleteCookie(name) {
    document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT; path=/;';
}

//Changes status based on what the user inputs on the website
function changeStatus() {
    var newStatusValue = document.getElementById("newStatus").value;
    var information = "newStatus=" + encodeURIComponent(newStatusValue);

    changeStatusRequest.open("POST", "Controller?action=ChangeStatus", true);
    changeStatusRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    changeStatusRequest.send(information);

    var currentStatus = document.getElementById("currentStatus");

    if (newStatusValue === "") {
        currentStatus.innerHTML = "online"
    } else {
        currentStatus.innerHTML = newStatusValue;
    }
}

//Changes status via the console if the user wants to
function changeStatusWithString(userStatus) {
    var newStatusString = userStatus.toString();
    var information = "newStatus=" + encodeURIComponent(newStatusString);

    changeStatusRequest.open("POST", "Controller?action=ChangeStatus", true);
    changeStatusRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    changeStatusRequest.send(information);
    console.log(changeStatusRequest);

    var currentStatus = document.getElementById("currentStatus");

    if (newStatusString === "") {
        currentStatus.innerHTML = "online"
    } else {
        currentStatus.innerHTML = newStatusString;
    }
}

//Sets the user as online properly and sets the created cookie as true
function setOnline(){
    if (document.cookie.toString() === "loggedIn=true") {
        return;
    } else {
        changeStatusWithString("online");
        setCookie(true);
    }
}

function setOffline() {
    changeStatusWithString("offline");
    deleteCookie("loggedIn")
}

//For body onload
function start() {
    console.log("In start");
    if (document.cookie.toString() !== "loggedIn=true") {
        console.log("ehehhehe");
        setOnline();
        changeStatusWithString("online");
    }
}