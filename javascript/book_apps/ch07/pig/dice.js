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
var changePlayer = function() {
    if ($("current").firstChild.nodeValue == $("player1").value) { 
        $("current").firstChild.nodeValue = $("player2").value; 
    } else { 
        $("current").firstChild.nodeValue = $("player1").value; 
    }
    $("die").value = "0";
    $("total").value = "0";
    $("roll").focus();
};
var newGame = function() {
    $("score1").value = "0";
    $("score2").value = "0";
    
    if ($("player1").value == "" || $("player2").value == "") {
        $("turn").removeAttribute("class");
        alert("Please enter two player names.");
    } else {  
        $("turn").setAttribute("class", "open");
        changePlayer();
    }
};
var rollDice = function() {
    var total = parseInt($("total").value);
    var die = getRandomNumber(6);
    if (die == 1) { 
        total = 0; 
        changePlayer();
    } else { total = total + die; }
    
    $("die").value = die;
    $("total").value = total; 
};
var holdTurn = function() {
    var score;
    var total = parseInt($("total").value);
    if ( $("current").firstChild.nodeValue == $("player1").value) { 
        score = $("score1"); 
    } 
    else { score = $("score2"); }
    
    score.value = parseInt(score.value) + total;
    if (score.value >= 100) {
        alert($("current").firstChild.nodeValue + " WINS!");
        newGame();
    } else { changePlayer(); }
};
window.onload = function() {
    $("new_game").onclick = newGame;
    $("roll").onclick = rollDice;
    $("hold").onclick = holdTurn;
};