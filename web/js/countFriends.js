var logIn = document.getElementById("loginbutton");
logIn.onclick = getAmountStatus();

function getAmountStatus() {
    $.ajax({
        type: "POST",
        url: "Controller?action=GetAmountStatus",
        dataType: "json",
        success: function(aantal) {
            var aantalOff = aantal.valueOf().toString().charAt(0);
            var aantalOn = aantal.valueOf().toString().charAt(1);

            $('#aantalOnline').text(aantalOn);
            $('#aantalOffline').text(aantalOff);
        }
    });
}
