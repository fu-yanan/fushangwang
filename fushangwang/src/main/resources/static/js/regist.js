$(document).ready(function(){
	var flag1=true;
	var flag2=true;
	var flag3=true;
	var flag4=true;
	var flag5=false;
	var flag6=false;
	$(".form_input input").eq(0).change(function(){
		var reg=/[\u4e00-\u9fa5]/;
		var val=$(this).val();
	
			if(!reg.test(val)){
				alert("请正确填写真实姓名");
				flag1=false;
			}else{
				flag1=true;
			}
		
	});
	$(".form_input input").eq(1).change(function(){
		var reg=/^1(3|4|5|6|7|8|9)\d{9}$/;
		var val=$(this).val();
		
			if(!reg.test(val)){
				alert("请正确填写手机号码");
				flag2=false;
			}else{
				flag2=true;
			}
		
	});
	$(".form_input input").eq(2).change(function(){
		var reg=/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
		var val=$(this).val();
		
			if(!reg.test(val)){
				alert("请正确填写身份证号码");
				flag3=false;
			}else{
				flag3=true;
			}
		
	});
	$(".form_input select").change(function(){
		if($(this).val()=="请选择"){
			alert("请选择省市区");
			flag4=false;
		}else{
			flag4=true;
		}
	});
	$(".form1").submit(function(){
		var flag=true;
		/*获取所有表单的值*/
		$(".form_input input").each(function(){
			console.log(1)
			if($(this).val()==null||$(this).val()==""){
				alert($(this).attr("placeholder")+"不能为空");
				flag=false;
			}else{
				/*获取所有选择框的值*/
				$(".form_input select").each(function(){
					if($(this).val()=="请选择"||$(this).val()==""){
						alert("省市区不能为空");
						flag=false;
						return false;
					}
				});
			}
		});
		
		if(flag1&&flag2&&flag3&&flag4){
			/*认证成功*/
			alert("您的信息提交成功，请等待管理员审核，预计审核3-7个工作日。")
		}else{
			alert("信息填写有误，请检查后再提交");
			flag=false;
		}
		return flag;
	});
	/*文件表单验证*/
	$(".form2").submit(function(){
		var file1;
		var file2;
		file1=$(".form2 input").eq(0).val();
		file2=$(".form2 input").eq(1).val();
		if(file1==""&&file2==""){
			alert("至少上传一项");
			return false;
		}
		
	})
	
});
