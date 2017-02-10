$(document).ready(function(){
	
	var path = $("#path").val();
	
	//根据窗口宽度生成图片宽度
	var width = $(window).width();
	$(".screenbg ul img").css("width",width+"px");
	
	$(document).keypress(function(e) {
		//回车
		if(e.which == 13) {
			login();
		} 
	});
	
	$(".loginBtn").click(function(){
		login();
	});
	
	//登录
	function login(){
		var username = $("#username").val();
		var password = $("#password").val();
		$.ajax({
			url:path+"/userController/login",
			data:{"username":username,"password":password},
			dataType:"json",
			type:"post",
			beforeSend:function(){
				layer.load(1);
			},
			success:function(result){
				layer.closeAll();
				if("1" == result){
					layer.alert("登录成功，正在跳转....",{
						icon: 1
					});
					window.location.href=path+"/studentController/listStudent";
				}else{
					layer.alert("账号或密码错误",{
						title:"警告 !",
						icon: 2
					});
				}
			}
		});
	}
});