$(function() {
	var $slider = $('.panel-inner'); 							//get the slider
	var liW = 101; 												//define single LI width
	var liFW = parseInt(liW * ($slider.find('li').length + 1)); //find the full width of the UL 191 * LI's
	$slider.css('width', liFW + 'px'); 							//apply the full-width to the UL
	$('.button').click(function() {
																//if arrow right OR left, get the current left: CSS property of the UL
		var leftX = (this.id == 'right') ? parseInt($slider.css('left').toString().replace('-', '')) : parseInt($slider.css('left'));
																//check and see if we have reached the end OR start of the UL width
		var leftY = (this.id == 'right') ? ((leftX + 404) == liFW) ? 0: -(leftX + liW) : (leftX < 0) ? -(parseInt(leftX.toString().replace('-', '')) - liW) : 0;
																	//apply the animation
		rotate(leftY);
	});
	var rotate = function(leftY) {$slider.animate({left: leftY},500);}
});