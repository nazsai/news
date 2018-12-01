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
<link rel="stylesheet" href="${ctx}/resource/css/common.css">
<link rel="stylesheet" href="${ctx}/resource/css/style.css">
<script type="text/javascript" src="${ctx}/resource/layui/layui.js"></script>
<script type="text/javascript" src="${ctx}/resource/js/jquery.min.js"></script>
</head>
<body>
	<ul class="layui-nav" lay-filter="">
  	<li class="layui-nav-item layui-this"><a href="">菜品管理</a></li>
  	<li class="layui-nav-item"><a href="">规格管理</a></li>
  	<li class="layui-nav-item"><a href="">做饭管理</a></li>
  	<li class="layui-nav-item"><a href="">加料管理</a></li>
  	<!-- <li class="layui-nav-item">
    <a href="javascript:;">解决方案</a>
    <dl class="layui-nav-child"> 二级菜单
      <dd><a href="">移动模块</a></dd>
      <dd><a href="">后台模版</a></dd>
      <dd><a href="">电商平台</a></dd>
    </dl>
  	</li> -->
	</ul>
	<ul class="layui-nav" id="dishestype"></ul>
	<div style="width: 100%;height: 100%">
	<iframe id="frame" frameborder="no" scrolling="auto" width="100%" height="100%" allowtransparency="true"></iframe>
	</div>
</body>
<script type="text/javascript">
	var dishesdepotid = ${param.dishesdepotid}
	var url
	$(function(){
		$.post('${ctx}/dishestype/select',function(data){
			var str
			$.each(data,function(key,value){
				str+='<li class="layui-nav-item"><a href="javascript:void(0)" onclick="changetype(this,\''+key+'\')">'+value+'</a></li>'
			})
			$("#dishestype").append(str)
		},'json')
		url = "${ctx}/jsp/dishes/selmeallist.jsp?dishesdepotid="+dishesdepotid
		$("#frame").attr("src",url)
	})
	function changetype(obj,dishestypeid){
		var dishestypename = $(obj).html();
		if(dishestypename=='套餐'){
			url = "${ctx}/jsp/dishes/selmeallist.jsp?dishesdepotid="+dishesdepotid
			$("#frame").attr("src",url)
		}else{
			url = "${ctx}/jsp/dishes/disheslist.jsp?dishesdepotid="+dishesdepotid+"&dishestypeid="+dishestypeid
			$("#frame").attr("src",url)
		}
	}
</script>
<script type="text/javascript">
//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
  //…
});
</script>
</html>