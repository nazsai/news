  <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
       
       $(document).ready(function(){
       		$("#forms").Validform({
       			 btnSubmit:"#addBrand",
       			 tiptype:function(msg,o,cssctl){
             		if(!o.obj.is("form")){
                		var objtip=o.obj.parents().children(".Validform_checktip");
                		cssctl(objtip,o.type);
               			 objtip.text(msg);
           				}
        			},
        			ajaxPost: true,
        			datatype:{
        				"brandname" : function(gets,obj,curform,regxp){
        					if(gets == ''){
        						return "请填写品牌名称";
        					}else if(gets == "${brandVo.brandname}"){
        						return "该品牌名已存在";
        					}
        				}
        			} 
       		});
       		
       		//从数据库获取业态数据
	      	$.post('${ctx}/institution/tooAddBrand',function(data){
	      		var str = "";
	      		$.each(data,function(name,value){
	      			str+='<option value="'+name+'">'+value+'</option>'
	      		})
	      		$("#industry").append(str);
	      	},'json')
	    })
	      	
   </script>
   <title>添加品牌</title>
 </head>
 <body>
  <div class="container">
     <div id="forms" class="mt10">
        <div class="box">
          <div class="box_border">
            
            <div class="box_center">
              <form action="addBrand"  method="post" class="jqtransform">
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
                 <tr>
                  <td class="td_right">品牌名称：</td>
                  <td class=""> 
                  	<input type="text" class="release_text" id="brandname" name="brandname" datatype="*3-16" nullmsg="填写品牌名称" />
                  	<span class="Validform_checktip"></span>
                  </td>
                </tr>
				 <tr>
                  <td class="td_right">所属业态：</td>
                  <td class="jqtransform">
                  	<select name="industry" id="industry">
                  		<option value=''>请选择</option>
                  	</select>
                  </td>
                </tr>
                 <tr>
                   <td class="td_right">&nbsp;</td>
                   <td class="">
                     <input type="submit" name="button" onclick="addBrand()" class="btn btn82 btn_save2" value="保存">
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
 <script type="text/javascript">
 	function addBrand(){
 		var brandname = $("#brandname").val();
 		var industryid = $("#industry").val();
 		var param = {
 			brandname:brandname,
 			industryid:industryid
 		}
 		$.post('${ctx}/institution/addBrand',param,function(data){
 			
 		},'json')
 	}
 </script>
 </html>
  