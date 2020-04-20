$(document).ready(function(){
	/*在线商家导航栏显示*/
	$(".line").click(function(){
		$(".div_section").toggle();
	});
	/*首页导航栏鼠标移入效果*/
	$(".dh").on("mouseover","li",function(){
		var color=$(".nav_type").css("background-color");
		var color2=$(".floor").css("background-color");
		$(this).css("background-color",color2);
		$(this).siblings().css("background-color",color);
	});
	$(".dh").on("mouseout","li",function(){
		var color=$(".nav_type").css("background-color");
		var color2=$(".floor").css("background-color");
		$(this).css("background-color",color);
		$(this).siblings().css("background-color",color);
	});
	/*首页下拉导航栏鼠标移入效果*/
	$(".dh2").on("mouseover","li",function(){
		var color=$(".nav_type").css("background-color");
		var color2=$(".floor").css("background-color");
		$(this).css("background-color",color2);
		$(this).siblings().css("background-color",color);
	});
	$(".dh2").on("mouseout","li",function(){
		var color=$(".nav_type").css("background-color");
		var color2=$(".floor").css("background-color");
		$(this).css("background-color",color);
		$(this).siblings().css("background-color",color);
	});
});

/*轮播图*/
$(document).ready(function(){
	var t;
	var index=0;
	t=setInterval(play,2000);
	function play(){
		if(index>5){
			index=0;
		}
	$(".point ul li").eq(index).css("border","1px solid #ffffff").siblings().css("border", "");
	$(".div_banner").children().eq(index).children().fadeIn(1000).parent().siblings().children().fadeOut(1000);
		index++;
	}
	
	
	$(".point ul").on("click","li",function() {
	    //添加 移除样式
	    //$(this).addClass("lito").siblings().removeClass("lito"); //给当前鼠标移动到的li增加样式 且其余兄弟元素移除样式   可以在样式中 用hover 来对li 实现
	    $(this).css({
	        "border": "1px solid #ffffff"
	    }).siblings().css({
	        "border": ""
	    })
	    var index = $(this).index(); //获取索引 图片索引与按钮的索引是一一对应的
	    // console.log(index);
	
	    $(".div_banner a img").eq(index).fadeIn(1000).siblings().fadeOut(1000); // siblings  找到 兄弟节点(不包括自己）
	});
	/*视频滚动效果*/
	$(function(){ 
	    $('#Marquee_x').jcMarquee({ 'marquee':'x','margin_right':'20px','speed':20 }); 
	    // 10px代表间距，第二个20代表滚动速度 
		}); 
	/*商家移入移出效果*/
	
	
	$(".nav_each").on("mouseover",".product ul li",function(){
		var color=$(".nav_type").css("background-color");
		$(this).css("background-color",color);
		$(this).css("color","white");
		$(this).css("border","1px solid "+color);
		$(this).siblings().css("background-color","white");
		$(this).siblings().css("background-color","black");
	});
	$(".nav_each").on("mouseout",".product ul li",function(){
		$(this).css("background-color","white");
		$(this).css("color","black");
		$(this).css("border","1px solid gray");
	});
	$(".product_footer ul").on("mouseover","li",function(){
		var color=$(".nav_type").css("background-color");
		$(this).css("background-color",color);
		$(this).css("color","white");
		$(this).css("border","1px solid "+color);
		$(this).siblings().css("background-color","white");
		$(this).siblings().css("background-color","black");
	});
	$(".product_footer ul").on("mouseout","li",function(){
		$(this).css("background-color","white");
		$(this).css("color","black");
		$(this).css("border","1px solid gray");
	});
})

/*视频轮播控制*/
$(document).ready(function(){
	/*只播放一个视频*/
	 var videos = document.getElementsByTagName('video');
	            for (var i = videos.length - 1; i >= 0; i--) {
	                (function(){
	                    var p = i;
	                    videos[p].addEventListener('play',function(){
	                        pauseAll(p);
	                    })
	                })()
	            }
	            function pauseAll(index){
	                for (var j = videos.length - 1; j >= 0; j--) {
	                    if (j!=index) videos[j].pause();
	                }
	            };
	/*鼠标移入静音播放*/
	$("#Marquee_x").on("mouseover","video",function(){
		$(this)[0].play();
	});
	$("#Marquee_x").on("mouseout","video",function(){
		$(this)[0].pause();
	});
	//手机辨识
	function IsPhone(){
	 mobile_flag = false;
	 var screen_width = window.screen.width;
	 var screen_height = window.screen.height;
	 if(screen_width < 500 && screen_height < 820){
	  mobile_flag = true;
	 }
	 return mobile_flag;
	}
	//调整手机
	 var phoneflag=IsPhone();
	 if(phoneflag){
	  $(".nav_hot").css("margin-top","30%");
	  $(".body_search input").eq(0).css("width","200px");
	  $(".body_search").css("width","310px");
	  $(".body_search").css("left","150px");
	 }	

	
});