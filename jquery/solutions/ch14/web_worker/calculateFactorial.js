onmessage = function(e) {
	var factorial = 1;
	for ( var counter = e.data; counter > 1; counter--) {
		factorial = factorial * counter;
	}
	postMessage(factorial);
}