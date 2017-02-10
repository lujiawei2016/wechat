$(document).ready(function(){
	
	var path = $("#path").val();
	
	//点击批量添加按钮
	$("#batchAdd").click(function(){
		$("#batchModal").modal("show");
	});
	
	//点击批量添加按钮确定
	$("#batchBtn").click(function(){
		if(checkData()){  
            $("#uploadFrom").ajaxSubmit({    
                url:path+"/studentController/importStudent",  
                dataType: "json",  
                success: resutlMsg,  
                error: errorMsg  
            });   
            function resutlMsg(msg){  
            	layer.alert("导入成功",{
            		icon:1
            	});  
            }  
            function errorMsg(){   
            	layer.alert("导入成功",{
            		icon:1
            	});
            }  
        }  
	});
	
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
});