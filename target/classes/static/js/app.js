function registerValidate(value) {
    var nameInput = $("#nameInput").val();
    var lastNameInput = $("#lastNameInput").val();
    var phoneInput = $("#phoneInput").val();
    var newLoginInput = $("#newLoginInput").val();
    var newPassInput = $("#newPassInput").val();
    var repeatPassInput = $("#repeatPassInput").val();
    var licence = $("#licence").val();

    var regLetter = /^[A-ZĄĆĘŁŃÓŚŻŹ]{1}[a-ząćęłńóśżź]{1,50}$/;
    var regLog = /^\w{1,50}$/;
    var regPhone = /^\d{3}-\d{3}-\d{3}$/;
    var regLicence = /^[A-Z0-9]{1,50}$/;

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
            if (repeatPassInput === newPassInput) {
                $("#divRepeatPass").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            else {
                $("#divRepeatPass").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            break;
        case 6:
            // licencja
            if (licence.match(regLicence)) {
                $("#divLicence").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            else {
                $("#divLicence").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
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

function competitionValidate(value) {
    var dateStart = $("#dateStart").val();
    var dateEnd = $("#dateEnd").val();
    var managerTrack = $("#managerTrack").val();
    var manager = $("#manager").val();
    var placeSize = $("#placeSize").val();
    var warmUpSize = $("#warmUpSize").val();
    var ground = $("#ground").val();
    var price = $("#price").val();

    var regLetter = /^[a-zA-ZĄĆĘŁŃÓŚŻŹąćęłńóśżź]{1,50}$/;
    var regNumber = /^\d{1,3}$/;
    var regSize = /^\d{2,3}x\d{2,3}$/;

    switch (value) {
        case 1:
            // data
            if (dateEnd > dateStart) {
                $("#divDate").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divDate").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
        case 2:
            // gospodarz toru
            if (!managerTrack.match(regLetter)) {
                $("#divManagerTrack").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divManagerTrack").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
        case 3:
            // kierownik
            if (!manager.match(regLetter)) {
                $("#divManager").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divManager").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
        case 4:
            // plac konkursowy
            if (!placeSize.match(regSize)) {
                $("#divPlaceSize").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divPlaceSize").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
        case 5:
            // rozprezalnia
            if (!warmUpSize.match(regSize)) {
                $("#divWarmUp").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divWarmUp").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
        case 6:
            // podloze
            if (!ground.match(regLetter)) {
                $("#divGround").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divGround").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
        case 7:
            // wpisowe
            if (!price.match(regNumber)) {
                $("#divPrice").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divPrice").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
    }
}

function organizerValidate(value) {
    var name = $("#name").val();
    var city = $("#city").val();
    var owner = $("#owner").val();
    var nip = $("#nip").val();
    var manager = $("#manager").val();
    var sportClub = $("#sportClub").val();
    var phone = $("#phone").val();

    var regLetter = /^[A-ZĄĆĘŁŃÓŚŻŹ]{1}[a-ząćęłńóśżź]{1,50}$/;
    var regClub = /^\w{1,50}$/;
    var regPhone = /^0\d{2}-\d{3}-\d{2}-\d{2}$/;
    var regNip = /^\d{3}-\d{3}-\d{2}-\d{2}$/;

    switch (value) {
        case 1:
            // nazwa
            if (!name.match(regLetter)) {
                $("#divStableName").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divStableName").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
        case 2:
            // miejscowosc
            if (!city.match(regLetter)) {
                $("#divCity").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divCity").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
        case 3:
            // właściciel
            if (!owner.match(regLetter)) {
                $("#divOwner").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divOwner").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
        case 4:
            // NIP
            if (!nip.match(regNip)) {
                $("#divNip").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            else {
                $("#divNip").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            break;
        case 5:
            // kierownik
            if (manager.match(regLetter)) {
                $("#divManager").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            else {
                $("#divManager").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            break;
        case 6:
            // klub sportowy
            if (sportClub.match(regClub)) {
                $("#divSportClub").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            else {
                $("#divSportClub").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            break;
        case 7:
            // telefon
            if (phone.match(regPhone)) {
                $("#divPhone").css("visibility", "hidden").css("height", "0px").css("margin", "0px").css("padding", "0px");
            }
            else {
                $("#divPhone").css("visibility", "visible").css("height", "30px").css("margin", "3px").css("padding", "5px");
            }
            break;
    }
}