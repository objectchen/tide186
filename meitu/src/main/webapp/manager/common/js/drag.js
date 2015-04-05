$(function(){
	/*btn1*/
	drag($("#btn1"));
	/*btn2*/
	drag($("#btn2"));
	/*btn3*/
	drag($("#btn3"));
	/*btn4*/
	drag($("#btn4"));
    
    function drag(elembtn){
    	var mousex,mousey,btnx,btny,prevx,prevy,newposx,newposy;;
		elembtn.mousedown(function(e) {		
				prevx = e.pageX;			
				prevy = e.pageY;					
				var posl = parseInt(elembtn.css("left"));			
				var post = parseInt(elembtn.css("top"))  
			$(".btnArea").mousemove(function(e) {
						e.preventDefault();
						mousex = e.pageX - prevx			
						mousey = e.pageY- prevy;					
						console.log(mousex+" "+mousey)				
						newposx = posl + mousex;					
						newposy = post + mousey;				
						newposx  = newposx<0?0:newposx					
						//按钮在最右侧					
						newposx  = newposx>178?178:newposx				
						newposy  = newposy<0?0:newposy					
						//按钮在最下侧					
						newposy  = newposy>362?362:newposy
						var $x=newposx/248*100,
							$y=newposy/392*100;
						elembtn.css({left: $x+'%',top: $y+'%' })										
			})
		
		})
		$(document).mouseup(function(e) {
			$(".btnArea").unbind("mousemove");
		});	
	}
})