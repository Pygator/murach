$(document).ready(function() {
	//DIALOG
	$("#help").click(function() { 
		$("#helpdialog").dialog({
			buttons: { OK: function() {$(this).dialog("close");}
			}
		});
	});
	//TABS
	$("#tabs").tabs();
	//DATEPICKER
	$("#datepicker").datepicker();
	//BUTTON
	$("#submitbutton").button();
	//SLIDER
	$("#slider").slider({
        min: 1,
        max: 100,
        range: true,        
	    values: [11, 50],
        slide: function(event, ui) {
			$("#employees").val(ui.values[0] + " - " + ui.values[1]);
        }
    });
    $("#employees").val(11 + " - " + 50);
});