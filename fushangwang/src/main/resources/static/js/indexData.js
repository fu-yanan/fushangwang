$(document).ready(function(){
	$.ajax({   /*作用于异步与后端交互*/
		type:"post",      //请求类型 
		url:"getHomeData",//往后端的请求
		data:{},   //参数
		dataType:"json",
		success:function(result){    //回调函数
			console.log(result);
			/*欢迎语设置*/
			$(".welcometext").text(result.welcomeText);
			
			/*网站顶部网址设置*/
			$(".local").text(result.getLocal);
			
			/*服务时间设置*/
			$(".time").text(result.getWorkTime);
			
			/*电话设置*/
			$(".phobe_number").text(result.getPhone);
			$(".qrcord_p02").append("<b>"+result.getPhone+"</b>");
			
			/*下拉名称设置*/
			$(".line").text(result.getLineName);
			//页脚设置
			$(".bq").text(result.getBq);//版权
			$(".ba").text(result.getBa);//备案
		}
	});
	$.ajax({
		type:"post",
		url:"getHomeDataList",
		dataType:"json",
		success:function(result){

			//遍历导航栏
				
//				 id		类别id
//				 name	类别名称
//				 
			var navName=result.getNavName;
			console.log(navName);
			$.each(navName,function(index,item){
				if(index<4){
					$(".dh").append("<li><a href='product2.html?id="+item.id+"' class='nav_href'>"+item.type_name+"</li>");
				}
			});	
			var color = $.cookie("color");
			var deepcolor=$.cookie("deepcolor");
			change(color,deepcolor);
		}
	});
	
});
$(function (){
	$.ajax({
		type:"post",
		url:"getgetSecName",
		dataType:"json",
		success:function(result){
		/*	遍历下拉导航栏
			
			 href	店铺淘宝链接
			 name	商家名称
			 * */
			var secName=result.getSecName;
			$.each(secName, function(index,item) {
				if(index<10){
					$(".div_section ul").append("<a href='"+item.p_href+"'><li title='"+item.p_name+"'>"+item.p_name+"</li></a>")
				}
			});
			var color = $.cookie("color");
			var deepcolor=$.cookie("deepcolor");
			change(color,deepcolor);
		}
	});
	$.ajax({
		type:"post",
		url:"getgetBanner",
		data:{},
		dataType:"json",
		success:function(result){
			/*	
			遍历轮播图
				
				 href		轮播图链接
				 bannerParh	轮播图地址
				 * */
			var banner=result.getBanner;
			$.each(banner, function(index,item) {
				//最多显示五张轮播图,第一张不隐藏
				 if(index<5){
					$(".div_banner").append("<a href='"+item.b_path+"'><img src='"+item.b_img+"' style='position: absolute;'/></a>");
					$(".point ul").append("<li></li>");
				}
				
		});
			var color = $.cookie("color");
			var deepcolor=$.cookie("deepcolor");
			change(color,deepcolor);
		}
	});
	
	$.ajax({
		type:"post",
		url:"getgetNavType",
		data:{},
		dataType:"json",
		success:function(result){
			/*
			遍历商家和类别
				
				 index	下标
				 typeName	类别名称
				 product	商家集合名称
				 product.href  商家链接
				 product.name	商家名称
				 * */
				//获取类别，类别中有商家的集合
			var navType=result.getNavType;
			
			$.each(navType, function(index,item) {
				var	a=index;
				a++;
				//第一行间距
				if(index==0){
					$(".nav_each").append("<div class='nav_type' style='margin-top: 270px;'><span class='floor'>"+a+"F</span><span class='type_name' data-id='"+item.id+"'>"+item.type_name+"</span><a href='product2.html?id="+item.id+"'><span class='gd'>查看更多</span></a></div><div class='product'><ul></ul></div>");
					
				}else{
					$(".nav_each").append("<div class='nav_type'><span class='floor'>"+a+"F</span><span class='type_name'  data-id='"+item.id+"'>"+item.type_name+"</span><a href='product2.html?id="+item.id+"'><span class='gd'>查看更多</span></a></div><div class='product'><ul></ul></div>");
				}
			});
			var color = $.cookie("color");
			var deepcolor=$.cookie("deepcolor");
			change(color,deepcolor);
			/*
			 * 获取类别栏id，根据id查询后台商家数据
			 */
			$(".type_name").each(function(){
				var ul=$(this).parent().next().children();
				var id=$(this).attr("data-id");
				$.ajax({
					type:"post",
					
					url:"getStoreByTypeID",
					data:{"id":id},
					dataType:"json",
					success:function(result){
						var store=result.getstore;
						$.each(store,function(index,item){
							ul.append(" <a href='"+item.p_href+"'><li title='"+item.p_name+"'>"+item.p_name+"</li></a> ");
						})
					}
				})
			});
			var color = $.cookie("color");
			var deepcolor=$.cookie("deepcolor");
			change(color,deepcolor);
		}
	});
	$.ajax({
		type:"post",
		url:"getgetNews",
		data:{},
		dataType:"json",
		success:function(result){
			/*	最新入驻商家设置
			
			 name	最新入驻商家名称
			 * */
		var news=result.getNews;
		$.each(news, function(index,item) {
			$(".mar").append("<li title='"+item.p_name+"'>"+item.p_name+"</li>");
		});
		}
	});
	$.ajax({
		type:"post",
		url:"getgetRecom",
		data:{},
		dataType:"json",
		success:function(result){
			/*推荐商家设置
			
			 name	推荐商家名称
			 * */
		var recom=result.getRecom;
		$.each(recom, function(index,item) {
			$(".product_footer ul").append("<a href='"+item.p_href+"'><li title='"+item.p_name+"'>"+item.p_name+"</li></a>");
		});
		var color = $.cookie("color");
		var deepcolor=$.cookie("deepcolor");
		change(color,deepcolor);
		}
	});
	$.ajax({
		type:"post",
		url:"getgetSM",
		data:{},
		dataType:"json",
		success:function(result){
			//遍历声明
			/*	
				 SmName 声明名称
				 * */
		var smlist=result.getSM;
		$.each(smlist, function(index,item) {
			$(".sm").append("<a class='sm_a' href='statement.html?id="+item.statementId+"'><span>《"+item.statementName+"》</span></a>");
		});	
		}
	});
	$.ajax({
		type:"post",
		url:"advertisingList",
		data:{},
		dataType:"json",
		success:function(result){
			/*广告设置
			*/
			if(result.getgg.length>1){
				$(".poster3").append("<a href="+result.getgg[0].advertisingUrl+"><img alt="+result.getgg[0].advertisingName+" src="+result.getgg[0].imgUrl+" height='100%' width='100%'></a>");
				$(".poster2").append("<a href="+result.getgg[1].advertisingUrl+"><img alt="+result.getgg[1].advertisingName+" src="+result.getgg[1].imgUrl+" height='100%' width='100%'></a>");
			}else{
				$(".poster3").append("<a href="+result.getgg[0].advertisingUrl+"><img alt="+result.getgg[0].advertisingName+" src="+result.getgg[0].imgUrl+" height='100%' width='100%'></a>");
			}
			
		}
	});
	$.ajax({
		type:"post",
		url:"getgetVideo",
		data:{},
		dataType:"json",
		success:function(result){
			/*
			遍历视频
				
				 href	店铺淘宝链接
				 videoPath	视频地址	
				 poster 	图片地址
				 * */
			var video=result.getVideo;
			$.each(video, function(index,item) {
				$("#Marquee_x ul li").append("<div><a href='"+item.v_path+"'><video muted src='"+item.v_vedio+"'  poster='"+item.v_img+"' width='100%' height='100%' controls='controls'></video></a></div>");
				$("#Marquee_x ul li div").css("margin-left","20px")
			});
		}
	});
})
