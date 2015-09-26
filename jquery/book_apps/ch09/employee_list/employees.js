$(document).ready(function() {
	$("#accordion").on("click", "h2", function() {
		$(this).toggleClass("minus");
		if ($(this).attr("class") != "minus") {
		   	$(this).next().hide();
	   	}
	   	else {
	        $(this).next().show();
	   	}
    }); // end click
    
    $("#add").click(function() {
    	var html = "";
    	html += "<h2><a href='#'>" + $("#name").val() + "</a></h2>";
    	html += "<div><h3>" + $("#position").val() + "</h3>";
    	html += "<p>" + $("#description").val() + "</p></div>";
    	$("#accordion").append(html);
    	$("#name").val("");
    	$("#position").val("");
    	$("#description").val("");
    }); // end click
}); // end ready