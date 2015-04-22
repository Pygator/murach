var $ = function (id) { return document.getElementById(id); }

var RegisterForm = function () {
    this.fields = [];
    this.fields["email"] = {};
    this.fields["password"] = {};
    this.fields["verify"] = {};
    this.fields["first_name"] = {};
    this.fields["last_name"] = {};
    this.fields["address"] = {};
    this.fields["city"] = {};
    this.fields["state"] = {};
    this.fields["zip"] = {};
    this.fields["phone"] = {};
    this.fields["date"] = {};

    // Default field messages
    this.fields["email"].message = "Must be a valid email address.";
    this.fields["password"].message = "Must be at least 6 characters.";
    this.fields["state"].message = "Use 2 letter abbreviation.";
    this.fields["zip"].message = "Use 5 or 9 digit ZIP code.";
    this.fields["phone"].message = "Use 999-999-9999 format.";

    // Field error messages
    this.fields["email"].required = "Email is required.";
    this.fields["email"].isEmail = "Email is not valid.";
    this.fields["password"].required = "Password is required.";
    this.fields["password"].tooShort = ["Password is too short.", 6];
    this.fields["verify"].required = "Please retype your password.";
    this.fields["verify"].noMatch = ["Passwords do not match.", "password"];
    this.fields["first_name"].required = "First name is required.";
    this.fields["last_name"].required = "Last name is required.";
    this.fields["address"].required = "Address is required.";
    this.fields["city"].required = "City is required.";
    this.fields["state"].required = "State is required.";
    this.fields["state"].isState = "State is not valid.";
    this.fields["zip"].required = "ZIP Code is required.";
    this.fields["zip"].isZip = "ZIP Code is not valid.";
    this.fields["phone"].required = "Phone number is required.";
    this.fields["phone"].isPhone = "Phone number is not valid.";
    this.fields["date"].required = "Starting date is required.";
}

// Validation methods
RegisterForm.prototype.tooShort = function (text, length) {
    return (text.length < length);
}

RegisterForm.prototype.matches = function (text1, text2) {
    return (text1 == text2);
}

RegisterForm.prototype.isEmail = function (text) {
    if (text.length == 0) return false;
    var parts = text.split("@");
    if (parts.length != 2 ) return false;
    if (parts[0].length > 64) return false;
    if (parts[1].length > 255) return false;
    var address =
        "(^[\\w!#$%&'*+/=?^`{|}~-]+(\\.[\\w!#$%&'*+/=?^`{|}~-]+)*$)";
    var quotedText = "(^\"(([^\\\\\"])|(\\\\[\\\\\"]))+\"$)";
    var localPart = new RegExp( address + "|" + quotedText );
    if ( !parts[0].match(localPart) ) return false;
    var hostnames =
        "(([a-zA-Z0-9]\\.)|([a-zA-Z0-9][-a-zA-Z0-9]{0,62}[a-zA-Z0-9]\\.))+";
    var tld = "[a-zA-Z0-9]{2,6}";
    var domainPart = new RegExp("^" + hostnames + tld + "$");
    if ( !parts[1].match(domainPart) ) return false;
    return true;
}

RegisterForm.prototype.isState = function (text) {
    var states = new Array(
        "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FL",
        "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME",
        "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH",
        "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI",
        "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY");
    for( var i in states ) {
        if ( text == states[i] ) {
            return true;
        }
    }
    return false;
}
RegisterForm.prototype.isZip = function (text) {
    return /^\d{5}(-\d{4})?$/.test(text);
}

RegisterForm.prototype.isPhone = function (text) {
    return /^\d{3}-\d{3}-\d{4}$/.test(text);
}

RegisterForm.prototype.isCC = function (text) {
    return /^\d{4}-\d{4}-\d{4}-\d{4}$/.test(text);
}

RegisterForm.prototype.isDate = function (text) {
    if ( ! /^[01]?\d\/\d{4}$/.test(text) ) return false;
    var dateParts = text.split("/");
    var month = parseInt(dateParts[0]);
    var year = parseInt(dateParts[1]);
    if ( month < 1 || month > 12 ) return false;
    return true;
}

RegisterForm.prototype.hasExpired = function (text) {
    var dateParts = text.split("/");
    var month = parseInt(dateParts[0]);
    var year = parseInt(dateParts[1]);
    var now = new Date();
    var exp = new Date( year, month);
    return ( now > exp );
}

RegisterForm.prototype.validateField = function (fieldName, text) {
    var field = this.fields[fieldName];
    if (field.required) {
        if ( this.tooShort(text,1) ) {
            throw new Error(field.required);
        }
    }
    if (field.tooShort) {
        if ( this.tooShort(text, field.tooShort[1]) ) {
            throw new Error(field.tooShort[0]);
        }
    }
    if (field.noMatch) {
        if ( ! this.matches(text, $(field.noMatch[1]).value ) ) {
            throw new Error(field.noMatch[0]);
        }
    }
    if (field.isEmail) {
        if ( ! this.isEmail(text) ) {
            throw new Error(field.isEmail);
        }
    }
    if (field.isState) {
        if ( ! this.isState(text) ) {
            throw new Error(field.isState);
        }
    }
    if (field.isZip) {
        if ( ! this.isZip(text) ) {
            throw new Error(field.isZip);
        }
    }
    if (field.isPhone) {
        if ( ! this.isPhone(text) ) {
            throw new Error(field.isPhone);
        }
    }
    if (field.isCC) {
        if ( ! this.isCC(text) ) {
            throw new Error(field.isCC);
        }
    }
    if (field.isDate) {
        if ( ! this.isDate(text) ) {
            throw new Error(field.isDate);
        }
    }
    if (field.expired) {
        if ( this.hasExpired(text) ) {
            throw new Error(field.expired);
        }
    }
}

// Error message methods
RegisterForm.prototype.resetErrors = function () {
    var message;
    for ( var fieldName in this.fields ) {
        $(fieldName + "_error").className = "";
        message = this.fields[fieldName].message;
        $(fieldName + "_error").firstChild.nodeValue =
            ( message ) ? message : "";
    }
}

RegisterForm.prototype.clearError = function ( fieldName ) {
    $(fieldName + "_error").className = "";
    $(fieldName + "_error").firstChild.nodeValue = "";
}

// Method to validate form
RegisterForm.prototype.validateForm = function () {
    var hasErrors = false;
    for ( var fieldName in this.fields ) {
        this.clearError(fieldName);
        try {
            this.validateField(fieldName, $(fieldName).value );
        } catch (error) {
            hasErrors = true;
            $(fieldName + "_error").className = "error";
            $(fieldName + "_error").firstChild.nodeValue = error.message;
            
        }
    }
    return hasErrors;
}

