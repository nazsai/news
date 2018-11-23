<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
  <link rel="stylesheet" href="<%=basePath%>resource/css/common.css">
  <link rel="stylesheet" href="<%=basePath%>resource/css/style.css">
  <script type="text/javascript" src="<%=basePath%>resource/js/jquery.min.js"></script>
  <script type="text/javascript" src="<%=basePath%>resource/js/jquery.SuperSlide.js"></script>
  
  <link rel="stylesheet" href="<%=basePath%>resource/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
  <script type="text/javascript" src="<%=basePath%>resource/ztree/js/jquery.ztree.core.js"></script>
  <c:set var="ctx" value="${pageContext.request.contextPath}"/>
  <script type="text/javascript">
	  	var setting = {  
			    isSimpleData : true,              //数据是否采用简单 Array 格式，默认false  
			    treeNodeKey : "moduleid",               //在isSimpleData格式下，当前节点id属性  
			    treeNodeParentKey : "parentid",        //在isSimpleData格式下，当前节点的父节点id属性  
			    showLine : true,                  //是否显示节点间的连线  
			    checkable : true,                 //每个节点上是否显示 CheckBox 
			    data:{
			        key:{
			         name:"modulename", //节点显示的值
			         url:"noexist"
			        },
			        //
			        simpleData:{
			         enable:true,//如果为true，可以直接把从数据库中得到的List集合自动转换为Array格式。而不必转换为json传递
			         idKey:"moduleid",//节点的id
			         pIdKey:"parentid",//节点的父节点id
			         rootPId:null
			        }
			       },
			    callback: {
			    	beforeClick : zTreeOnClick
			   	}
			}; 
		var zTree;  
		var treeNodes;
		$(function() {
			$.ajax({  
		        async : false,  
		        cache:false,  
		        type: 'POST',  
		        dataType : "json",  
		        url: "${ctx}/module/findModules",//请求的action路径  
		        error: function () {//请求失败处理函数  
		            alert('请求失败');  
		        },  
		        success:function(data){ //请求成功后处理函数。    
		            //alert(data);  
		            treeNodes = data;   //把后台封装好的简单Json格式赋给treeNodes  
		        }  
		    }); 
			zTree = $.fn.zTree.init($("#tree"), setting, treeNodes);						
		});
		
		function zTreeOnClick(treeId, treeNode, clickFlag){
			$('#rightMain').attr('src',treeNode.url)
		}
  </script>
  <title>首页</title>
</head>
<body>
    <div class="top">
      <div id="top_t">
        <div id="logo" class="fl"></div>
        <div id="photo_info" class="fr">
          <div id="photo" class="fl">
            <a href="#"><img src="images/a.png" alt="" width="60" height="60"></a>
          </div>
          <div id="base_info" class="fr">
            <div class="help_info">
              <a href="1" id="hp">&nbsp;</a>
              <a href="2" id="gy">&nbsp;</a>
              <a href="logout" id="out">&nbsp;</a>
            </div>
            <div class="info_center">
            	admin               
              <span id="nt">通知</span><span><a href="#" id="notice">3</a></span>
            </div>
          </div>
        </div>
      </div>
      <div id="side_here">
        <div id="side_here_l" class="fl"></div>
        <div id="here_area" class="fl">当前位置：<span id="moduelSpan"></span></div>
      </div>
    </div>
    <div class="side">
          <ul id="tree" class="ztree"></ul>
    </div>
    <div class="main">
       <iframe name="right" id="rightMain" src="main.jsp" frameborder="no" scrolling="auto" width="100%" height="auto" allowtransparency="true"></iframe>
    </div>
    <div class="bottom">
      <div id="bottom_bg">版权</div>
    </div>
    <div class="scroll">
          <a href="javascript:;" class="per" title="使用鼠标滚轴滚动侧栏" onclick="menuScroll(1);"></a>
          <a href="javascript:;" class="next" title="使用鼠标滚轴滚动侧栏" onclick="menuScroll(2);"></a>
    </div>
</body>

</html>

 