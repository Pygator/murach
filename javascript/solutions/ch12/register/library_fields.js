"use strict";
var fields = {
    email: {
        message: "Must be a valid email address.",
        required: "Email is required.",
        isEmail: "Email is not valid."
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
    phone: {
        message: "Use 555-123-4567 format.",
        required: "Phone number is required.",
        isPhone: "Phone number is not valid."
    },
    zip: {
        message: "Use 5 or 9 digit ZIP code.",
        required: "ZIP Code is required.",
        isZip: "ZIP Code is not valid."
    },
    card_number: {
        message: "Use 1111-2222-3333-4444 format.",
        required: "Card number is required.",
        isCC: "Card number is not valid."
    },
    exp_date : {
        message: "Use mm/yyyy format.",
        required: "Expiration date is required.",
        isDate: "Expiration date is not valid.",
        expired: "Card has expired."
    }
};