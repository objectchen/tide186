$(function(){
	animationNine($(".elem1Action"),$("#elem1"));
		
	/*缩略图动画*/
	animationSeven($(".smallAction"),$("#smallPic"));
	animationNine($(".sTitleAction"),$("#smallTitle"));
	animationNine($(".sConAction"),$("#smallCon"));
	
	/*图文排版动画*/
	animationNine($(".fTitleAction"),$("#txtPic h3"));
	animationNine($(".fConAction"),$("#txtPic p"));
	
	/*设置按钮展示动画*/
	animationSeven($(".btn1Sel"),$("#btn1"));
	animationSeven($(".btn2Sel"),$("#btn2"));
	animationSeven($(".btn3Sel"),$("#btn3"));
	animationSeven($(".btn4Sel"),$("#btn4"));
	
	/*九种动画效果*/
	function animationNine($select,elem){
		$select.change(function(){
			var i=$(this).find("option:selected").index();
			switch(i){
				case 0:
					elem.removeClass();
					break;
				case 1:
					elem.removeClass().addClass('pulse');
					break;
				case 2:
					elem.removeClass().addClass('flipInX');
					break;
				case 3:
					elem.removeClass().addClass('flipInY');
					break;
				case 4:
					elem.removeClass().addClass('fadeInUpBig');
					break;
				case 5:
					elem.removeClass().addClass('fadeInDownBig');
					break;
				case 6:
					elem.removeClass().addClass('bounceInDown');
					break;
				case 7:
					elem.removeClass().addClass('fadeInLeft');
					break;
				case 8:
					elem.removeClass().addClass('fadeInRight');
					break;
				case 9:
					elem.removeClass().addClass('bounceIn');
					break;
			}
		})
	}
	
	/*七种动画效果*/
	function animationSeven($select,elem){
		$select.change(function(){
			var i=$(this).find("option:selected").index();
			switch(i){
				case 0:
					elem.removeClass();
					break;
				case 1:
					elem.removeClass().addClass('flipInX');
					break;
				case 2:
					elem.removeClass().addClass('flipInY');
					break;
				case 3:
					elem.removeClass().addClass('fadeInUpBig');
					break;
				case 4:
					elem.removeClass().addClass('fadeInDownBig');
					break;
				case 5:
					elem.removeClass().addClass('bounceInDown');
					break;
				case 6:
					elem.removeClass().addClass('rollInLeft');
					break;
				case 7:
					elem.removeClass().addClass('rollInRight');
					break;
			}
		})
	}
	
	
	/*逐帧动画背景动画*/
	animationTwo($(".zhuzhenBg"),$(".elemBg"));
	/*多图滑动背景动画*/
	animationTwo($(".duohuaBg"),$(".picBg"));	
	/*多图预览背景动画*/
	animationTwo($(".duoyuBg"),$(".lookBg"));
	/*图文排版背景动画*/
	$('.tuwenBg').change(function(){
		var i=$(this).find("option:selected").index();
		if(i==0){
			$(this).parents('.settingTable').find('.checkBoxTip').html('最佳图片尺寸：640*1008像素&nbsp;&nbsp;&nbsp;&nbsp;格式：jpg/png&nbsp;&nbsp;&nbsp;&nbsp;大小不超过300K');
			$("style").remove();
			$('.fontBg').find('img').removeAttr('style');
		}else if(i==1){
			$(this).parents('.settingTable').find('.checkBoxTip').html('高1008像素 宽不限 格式：jpg/png 大小不超过300K');
			$("style").remove();
			$('.fontBg').find('img').css({'width':'auto','height':'100%'});
		    pingyifunction($('.fontBg'));
		   
		}else if(i==2){
			$(this).parents('.settingTable').find('.checkBoxTip').html('拉伸建议尺寸：640*960像素 格式：jpg/png 大小不超过300K');
			$("style").remove();
			$('.fontBg').find('img').css({'width':'auto','height':'100%'});
		    lashenfunction($('.fontBg'));
		}
	})
	/*电子相册背景动画*/
	animationTwo($(".xiangceBg"),$(".photoBg"));
	/*拉伸平移特效切换*/
	function animationTwo($select,elem){
		$select.change(function(){
			var i=$(this).find("option:selected").index();
			switch(i){
				case 0:
					$(this).parents('.signCon').find(".blackTip").animate({'bottom':'-83px'},500);
					$("style").remove();
					elem.find('img').removeAttr('style');
					
					break;
				case 1:
					$(this).parents('.signCon').find(".blackTip").html('<p>高1008像素 宽不限 格式：jpg/png 大小不超过300K</p>');
					$(this).parents('.signCon').find(".blackTip").animate({'bottom':'0px'},500);
					//elem.removeClass().addClass('shake');
					$("style").remove();
					elem.find('img').css({'width':'auto','height':'100%'});
					pingyifunction(elem);
					break;
				case 2:
					$(this).parents('.signCon').find(".blackTip").html('<p>拉伸建议尺寸：640*960像素 格式：jpg/png 大小不超过300K</p>');
					$(this).parents('.signCon').find(".blackTip").animate({'bottom':'0px'},500);
					$("style").remove();
					elem.find('img').css({'width':'auto','height':'100%'});
					lashenfunction(elem);
					break;
				}
		})
	}
	
    /*平移动画*/ 
	function pingyifunction($Bg) {
		var panoramaImgIndex = 0;
		var $panoramaImg = $Bg.attr("id", "panoramaImg1" + (++panoramaImgIndex));
		var $img = $Bg.find("img");
		var panoramaImgID1 = $panoramaImg.attr("id");
		var boxWidth = $panoramaImg.width();
		var imgWidth = $img.width(),
			imgHeight = $img.height();
		var moveX = (moveX = imgWidth - boxWidth) > 0 ? moveX: 0;
		var animationStyle = "@-webkit-keyframes " + panoramaImgID1 + "_default{" + "0% {-webkit-transform: translateX(0px);}" + "50% {-webkit-transform: translateX(-" + moveX + "px);}" + "100% {-webkit-transform: translateX(0px);}" + "}";
		   var styleUrl = "<style>"+ animationStyle +"</style>"
		   $("head").append(styleUrl);
		   $img.css("-webkit-animation", panoramaImgID1 + "_default " + ($img.width() / 65).toFixed(2) + "s linear infinite")
	}
    
    /*拉伸动画*/ 
	function lashenfunction($Bg) {
		var panoramaImgIndex = 0;
		var $panoramaImg = $Bg.attr("id", "panoramaImg2" + (++panoramaImgIndex));
		var panoramaImgID2 = $panoramaImg.attr("id");
		var boxWidth = $panoramaImg.width();
        var boxHeight = $panoramaImg.height();
        var $img = $Bg.find("img");
        var imgWidth = $img.width(),
        imgHeight = $img.height();
        var moveX = moveY = 0;
        if ((imgWidth / imgHeight) < (boxWidth / boxHeight)) {
            imgWidth = $img.width();
            imgHeight = $img.height();
            moveY = (moveY = (imgHeight - boxHeight) / 2) > 0 ? moveY: 0
        } else {
            imgWidth = $img.width();
            imgHeight = $img.height();
            moveX = (moveX = (imgWidth - boxWidth) / 2) > 0 ? moveX: 0
        }
        var moveX = (moveX = (imgWidth - boxWidth) / 2) > 0 ? moveX: 0;
        var animationStyle = "@-webkit-keyframes " + panoramaImgID2 + "_default{" + "0% {-webkit-transform: translate(-" + moveX + "px, -" + moveY + "px) scale(1);}" + "100% {-webkit-transform: translate(-" + moveX + "px, -" + moveY + "px) scale(1.2);}" + "}";
        
        var styleUrl = "<style>"+ animationStyle +"</style>"
		$("head").append(styleUrl);
        
        $img.css("-webkit-animation", panoramaImgID2 + "_default 10s linear  forwards")
	}	

})
