$(document).ready(function(){
	
	var path = $("#path").val();
	
	//点击绑定按钮
	$(".login").click(function(){
		var weixin = $("#weixin").val();
		var phone = $(".text").val();
		if(isphone(phone)){
			$.ajax({
				url:path+"/bindingController/binding",
				data:{"weixin":weixin,"phone":phone},
				dataType:"json",
				type:"post",
				beforeSend:function(){
					layer.open({
					    type: 2,
					    content: "正在验证...",
					    shadeClose:false
					});
				},
				success:function(result){
					layer.closeAll();
					if("1" == result){
						layer.open({
							content:"微信号不合法",
							btn:"我知道了"
						});
					}else if("2" == result){
						layer.open({
							content:"电话号码不合法",
							btn:"我知道了"
						});
					}else if("3" == result){
						layer.open({
							content:"手机号码不存在，请与老师联系",
							btn:"我知道了"
						});
					}else if("4" == result){
						layer.open({
							content:"该学生已经被绑定",
							btn:"我知道了"
						});
					}else{
						layer.open({
							content:"确定要绑定"+result.name+"的信息吗？",
							btn:["确定","取消"],
							yes:function(index){
								layer.close(index);
								$.ajax({
									url:path+"/bindingController/bindStudent",
									data:{"weixin":weixin,"phone":phone},
									dataType:"json",
									type:"post",
									beforeSend:function(){
										layer.open({
										    type: 2,
										    content: "正在绑定....",
										    shadeClose:false
										});
									},
									success:function(result){
										if("4" == result){
											layer.open({
												content:"绑定成功，正在跳转...."
											});
										}
									}
								});
							}
						});
					}
				},
				error:function(result){
					layer.closeAll();
					layer.open({
						content: "系统繁忙，请稍后重试",
						btn: "我知道了"
					});
				}
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