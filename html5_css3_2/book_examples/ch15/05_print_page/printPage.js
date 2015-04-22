var $ = function(id) {
	return document.getElementById(id);
}
var printPage = function() {
    window.print(); 
}
window.onload = function() {
	$("print").onclick = printPage;
}