$(document).ready(function(){
	/*获取cookie中的颜色并自动设置*/
	var color = $.cookie("color");
	var deepcolor=$.cookie("deepcolor");
	change(color,deepcolor);
	/*点击更换主题颜色*/
	$(".theme_color").click(function(){
		var colorname=$(this).val();
		if(colorname==0){
			change("#FFB6C1","#DB7093");
		}else if(colorname==1){
			change("#87CEEB","#00BFFF")
		}else if(colorname==2){
			change("#1DA91D","#195E11")
		}
	});
});
function change(color,recolor){
			/*设置到cookie中*/
			$.cookie('color', color, { expires: 7, path: '/' });
			$.cookie('deepcolor', recolor, { expires: 7, path: '/' });
			/*搜索栏颜色更换*/
			$(".search").css("border","3px solid "+color);
			$(".search_submit").css("background-color",color);
			/*导航栏颜色*/
			$(".nav").css("background-color",color);
			$(".nav ul li").css("background-color",color);
			$(".div_section ul li").css("background-color",color);
			/*热销产品*/
			$(".nav_hot").css("background-color",color);
			/*商家列表*/
			$(".nav_type").css("background-color",color);
			$(".floor").css("background-color",recolor);
			/*最新入住商家*/
			$(".leftmar_title").css("background-color",color);
			$(".leftmar").css("border","1px solid "+color);
			/*推荐商家*/
			$(".rightmar_title").css("background-color",color);
			$(".rightmar").css("border","1px solid "+color);
			/*页脚*/
			$(".foot").css("background-color",color);
			/*右侧悬浮*/
			$(".floating_ck dl dd").css("background-color",color);
			$(".floating_left").css("background-color",color);
			
			
			/*注册页样式修改*/
			$(".regist_nav").css("background-color",color);
			$(".tj").css("background-color",color)
			/*产品页样式修改*/
			$(".productsingle").css("border","1px solid"+color)
	}
