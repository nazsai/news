 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!doctype html>
 <html lang="zh-CN">
 <head>
   <meta charset="UTF-8">
   <!-- 引入layui css js -->
<link type="text/css" rel="stylesheet" media="all"
	href="<%=request.getContextPath() %>/resource/layui/css/layui.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/resource/layui/layui.js"></script>	
   
   
   <link rel="stylesheet" href="<%=request.getContextPath() %>/resource/css/common.css">
   <link rel="stylesheet" href="<%=request.getContextPath() %>/resource/css/main.css">
   <script type="text/javascript" src="<%=request.getContextPath() %>/resource/js/jquery.min.js"></script>
   <script type="text/javascript" src="<%=request.getContextPath() %>/resource/js/colResizable-1.3.min.js"></script>
   <script type="text/javascript" src="<%=request.getContextPath() %>/resource/js/common.js"></script>
   
   <script type="text/javascript">
      $(function(){  
        $(".list_table").colResizable({
          liveDrag:true,
          gripInnerHtml:"<div class='grip'></div>", 
          draggingClass:"dragging", 
          minWidth:30
        }); 
        
      }); 
      
      function deleteyuanGong(id) {
      	var flag = window.confirm("确定要删除此人员信息？");
      	if(flag) {
      		window.location.href="deleteyuanGong?Id="+id;
      	}
      }
      
      
   </script>
   <title>Document</title>
 </head>
 <body>
  <div class="container">

    <div id="search_bar" class="mt10">
   		 <form id="pageForm" action="pageFindyuanGong" method="post">
   		 	<input type="hidden" name="currPage" id="currPage" />
			<input type="hidden" name="pageSize" id="pageSize" />
   		 
	       <div class="box">
	          <div class="box_border">
	            <div class="box_top"><b class="pl15">搜索</b></div>
	            <div class="box_center pt10 pb10">
	              <table class="form_table" border="0" cellpadding="0" cellspacing="0">
	                <tr>
	                  <td>搜索</td>
	                  <td><input type="text" name="realName" value="${yuanGong.realName }" class="input-text lh25" size="30"></td>
					<td>
					<input type="submit" name="button" class="btn btn82 btn_search" value="查询">  
					<input type="button" name="button" onclick="window.location.href='toAddyuanGongPage'" class="btn btn82 btn_add" value="新增"> 
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
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table" style="text-align: center;">
                <tr>
                   <th></th>
                   <th>员工名称</th>
                   <th>用户名</th>
                   <th>所属机构</th>
                   <th>所属岗位</th>
                   <th>性别</th>
                   <th>电话</th>
                   <th>操作人</th>
                   <th>操作时间</th>
                   <th>人员状态</th>
                   <th>操作</th>
                   
                </tr>
                <c:forEach items="${page.list }" var="yuanGong">
	                <tr class="tr">
	                   <td>${yuanGong.id }</td>
	                   <td>${yuanGong.realName }</td>
	                   <td>${yuanGong.userName }</td>
	                   <td>${yuanGong.organzation }</td>
	                   <td>${yuanGong.post }</td>
	                   <td>${yuanGong.gender }</td>
	                   <td>${yuanGong.phone }</td>
	                   <td>${yuanGong.user }</td>
	                   <td>${yuanGong.userTime }</td>
	                   <td>${yuanGong.status }</td>
	                   <td>
                   		 <input type="button" onclick="window.location.href='toUpdateyuanGongPage/${yuanGong.id }'" value="修改" class="ext_btn ext_btn_submit">
               			 <input type="button" onclick="deleteyuanGong(${yuanGong.id })" class="ext_btn ext_btn_error" value="删除">
	                   </td>
	                 </tr>
                </c:forEach>
              </table>
              <div id="page" class="page mt10" style="text-align: center;"></div>
        </div>
     </div>
   </div> 
 </body>
 <script>
layui.use(['laypage', 'layer'], function(){
  var laypage = layui.laypage
  ,layer = layui.layer;
  
  //完整功能
  laypage.render({
    elem: 'page',				//分页显示的标签
    count: '${page.totalNum}',	//总行数
    limit:'${page.pageSize}',		//一页显示的条数
    curr:'${page.currPage}',		//当前页
    limits:[5,10,15],				//选择显示条数选择下拉框
    layout: ['count', 'prev', 'page', 'next', 'limit', 'skip'],
    jump: function(obj, first){	//点击页码回调函数
    	 //首次不执行
        if(!first){
     	   var curr = obj.curr;		//选择的当前页
    	    var limit = obj.limit;	//选择的一页显示的行数
			$("#currPage").val(curr);
			$("#pageSize").val(limit);
			$("#pageForm").submit();
        }
    }
  });
  
});
</script>
 </html>
  