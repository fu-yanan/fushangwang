	$(document).ready(function() {
			/*手机端登录初始化*/
			if(/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
				$(".body_search").css("margin-left","20px");
				$(".div_logo ").css({"width":"70px","height":'60px',"margin-top":"40px","margin-left":'0px'});
				$(".phone").css("margin-left","30px");
				$(".nav").css("margin-top","40px");
				/*导航栏调整*/
				$(".nav ul li").css("width","100px");
				//$(".line").css("margin-left","110px");
				/*左侧导航栏调整*/
				$(".div_section ul li").css("height","30px");
				$(".div_section ul li").css("line-height","30px");
				//$(".div_section").css("margin-left","150px");
				$(".div_section").css("width","150px");
				/*图片高度调整*/
				$(".banner").css("height","340px");
				/*图片左间距调整*/
				$(".div_banner a img").css("left","104px");
				$(".div_banner").css("height","340px");
				/*轮播图点调整*/
				$(".point ul").css({"left":"400px","top":"550px"});
				/*商家距离调整*/
				//$(".product ul li").css("margin-left","20px");
				$(".product ul li").css("width","160px");
				$(".product_footer ul li").css("width","140px");
				/*备案信息调整*/
				$(".web").css("margin-left","100px");
			}
		});