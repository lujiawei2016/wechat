$(document).ready(function(){
	var path = $("#path").val();
	
	//点击导入成绩
	$("#batchAdd").click(function(){
		$("#batchModal").modal("show");
	});
	
	$(".selectExcel").hide();
	$(".selectImg").click(function(){
		$("#file").click();
	});
	
	//选择文件的时候
	$("#file").change(function(){
		selectFile();
	});
	
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
    
    //点击确定按钮
    $("#batchBtn").click(function(){
    	if(checkData()){
    		var title = $("#title").val();
    		if(title == "" || title == null){
    			layer.alert("标题不能为空",{
    				icon:2
    			});
    		}else{
    			$("#uploadFrom").ajaxSubmit({
                    url:path+"/scoreController/importScore",  
                    dataType: "json",
                    data:{"title":title},
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
        }
    });
    
    //点击删除
    $(".delete").click(function(){
    	var title = $(this).parent().siblings(".titleTd").html();
    	layer.confirm("确定删除"+title+"的成绩吗？",{
    		icon:0,
    		title:"警告!",
    		btn:["确定","取消"]
    	},function(){
    		$.ajax({
    			url:path+"/scoreController/deleteByTitle",
    			data:{"title":title},
    			dataType:"json",
    			type:"post",
    			beforeSend:function(){
    				layer.load(1);
    			},
    			success:function(result){
    				layer.closeAll();
    				layer.alert("删除成功",{
    					icon:1
    				});
    				setTimeout(function(){
    					location.reload();
    				},2000);
    			},
    			error:function(){
    				layer.closeAll();
    				layer.alert("删除失败",{
    					icon:2
    				});
    			}
    		});
    	});
    });
});