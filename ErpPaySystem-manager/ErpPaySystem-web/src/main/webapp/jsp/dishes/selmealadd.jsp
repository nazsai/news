<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</html>