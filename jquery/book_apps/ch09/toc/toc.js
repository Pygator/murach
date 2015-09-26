$(document).ready(function() {
	// add an h2 heading to the aside
	$("aside").append("<h2>Table of contents</h2>");

	// wrap the h2 text in the article within <a> tags
	$("article h2").wrapInner("<a></a>");
	
	// add ids to the new <a> tags
	$("article a").each (function(index) {
		var id = "heading" + (index + 1);
		$(this).attr("id", id);
	});
		
	// clone the <a> tags in the article and insert them into the aside
	$("article a").clone().insertAfter($("aside h2"));
	
	// remove the id attributes from the <a> tags in the aside
	$("aside a").removeAttr("id");
	
	// add the href attributes to the <a> tags in the aside
	$("aside a").attr("href", function(index) {
	    var href = "#heading" + (index + 1);
		return href;
    });

	// wrap an <a> tag around the h1 text
	$("h1").wrapInner("<a id='top'></a>");
	
	// insert "back to top" <a> tags after each topic
    $("article h2").before("<a href='#top'>Back to top</a>");
	$("article a:first").remove();
	$("article p:last").after("<a href='#top'>Back to top</a>");
})