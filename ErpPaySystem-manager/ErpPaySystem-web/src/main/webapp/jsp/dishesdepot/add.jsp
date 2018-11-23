<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ctx}/resource/layui/css/layui.css" media="all">
<script type="text/javascript" src="${ctx}/resource/layui/layui.js"></script>
<script type="text/javascript" src="${ctx}/resource/js/jquery.min.js"></script>
</head>
<body>
	<div style="text-align: center; width: 70%" >
		<input type="text" id="dishesdepotname" required  placeholder="请输入菜品库名" autocomplete="off" class="layui-input"> 
	</div>
	 <div>
	 	<button class="layui-btn" onclick="add()">立即提交</button>
        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
	 </div>
</body>
<script type="text/javascript">
 var layer
layui.use('layer', function(){
	  layer = layui.layer;
	  
	});              
	function add(){
		$.post('${ctx}/dishesdepot/add',{dishesdepotname:$("#dishesdepotname").val()},function(data){
			if(!data.success){
				layer.alert(data.resultdesc);
				return;
			}
			layer.msg(data.resultdesc,{shift: -1 ,time: 2000},function(){
				parent.location.reload();
			});
		},'json')
	}
</script>
</html>