var registerForm;

var registerClick = function () {
    $("register").blur();
    if ( registerForm.validateForm() ) {
        alert("Please correct the errors.");
    } else {
        $("registration_form").submit();
    }
}

var resetClick = function () {
    $("reset_form").blur();
    $("registration_form").reset();
    registerForm.resetErrors();
}

window.onload = function () {
    registerForm = new RegisterForm();
    $("register").onclick = registerClick;
    $("reset_form").onclick = resetClick;
}