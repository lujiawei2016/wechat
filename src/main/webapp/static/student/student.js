$(document).ready(function(){
	
	var path = $("#path").val();
	
	//点击批量添加按钮
	$("#batchAdd").click(function(){
		$("#batchModal").modal("show");
	});
	
	//点击单击添加按钮
	$("#singleAdd").click(function(){
		$("#singleModal").modal("show");
	});
	
	//点击批量添加按钮确定
	$("#batchBtn").click(function(){
		if(checkData()){  
            $("#uploadFrom").ajaxSubmit({    
                url:path+"/studentController/importStudent",  
                dataType: "json",
                success: function(msg){  
                	layer.alert("导入成功",{
                		icon:1
                	});  
                },  
                error: function(){
                	$("#batchModal").modal("hide");
                	layer.alert("导入成功",{
                		icon:1
                	});
                	setTimeout(function(){
                		location.reload();
                	},2000);
                }
            });   
        }  
	});
	
	//点击单独添加确定按钮
	$("#singleBtn").click(function(){
		var studentId = $("#studentId").val();
		var name = $("#name").val();
		var phone = $("#phone").val();
		if(studentId == "" || studentId == null){
			layer.alert("学生id不能为空",{
				icon:2
			});
			return;
		}
		if(name == "" || name == null){
			layer.alert("学生名字不能为空",{
				icon:2
			});
			return;
		}
		if(phone == "" || phone == null){
			layer.alert("家长电话不能为空",{
				icon:2
			});
			return;
		}
		
		$.ajax({
			url:path+"/studentController/saveStudent",
			data:{"studentId":studentId,"name":name,"phone":phone},
			dataType:"json",
			type:"post",
			beforeSend:function(){
				$("#singleModal").modal("hide");
				layer.load(1);
			},
			success:function(result){
				layer.closeAll();
				if("1" == result){
					layer.alert("保存成功",{
						icon:1
					});
				}else{
					layer.alert("保存失败",{
						icon:2
					});
				}
			},
			error:function(){
				layer.alert("保存失败",{
					icon:2
				});
			}
		});
	});
	
	//点击选择excel
	$(".selectImg").click(function(){
		return $("#file").click();
	});
	
	//选择文件的时候
	$("#file").change(function(){
		selectFile();
	});
	
	//选择excel
	$(".selectExcel").hide();
	function selectFile(){
		if(checkData()){
			var fileName = $("#file").val();
			$(".fileName").html(fileName);
			$("#contentDiv").hide();
			$(".selectExcel").show();			
		}
	}
	
	//JS校验form表单信息  
    function checkData(){  
       var fileDir = $("#file").val();  
       var suffix = fileDir.substr(fileDir.lastIndexOf("."));  
       if("" == fileDir){  
           layer.alert("选择需要导入的Excel文件！",{
        	   title:"错误",
        	   icon:2
           });  
           return false;  
       }  
       if(".xls" != suffix && ".xlsx" != suffix ){  
           layer.alert("选择Excel格式的文件导入！",{
        	   title:"错误",
        	   icon:2
           });
           return false;  
       }  
       return true;  
    }
    
    //点击解绑
    $(".unbundling").click(function(){
    	var studentId = $(this).parent().siblings(".studentIdTd").html();
    	layer.confirm("确定解绑？",{
    		icon:0,
    		btn:["确定","取消"]
    	},function(){
    		$.ajax({
        		url:path+"/studentController/unbundling",
        		data:{"studentId":studentId},
        		dataType:"json",
        		type:"post",
        		beforeSend:function(){
        			layer.load(1);
        		},
        		success:function(result){
        			layer.closeAll();
        			if("2" == result){
        				layer.alert("解绑成功",{
        					icon:1
        				});
        				setTimeout(function(){
        					location.reload();
        				},2000);
        			}else{
        				layer.alert("解绑失败",{
        					icon:2
        				});
        			}
        		},
        		error:function(){
        			layer.alert("解绑异常，请与管理员联系",{
    					icon:2
    				});
        		}
        	});
    	});
    });
    
    //点击删除按钮
    $(".delete").click(function(){
    	var studentId = $(this).parent().siblings(".studentIdTd").html();
    	layer.confirm("确定删除？",{
    		icon:0,
    		btn:["确定","取消"]
    	},function(){
    		$.ajax({
        		url:path+"/studentController/deleteStudent",
        		data:{"studentId":studentId},
        		dataType:"json",
        		type:"post",
        		beforeSend:function(){
        			layer.load(1);
        		},
        		success:function(result){
        			layer.closeAll();
        			if("2" == result){
        				layer.alert("删除成功",{
        					icon:1
        				});
        				setTimeout(function(){
        					location.reload();
        				},2000);
        			}else{
        				layer.alert("删除失败",{
        					icon:2
        				});
        			}
        		},
        		error:function(){
        			layer.alert("删除异常，请与管理员联系",{
    					icon:2
    				});
        		}
        	});
    	});
    });
});