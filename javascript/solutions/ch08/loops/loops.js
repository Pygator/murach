"use strict";
var $ = function(id) { return document.getElementById(id); };

var getRandomNumber = function(max) {
    var random;
    if (!isNaN(max)) {
        random = Math.random(); //value >= 0.0 and < 1.0
        random = Math.floor(random * max); //value is an integer between 0 and max - 1
        random = random + 1; //value is an integer between 1 and max
    }
    return random;
};

// average rolls for a 6
var averageRolls = function() {
	var total = 0;
	var max = -Infinity;
	var rolls;
	
	for ( var count = 1; count < 10000; count++ ) {
		rolls = 0;
		do {
			rolls++;
		}
		while ( getRandomNumber(6) !== 6 )
		total += rolls;
		if ( rolls > max ) max = rolls;
	}
	var average = total / count;
	alert ("Average rolls: " + average.toFixed(0) + "\n\nMax rolls: " + max);
}
// display factors
var displayFactors = function() {
	var number = $("number").value;
	var factors = "";
	for ( var i = 1; i < number; i++ ) {
		if ( number % i === 0 ) {
			factors +=  i + " ";
		}
	}
	alert("Factors of ".concat(number, ": ", factors));
}
// determine if number is prime
var isPrime = function(i) {
	var number = i;
	var prime = true;
	var returnValue;
	for ( var i = 2; i < number; i++ ) {
		if ( number % i === 0 ) {
			prime = false;
			break;
		}
	}
	return (prime) ? number : 0;
//	if (prime === true) {
//		return number;
//	}
//	else {
//		return 0;	
//	}
}
// get all the prime numbers <= the number entered
var getPrimeNumbers = function() {
	var number = $("number").value;
	var primeList = "";
	var primeCount = 0;
	var primeArray = [];
	var returnedNumber;
	for ( var i = 2; i <= number; i++ ) {
		returnedNumber = isPrime(i);
		if (returnedNumber !== 0) {
			primeList = primeList + returnedNumber + " ";
			primeCount++ 
		}
	}
	$("count").value = primeCount;
	$("primes").value = primeList;
}
// determine if a number is prime
var determineIfPrime = function() {
	var number = $("number").value;
	var result = isPrime(number);
	var message;
	
	if (result == number) {
	    message = number + " is prime.";
	} else {
	    message = number + " is not prime.";
	}
	$("primes").value = message;
}
// click event handler for Calculate button
var processEntries = function() {
	//averageRolls();
	//displayFactors();
	//determineIfPrime();
	getPrimeNumbers();
}

window.onload = function() {
	$("calculate").onclick = processEntries;
	$("number").focus();
};
