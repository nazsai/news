
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<!-- 引入layui css js -->
<link rel="stylesheet" href="${ctx}/resource/layui/css/layui.css"
	media="all">
<script type="text/javascript" src="${ctx}/resource/layui/layui.js"></script>
<script type="text/javascript" src="${ctx}/resource/js/jquery.min.js"></script>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
</script>
<script type="text/html" id="toolbarDemo">
	<a class="layui-btn layui-btn-xs" lay-event="add">添加</a>
</script>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/common.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/main.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/colResizable-1.3.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/common.js"></script>

<script type="text/javascript">
	$(function() {
		$(".list_table").colResizable({
			liveDrag : true,
			gripInnerHtml : "<div class='grip'></div>",
			draggingClass : "dragging",
			minWidth : 30
		});

	});
</script>
<title>品牌管理</title>
</head>
<body>

	<ul class="layui-nav" lay-filter="">
  	<li class="layui-nav-item"><a href="">品牌管理</a></li>
  	<li class="layui-nav-item"><a href="${ctx}/jsp/institution/areaList.jsp">区域管理</a></li>
  	<li class="layui-nav-item"><a href="${ctx}/jsp/institution/shopList.jsp">门店管理</a></li>
  	<li class="layui-nav-item layui-this"><a href="${ctx}/jsp/institution/shopmoudleList.jsp">权限模版</a></li>
	<div class="container">
		<div id="search_bar" class="mt10">
			<form id="pageForm" action="pageFindBrand" method="post">
				<input type="hidden" name="currPage" id="currPage" /> 
				<input type="hidden" name="pageSize" id="pageSize" />
			</form>
		</div>
		<div id="table" class="mt10">
			<div class="box span10 oh">
				<table id="demo" lay-filter="test"></table>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">

	var param = {};
	$("#search").click(function() {
		var brandname = $("#brandname").val();
		param = {
			brandname : brandname
		}
		tableIns.reload({
			where : param,
			page : {
				curr : 1 //重新从第 1 页开始
			}
		});
	});
</script>
<script type="text/javascript">
//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
  //…
});
	var tableIns;
	layui.use('table', function() {
		var table = layui.table;
		//第一个实例
		tableIns = table.render({
			elem : '#demo',
			skin : 'row', //行边框风格
			even : true, //开启隔行背景
			url : '${ctx}/institution/shopmoudleList', //数据接口
			page : true, //开启分页
			request : {
				pageName : 'currPage', //页码的参数名称，默认：page
				limitName : 'pageSize' //每页数据量的参数名，默认：limit
			},
			toolbar : '#toolbarDemo',
			defaultToolbar : [ 'exports', 'print' ],
			cols : [ [ //表头
				{
					field : 'brandid',
					title : 'brandid',
					hide : true
				}
				, {
					field : 'shopmoudlename',
					title : '模版名称',
					align : 'center'
				}
				, {
					field : 'shopname',
					title : '已关联门店',
					align : 'center'
				}
				, {
					field : 'username',
					title : '操作人',
					align : 'center'
				}
				, {
					field : 'createtime',
					title : '创建时间',
					align : 'center'
				}
				, {
					fixed : 'right',
					title : '操作',
					align : 'center',
					toolbar : '#barDemo'
				}
			] ]
		});
		table.on('tool(test)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
			var data = obj.data; //获得当前行数据
			var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
			var tr = obj.tr; //获得当前行 tr 的DOM对象


			if (layEvent === 'detail') { //查看
				//do somehing
				//alert('查看功能当前id是'+data.dishesdepotid)
			}else if (layEvent === 'edit') { //编辑
				//do something
				// alert('更新功能当前id是'+data.brandid)
				//同步更新缓存对应的值
				layer.open({
					title : '编辑品牌',
					closeBtn : 2,
					type : 2,
					content : '${ctx}/jsp/institution/brandUpdate.jsp',
					area : [ '1000px', '500px' ]
				});
			}
		});
		table.on('toolbar(test)', function(obj) {
			var checkStatus = table.checkStatus(obj.config.id);
			switch (obj.event) {
			case 'add':
				layer.open({
					title : '添加品牌',
					closeBtn : 2,
					type : 2,
					content : '${ctx}/jsp/institution/brandAdd.jsp',
					area : [ '1000px', '500px' ]
				});
				break;
			case 'delete':
				layer.msg('删除');
				break;
			case 'update':
				layer.msg('编辑');
				break;
			}
			;
		});
	});
</script>
</html>
