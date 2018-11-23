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
      			tiptype:3
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
              <form action="addBranchInfo"  method="post" class="jqtransform">
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
                 <tr>
                  <td class="td_right">机构名称：</td>
                  <td class=""> 
                    <input type="text" name="branchName" datatype="*1-50" ajaxurl="checkBranchName" class="input-text lh30" size="40">
                  </td>
                </tr>
				 <tr>
                  <td class="td_right">机构简称：</td>
                  <td class=""> 
                    <input type="text" name="branchShortName" datatype="*1-50" class="input-text lh30" size="40">
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
  