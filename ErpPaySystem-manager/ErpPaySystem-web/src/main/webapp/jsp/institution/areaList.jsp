
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<!-- 引入layui css js -->
<link rel="stylesheet" href="${ctx}/resource/layui/css/layui.css" media="all">
<script type="text/javascript" src="${ctx}/resource/layui/layui.js"></script>
<script type="text/javascript" src="${ctx}/resource/js/jquery.min.js"></script>
<script type="text/html" id="barDemo">
  
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/common.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/main.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/pick-pcc.min.1.0.1.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/colResizable-1.3.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/common.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/pick-pcc.min.1.0.1.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/js/pick-pcc.1.0.2.js"></script>
<script type="text/javascript">
	$(function() {
		$(".list_table").colResizable({
			liveDrag : true,
			gripInnerHtml : "<div class='grip'></div>",
			draggingClass : "dragging",
			minWidth : 30
		});

	});

	function deleteBrand(brandid) {
		var flag = window.confirm("确定要删除此机构信息？");
		if (flag) {
			window.location.href = "deleteBrand?brandid=" + id;
		}
	}
</script>
<title>区域管理</title>
</head>
<body>
	<div class="container">

		<div id="search_bar" class="mt10">
			<form id="pageForm" action="pageFindBrand" method="post">
				<input type="hidden" name="currPage" id="currPage" /> <input
					type="hidden" name="pageSize" id="pageSize" />

				<div class="box">
					<div class="box_border">
						<div class="box_top">
							<b class="pl15">品牌管理</b>
						</div>
						<div class="box_center pt10 pb10">
							<table class="form_table" border="0" cellpadding="0"
								cellspacing="0">
								<tr>

									<td>品牌名称</td>
									<td>
										<select name="brandname" lay-verify="" lay-search>
									      <option value="">==请选择==</option>
										  <option value="1">安少爷米线</option>
										</select>     
										
										
									</td>

									<td>区域名称</td>
									<td><input type="text" name="areaname"
										value="${areaVo.areaname }" class="input-text lh25" size="30"></td>
									<td>
										<!-- <button class="layui-btn" lay-submit lay-filter="formDemo" onclick="search()">搜索</button> -->
										<!-- <a class="layui-btn" onclick="search()">搜索</a> --> <!-- <input class="layui-btn" onclick="search()"> -->
										<a href="javascript:void(0)" class="layui-btn" id="search">搜索</a>
										<button type="reset" class="layui-btn layui-btn-primary">重置</button>
									</td>
								</tr>
								<tr>
									<td>
										<button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</form>
		</div>
		<div id="table" class="mt10">
			<div class="box span10 oh">
				<table id="demo" lay-filter="test"></table>
				<div id="page" class="page mt10" style="text-align: center;"></div>
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
	var tableIns;
	layui.use('table', function() {
		var table = layui.table;
		//第一个实例
		tableIns = table.render({
			elem : '#demo',
			skin : 'row', //行边框风格
			even : true, //开启隔行背景
			url : '${ctx}/institution/pageFindBrand', //数据接口
			page : true, //开启分页
			request : {
				pageName : 'currPage', //页码的参数名称，默认：page
				limitName : 'pageSize' //每页数据量的参数名，默认：limit
			},
			toolbar : '#toolbarDemo',
			defaultToolbar : [ 'exports', 'print' ],
			cols : [ [ //表头
				{
					field : 'areaid',
					title : 'areaid',
					hide : true
				}
				, {
					field : 'areaname',
					title : '区域名称',
					align : 'center'
				}
				, {
					field : 'brandname',
					title : '所属品牌',
					align : 'center'
				}
				, {
					field : 'industryname',
					title : '业态',
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
			} else if (layEvent === 'del') { //删除
				layer.confirm('真的删除行么', function(index) {
					obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
					layer.close(index);
					//向服务端发送删除指令
					alert('删除功能当前id是' + data.brandid)
					$.post('${ctx}/institution/deleteBrand', {
						brandid : data.brandid
					}, function(data) {
						layer.msg("删除成功！！");
					})
				});
			} else if (layEvent === 'edit') { //编辑
				//do something
				alert('更新功能当前id是' + data.brandid)
				//同步更新缓存对应的值
				obj.update({
					username : '123',
					title : 'xxx'
				});
			}
		});
		table.on('toolbar(test)', function(obj) {
			var checkStatus = table.checkStatus(obj.config.id);
			switch (obj.event) {
			case 'add':
				layer.msg('添加');
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
