  <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <!doctype html>
 <html lang="zh-CN">
 <head>
   <meta charset="UTF-8">
   
   <link rel="stylesheet" href="<%=request.getContextPath() %>/resource/validform/css/style.css">
   <script type="text/javascript" src="<%=request.getContextPath() %>/resource/validform/js/jquery-1.9.1.min.js"></script>
   <script type="text/javascript" src="<%=request.getContextPath() %>/resource/validform/js/Validform_v5.3.2_min.js"></script>
   
   
   <link rel="stylesheet" href="<%=request.getContextPath() %>/resource/css/common.css">
   <link rel="stylesheet" href="<%=request.getContextPath() %>/resource/css/main.css">
   
   <script type="text/javascript">
      $(function(){
      		$(".jqtransform").Validform({
      			tiptype:3,
      			datatype:{
      				"branchName":function(gets,obj,curform,regxp){
      					//参数gets是获取到的表单元素值，obj为当前表单元素，curform为当前验证的表单，regxp为内置的一些正则表达式的引用;
      					var oldName = '${branchInfo.branchName}';
      					
      					var result = true;
      					
      					if (gets != oldName) {
      						$.ajax({
      							url:"<%=request.getContextPath() %>/checkBranchName",
      							data:{param:gets},
      							async:false,		//false 同步		true 异步
      							type:"post",
      							success: function(data) {
      								if(data != 'y') {
      									result = data;
      								}
      							}
      						});
      					}
      					return result;
      		 
      					//注意return可以返回true 或 false 或 字符串文字，true表示验证通过，返回字符串表示验证失败，字符串作为错误提示显示，返回false则用errmsg或默认的错误提示;
      				}
      			}
      		});
      	
      
      });
      
   </script>
   <title>Document</title>
 </head>
 <body>
  <div class="container">
     <div id="forms" class="mt10">
        <div class="box">
          <div class="box_border">
            <div class="box_top"><b class="pl15">添加机构</b></div>
            <div class="box_center">
              <form action="<%=request.getContextPath() %>/updateBranchInfo"  method="post" class="jqtransform">
              	<input type="hidden" name="branchId" value="${branchInfo.branchId}">
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
                 <tr>
                  <td class="td_right">机构名称：</td>
                  <td class=""> 
                    <input type="text" name="branchName" value="${branchInfo.branchName}" datatype="*1-50,branchName"  class="input-text lh30" size="40">
                  </td>
                </tr>
				 <tr>
                  <td class="td_right">机构简称：</td>
                  <td class=""> 
                    <input type="text" name="branchShortName" value="${branchInfo.branchShortName}" datatype="*1-50" class="input-text lh30" size="40">
                  </td>
                </tr>
                 <tr>
                   <td class="td_right">&nbsp;</td>
                   <td class="">
                     <input type="submit" name="button" class="btn btn82 btn_save2" value="保存"> 
                    <input type="reset" name="button" class="btn btn82 btn_res" value="重置"> 
                   </td>
                 </tr>
               </table>
               </form>
            </div>
          </div>
        </div>
     </div>
   </div> 
 </body>
 </html>
  