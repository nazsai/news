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
 <form class="layui-form" action="" style="width: 60%">
  <div class="layui-form-item">
    <label class="layui-form-label"> 套餐名</label>
    <div class="layui-input-block">
      <input type="text" name="title" required  lay-verify="required" placeholder="请输入套餐名" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label"> 套餐类型</label>
    <div class="layui-input-block">
      <input type="radio" name="sex" value="0" title="简易套餐" checked>
      <input type="radio" name="sex" value="1" title="多选套餐">
      <input type="radio" name="sex" value="2" title="组合套餐">
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
</body>
<script>
//Demo
layui.use('form', function(){
  var form = layui.form;
  
  //监听提交
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
});
</script>
</html>