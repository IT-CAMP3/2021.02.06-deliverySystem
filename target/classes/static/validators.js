function validateLoginData() {
    var login = $('#login-input').val();
    var pass = $('#pass-input').val();

    var passLengthRegexp = new RegExp(/.{8}.*/);
    var passCapitalRegexp = new RegExp(/.*[A-Z]{1}.*/);
    var passCharacterRegexp = new RegExp(/.*[\!\@\#\$\%\^\&\*\?\>\<\;\:\-\_\=\+\.]{1}.*/);
    var passDigitRegexp = new RegExp(/.*[0-9].*/);

    var loginLengthRegexp = new RegExp(/.{3}.*/);

    var isOk = true;

    if(!loginLengthRegexp.test(login)) {
        isOk = false;
        $('#login-input').addClass('invalid');
    } else {
        $('#login-input').removeClass('invalid');
    }

    if(!(passLengthRegexp.test(pass) &&
        passCapitalRegexp.test(pass) &&
        passCharacterRegexp.test(pass) &&
        passDigitRegexp.test(pass))) {
        isOk = false;
        $('#pass-input').addClass('invalid');
    } else {
        $('#pass-input').removeClass('invalid');
    }

    return isOk;
}