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
	<table id="demo" lay-filter="test"></table>
</body>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
  </div>
</script>
<script type="text/javascript">
	var tableIns;
	layui.use('table', function(){
	    var table = layui.table;	  
	    tableIns = table.render({
	    elem: '#demo'
	    ,skin: 'row' //行边框风格
	    ,even: true //开启隔行背景
	    ,url: '${ctx}/dishesdepot/list' //数据接口
	    ,page: true //开启分页
	    ,request: {
	        pageName: 'currPage' //页码的参数名称，默认：page
	        ,limitName: 'pageSize' //每页数据量的参数名，默认：limit
	      }
	    ,toolbar:'#toolbarDemo'
	    ,defaultToolbar:['exports','print']
	    ,cols: [[ //表头
	      {field: 'dishesdepotid', title: 'dishesdepotid', sort: true ,hide:true}
	      ,{field: 'dishesdepotname', title: '菜品库',align : 'center'}
	      ,{field: 'orgname', title: '所属机构', sort: true,align : 'center'}
	      ,{field: 'username', title: '创建人',align : 'center'}
	      ,{field: 'createtime', title: '创建时间',align : 'center'}
	      ,{fixed: 'right', title : '操作', align:'center',templet:function(d){
	    	  var str = '<a class="layui-btn layui-btn-xs" href="${ctx}/jsp/dishes/list.jsp?dishesdepotid='+d.dishesdepotid+'">菜品管理</a> '
	    	  if(d.state==0){
	    		  str+='<a class="layui-btn layui-btn-xs" id="'+d.dishesdepotid+'" onclick="changestate(\''+d.dishesdepotid+'\',\'1\')">停用</a>';
	    	  }else if(d.state==1){
	    		  str+='<a class="layui-btn layui-btn-xs" id="'+d.dishesdepotid+'" onclick="changestate(\''+d.dishesdepotid+'\',\'0\')">启用</a>';
	    	  }
	    	  return str;
	      }}
	    ]]
	  });
	  table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
		  var data = obj.data; //获得当前行数据
		  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
		  var tr = obj.tr; //获得当前行 tr 的DOM对象
		  if(layEvent === 'detail'){ //查看
		    //do somehing
		    alert('查看功能当前id是'+data.dishesdepotid)
		  } else if(layEvent === 'del'){ //删除
		    layer.confirm('真的删除行么', function(index){
		      obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
		      layer.close(index);
		      //向服务端发送删除指令
		      alert('删除功能当前id是'+data.dishesdepotid)
		    });
		  } else if(layEvent === 'edit'){ //编辑
		    //do something
		    alert('更新功能当前id是'+data.dishesdepotid)
		    //同步更新缓存对应的值
		    obj.update({
		      username: '123'
		      ,title: 'xxx'
		    });
		  }
		});
	  
	  table.on('toolbar(test)', function(obj){
		  var checkStatus = table.checkStatus(obj.config.id);
		  switch(obj.event){
		    case 'add':
		      layer.open({
		    		  title: '添加菜品库'
		    		  ,type: 2
		    		  ,content: '${ctx}/jsp/dishesdepot/add.jsp'
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