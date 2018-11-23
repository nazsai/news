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
	<ul class="layui-nav" lay-filter="" id="dishestype">
	</ul>
	<table id="demo" lay-filter="test"></table>
</body>
<script type="text/javascript">
	var dishesdepotid = ${param.dishesdepotid}
	var url = "${ctx}/selmeal/list?dishesdepotid="+dishesdepotid
	$(function(){
		$.post('${ctx}/dishestype/select',function(data){
			if(null == data){
				return;
			}
			var str;
			$.each(data,function(dishestypeid,dishestypename){
				str+='<li class="layui-nav-item"><a href="" id="'+dishestypeid+'" onclick="changedishestype(\''+dishestypeid+'\')">'+dishestypename+'</a></li>'; 
			})
			$("#dishestype").append(str);
		},'json')
	})
</script>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
  </div>
</script>
<script type="text/javascript">
//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
  //…
});
var tableIns;
layui.use('table', function(){
    var table = layui.table;	  
    tableIns = table.render({
    elem: '#demo'
    ,height: 500
    ,skin: 'row' //行边框风格
    ,even: true //开启隔行背景
    ,url: url //数据接口
    ,page: true //开启分页
    ,request: {
        pageName: 'currPage' //页码的参数名称，默认：page
        ,limitName: 'pageSize' //每页数据量的参数名，默认：limit
      }
    ,toolbar:'#toolbarDemo'
    ,defaultToolbar:['exports','print']
    ,cols: [[ //表头
      {field: 'mealid', title: 'mealid', hide:true}
      ,{field: 'mealname', title: '套餐名',align : 'center'}
      ,{field: 'mealtype', title: '套餐类型', sort: true,align : 'center'}
      ,{field: 'alldishesname', title: '菜品明细',align : 'center'}
      ,{field: 'oriprice', title: '原价',align : 'center'}
      ,{field: 'price', title: '套餐价',align : 'center'}
      ,{field: 'memberprice', title: '会员价',align : 'center'}
      ,{field: 'state', title: '启用',align : 'center'}
    ]]
  });
    table.on('toolbar(test)', function(obj){
		  var checkStatus = table.checkStatus(obj.config.id);
		  switch(obj.event){
		    case 'add':
		      layer.open({
		    		  title: '添加套餐'
		    		  ,type: 2
		    		  ,content: '${ctx}/jsp/dishes/selmealadd.jsp'
		    		  ,skin: 'layui-layer-molv'
		    		  ,area: ['1000px', '500px']
		    		}); 
		    break;
		    /* case 'delete':
		      layer.msg('删除');
		    break;
		    case 'update':
		      layer.msg('编辑');
		    break; */
		  };
		});
});
</script>
</html>