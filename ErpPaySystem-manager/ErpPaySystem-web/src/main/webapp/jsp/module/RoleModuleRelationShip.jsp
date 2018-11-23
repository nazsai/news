<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'moduleManage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="<%=basePath%>resource/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
	
	<script type="text/javascript" src="<%=basePath%>resource/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>resource/ztree/js/jquery.ztree.core.js"></script>
	<script type="text/javascript" src="<%=basePath%>resource/ztree/js/jquery.ztree.excheck.js"></script>
	
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
	<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
		
		$(function() {
			var setting = {
					check: {
						enable: true,
						chkStyle: "checkbox",
						chkboxType: { "Y": "ps", "N": "ps" }
					},
					data: {
						simpleData: {
							enable: true
						}
					}
				};
			
			$.ajax({
				url: "getModuleList",
				dataType: "json",
				success : function(data) {
					$.fn.zTree.init($("#treeDemo"), setting, data).expandAll(true);
				}
			});
			
		});
		
		function submitForm() {
			var ids = '';
			var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
			var nodes = treeObj.getCheckedNodes(true);
			for (var i = 0; i < nodes.length; i++) {
				if(ids == '') {
					ids += nodes[i].id;
				} else {
					ids += ","+nodes[i].id;
				}
		}
			
		if ($("input[name=roleId]:checked").val()==undefined) {
			alert("请选择一个角色！");
			return;
		}
		
		if (ids=='') {
			alert("请选择模块！");
			return;
		}
			$("#roleId").val($("input[name=roleId]:checked").val());
			$("#moduleIds").val(ids);
			$("#addForm").submit();
		}
		
		function showBack() {
			var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
			var nodes = treeObj.getCheckedNodes(true);
			for (var i=0; i<nodes.length; i++) {
				var node = nodes[i];
				node.checked = false;
				treeObj.updateNode(node);
			}
			
			var roleId = $("input[name=roleId]:checked").val();
			$.ajax({
				data:{roleId:roleId},
				url: "ajaxGetModuleIdsByRoleId",
				dataType: "json",
				success: function(data) {
					for(var i=0; i<data.length; i++) {
						var moduleId = data[i];
						var node = treeObj.getNodeByParam("id", moduleId, null);
						node.checked = true;
						treeObj.updateNode(node);
					}
				}
			});
		}
		
	</script>
  </head>
  
      <div class="container">
				<div class="row">
				 	  <div class="col-md-4">
					  		<div class="page-header">
					  			 <h3>系统角色</h3>
					  		</div>
					  		<div class="table-responsive">
					  			<table class="table table-bordered table-striped">
					  				<thead>
					  					<tr>
									 		<td>#</td>
									 		<td>职务</td>
								 		</tr>
					  				</thead>
								 	<tbody>
								 		<c:forEach items="${roleList}" var="role">
									 		<tr>
										 		<td><input type="radio" name="roleId" value="${role.roleId}" onclick="showBack()"></td>
										 		<td>${role.roleName}</td>
										 	</tr>
								 		</c:forEach>
								 	</tbody>
								</table>
					  		</div>
					  </div>
					  <div class="col-md-8">
						  <div class="page-header">
						  		<h3>当前菜单目录</h3>
						  </div>
					  	  <ul id="treeDemo" class="ztree"></ul>
					  </div>
				</div>
				<div class="row">
					<div class="form-group">
						    <div class="col-sm-offset-4 col-sm-10">
						      <button type="button" onclick="submitForm()" class="btn btn-default">保存</button>
						    </div>
				   </div>
				</div>
				<form id="addForm" action="addRoleModuleRelation" role="form" method="post">
					<input type="hidden" id="roleId" name="roleId">
					<input type="hidden" id="moduleIds" name="moduleIds">
				</form>
	 </div>
</html>
