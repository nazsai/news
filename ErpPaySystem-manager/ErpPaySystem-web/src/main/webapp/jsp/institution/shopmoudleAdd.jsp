<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
 <head>
  <title>新增模版</title>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <link>
  <script src="${ctx}/resource/js/jquery-1.9.1.min.js"></script>
  <script type="text/javascript"src="${ctx}/resource/js/jquery.min.js"></script>
  
 </head>
<body>
		<ul id="choose">  
  			 <li><label><input type="checkbox" value="1"> 吃饭</label></li>
  			 <li><label><input type="checkbox" value="2"> 睡觉</label></li>
			 <li><label><input type="checkbox" value="3"> 打豆豆</label></li>
		</ul>
		<input type="checkbox" id="checkboxAll">
		<input type="button" value="全选" class="btn" id="selectAll">  
		<input type="button" value="全不选" class="btn" id="unSelect">  
		<input type="button" value="反选" class="btn" id="reverse">  
		<input type="button" value="获得选中的所有值" class="btn" id="getValue">
</body>

<script type="text/javascript">
	  	$("#checkboxAll").click(function(){  
			if(this.checked){  
			     $("#choose: checkbox").prop("checked", true);  
			}else{ 
			     $("#choose:checkbox").prop("checked", false);
			}   
		});
		$("#selectAll").click(function () {
       		$("#choose:checkbox,#checkoxAll").prop("checked", true); 
   		 });
   		$("#unSelect").click(function () { 
       		$("#choose:checkbox,#checkboxAll").prop("checked", false);  
    	});
    	$("#reverse").click(function () { 
    	$("#choose:checkbox").each(function () {
       	 	$(this).prop("checked", !$(this).prop("checked"));
    	});
			allchk();
		});
    	function allchk(){
			var chknum = $("#choose:checkbox").size();//选项总个数
			var chk = 0;
			$("#choose:checkbox").each(function () {  
		        if($(this).prop("checked")==true){
					chk++;
				}
		    });
			if(chknum==chk){//全选
				$("#checkboxAll").prop("checked",true);
			}else{//不全选
				$("#checkboxAll").prop("checked",false);
			}
		}
		$("#getValue").click(function(){
			var valArr = "";
		        $("#choose :checkbox").each(function () {  
				 if($(this).prop("checked")==true){
					valArr+= $(this).val()+",";//转换为逗号隔开的字符串
				}
			});
			alert(valArr);
		});
		$("#choose:checkbox").click(function(){
    		allchk();
    	});
  </script>
</html>