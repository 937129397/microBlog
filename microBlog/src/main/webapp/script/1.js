// JavaScript Document
$(document).ready(function(){
	//隐藏 #back-top 先
	$("#back-top").hide();
	// 滚动条距顶100px显示 #back-top
	$(function () {
		$(window).scroll(function () {
			if ($(this).scrollTop() > 100) {
				$('#back-top').fadeIn();
			} else {
				$('#back-top').fadeOut();
			}
		});
		// 点击事件 回到顶部
		$('#back-top a').click(function () {
			$('body,html').animate({
				scrollTop: 0
			}, 600);
			return false;
		});
	});
 
});