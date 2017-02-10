$(document).ready(function(){
	
	var path = $("#path").val();
	
	//点击绑定按钮
	$(".login").click(function(){
		var weixin = $("#weixin").val();
		var phone = $(".text").val();
		if(isphone(phone)){
			$.ajax({
				url:path+"/bindingController/binding"
			});
		}else{
			layer.open({
				content:"手机号码有误",
				btn:"确定"
			});
		}
	});
	
	//判断是否是手机号码
	function isphone(inputString){
         var partten = /^1[3,5,8,7]\d{9}$/;
         var fl=false;
         if(partten.test(inputString)){
              return true;
         }else{
              return false;
         }
    }
	
});