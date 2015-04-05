$(function(){
	/*导航*/
	$(".nav li").mouseover(function(){
		$(this).addClass("over").siblings().removeClass("over");
	})
	$(".nav li").mouseout(function(){
		$(this).removeClass("over");
	})
	$(".nav li").click(function(){
		$(this).addClass("cur").siblings().removeClass("cur");
	})
	
	/*弹框*/
	$(".layer .closeIcon").mouseover(function(){
		$(this).addClass("cur");
	})
	$(".layer .closeIcon").mouseout(function(){
		$(this).removeClass("cur");
	})
	$(".layer .closeIcon").click(function(){
		$(".layer").hide();
	})
	$(".layer .quxiao").click(function(){
		$(".layer").hide();
	})
	
	/*输入框交互效果*/
	
	$('input').focus(function(){
		$(this).addClass('focus');
	})
	$('input').blur(function(){
		$(this).removeClass('focus');
	})
	$('textarea').focus(function(){
		$(this).addClass('focus');
	})
	$('textarea').blur(function(){
		$(this).removeClass('focus');
	})
	
	/*鼠标移上效果*/
	mouseOn($('.addQ'));mouseOn($('.sortIcon'));
	mouseOn($('.pageSetting'));
	mouseOn($('.btnSetting'));
	mouseOn($('.saveBtn button'));
	function mouseOn($elem){
		$elem.mouseover(function(){
			$(this).addClass('over');
		})
		$elem.mouseout(function(){
			$(this).removeClass('over');
		})
	}
	
	$('.xIcon').live('click',function(){
		$(".layerDel").fadeIn();
	})
		
	$('.saveBtn button').click(function(){
		$('.layerSave').show();
	})	
})
