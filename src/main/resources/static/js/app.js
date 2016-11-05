function registerValidate(value) {
    var nameInput = $("#nameInput").val();
    var lastNameInput = $("#lastNameInput").val();
    var phoneInput = $("#phoneInput").val();
    var newLoginInput = $("#newLoginInput").val();
    var nawPassInput = $("#newPassInput").val();
    var repeatPassInput = $("#repeatPassInput").val();

    var regLetter = /^[A-ZĄĆĘŁŃÓŚŻŹ]{1}[a-ząćęłńóśżź]{1,50}$/;
    var regLog = /^[A-Za-z0-9]{1,50}$/;
    var regPhone = /^[0-9]{3}\-[0-9]{3}\-[0-9]{3}$/;

    switch (value) {
        case 1:
            // imie
            if (!nameInput.match(regLetter)) {
                $("#divName").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divName").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
        case 2:
            // nazwisko
            if (!lastNameInput.match(regLetter)) {
                $("#divLastName").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divLastName").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
        case 3:
            // telefon
            if (!phoneInput.match(regPhone)) {
                $("#divPhone").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divPhone").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
        case 4:
            // login
            if (!newLoginInput.match(regLog)) {
                $("#divNewLogin").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divNewLogin").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
        case 5:
            // powtorzone haslo
            if (!repeatPassInput.isEqual(nawPassInput)) {
                $("#divrepeatpass").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divrepeatpass").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
    }
}

function horseValidate(value) {
    var horseNameInput = $("#horseNameInput").val();
    var motherNameInput = $("#motherNameInput").val();
    var fatherNameInput = $("#fatherNameInput").val();
    var breedInput = $("#breedInput").val();
    var countryInput = $("#countryInput").val();
    var colorInput = $("#colorInput").val();
    var bornDateInput = $("#bornDateInput").val();
    var passportInput = $("#passportInput").val();

    var regLetter = /^[A-ZĄĆĘŁŃÓŚŻŹ]{1}[a-ząćęłńóśżź]{1,50}$/;
    var regPassport = /^[A-Z0-9]{1,50}$/;
    var regBornDate = /^[0-9]{2}\-[0-9]{2}\-[0-9]{4}$/;

    switch (value) {
        case 1:
            // imie
            if (!horseNameInput.match(regLetter)) {
                $("#divHorseName").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divHorseName").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
        case 2:
            // matka
            if (!motherNameInput.match(regLetter)) {
                $("#divMotherName").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divMotherName").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
        case 3:
            // ojciec
            if (!fatherNameInput.match(regLetter)) {
                $("#divFatherName").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divFatherName").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
        case 4:
            // rasa
            if (!breedInput.match(regLetter)) {
                $("#divBreed").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divBreed").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
        case 5:
            // kraj
            if (!countryInput.match(regLetter)) {
                $("#divCountry").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divCountry").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
        case 6:
            // masc
            if (!colorInput.match(regLetter)) {
                $("#divColor").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divColor").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
        case 7:
            // dataurodzenia
            if (!bornDateInput.match(regBornDate)) {
                $("#divBornDate").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divBornDate").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
        case 8:
            // paszport
            if (!passportInput.match(regPassport)) {
                $("#divPassport").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divPassport").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
    }
}