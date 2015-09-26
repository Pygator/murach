"use strict";
var fields = {
    email: {
        message: "Must be a valid email address.",
        required: "Email address is required.",
        isEmail: "Email address is invalid."
    },
    password: {
        required: "Password is required."
    },
    verify: {
        required: "Please retype your password.",
        noMatch: ["Passwords do not match.", "password"]
    },
    first_name: {
        required: "First name is required."
    },
    last_name: {
        required: "Last name is required."
    },
    zip: {
        message: "Use 5 or 9 digit ZIP code.",
        required: "ZIP Code is required.",
        isZip: "ZIP Code is invalid."
    },
    card_number: {
        message: "Use 1111-2222-3333-4444 format.",
        required: "Card number is required.",
        isCC: "Card number is invalid."
    },
    exp_date : {
        message: "Use mm/yyyy format.",
        required: "Expiration date is required.",
        isDate: "Expiration date is invalid.",
        expired: "Card has expired."
    }
};