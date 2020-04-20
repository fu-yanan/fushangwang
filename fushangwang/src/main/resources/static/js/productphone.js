$(document).ready(function() {
			/*手机端登录初始化*/
			if(/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
				$(".body_search").css("margin-left", "20px");
				$(".div_logo ").css({
					"width": "70px",
					"height": '60px',
					"margin-top": "40px",
					"margin-left": '0px'
				});
				$(".phone").css("margin-left", "30px");

				$(".productsingle").css("margin-left", "20px");
				$(".productsingle").css("width", "230px");
				$(".productsingle ul li img").css({
					"width": "200px",
					"height": "200px"
				});
				$(".productsingle ul li").css("width", "200px");
				$(".productsingle ul li img").prev().attr("style", "height: 200px;");
			}
		});