var xHTTPFriend = new XMLHttpRequest();

function addFriend() {
    xHTTPFriend.open("POST", "Controller?action=AddFriend", true);
    xHTTPFriend.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    var newFriendID = document.getElementById("newFriend").value;
    document.getElementById("newFriend").value = "";
    xHTTPFriend.send("newFriendID=" + newFriendID);
}