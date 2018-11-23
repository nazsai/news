  <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <c:set var="ctx" value="${pageContext.request.contextPath}" />
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
      			datatype : {
      				"checkBrandname" : function(gets,obj,curform,regxp) {
      					//参数gets是获取到的表单元素值，obj为当前表单元素，curform为当前验证的表单，regxp为内置的一些正则表达式
      					
      					//需要brandname原始值：
      					var brandname = '${brandVo.brandname}';
      					
      					//需要验证的值gets
      					var result = true;
      					if(brandname != gets) {
      						$.ajax({
      							url : "checkBrandname",
      							data : {
      								param : gets,
      								brandid : brandid
      							},
      							type : "post",
      							// false 代表同步 等ajax全部运行完成再执行  true代表异步（默认）
      							async: false,
      							success : function(data) {
      								if (data != 'y') {
      									result = data;
      								}
      							}
      						});
      					}
      				}
      			}
      		});
      			$.post('${ctx}/institution/toAddBrandPage',function(data){
		      		var str = "";
		      		$.each(data,function(name,value){
		      			str+='<option value="'+name+'">'+value+'</option>'
		      		})
		      		$("#industry").append(str);
		      	},'json')
      });
   </script>
   <title>添加页面</title>
 </head>
 <body>
  <div class="container">
     <div id="forms" class="mt10">
        <div class="box">
          <div class="box_border">
            <div class="box_top"><b class="pl15">添加品牌</b></div>
            <div class="box_center">
              <form action="addBrand"  method="post" class="jqtransform">
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
                 <tr>
                  <td class="td_right">品牌名称：</td>
                  <td class=""> 
                    <input type="text" name="brandname" datatype="*1-50" ajaxurl="checkBrandname" class="input-text lh30" size="40">
                  </td>
                </tr>
				 <tr>
                  <td class="td_right">所属业态：</td>
                  <td class="jqtransform">
                  	<select id="groupType" name="offsetType" class="table "></select>  
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
  