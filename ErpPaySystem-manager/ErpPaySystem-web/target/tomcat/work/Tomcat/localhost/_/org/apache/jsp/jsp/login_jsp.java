/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-11-13 08:23:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write(" \r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"zh-CN\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/resource/css/login.css\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resource/js/jquery.min.js\"></script>\r\n");
      out.write("\t<script language=\"javascript\" type=\"text/javascript\">\r\n");
      out.write("        if (window.top != null && window.top.location != window.location) {\r\n");
      out.write("            window.top.location = window.location;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("    \tif (window.top.location.href!=location.href) {\r\n");
      out.write("        \twindow.top.location.href=location.href;\r\n");
      out.write("    \t}\r\n");
      out.write("    </script>\r\n");
      out.write("\t<title>后台登陆</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"login_top\">\r\n");
      out.write("\t\t<div id=\"welcome\">\r\n");
      out.write("\t\t\t欢迎使用教学质量与教学改革工程管理系统\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"back\">\r\n");
      out.write("\t\t\t<a href=\"#\">返回首页</a>&nbsp;&nbsp; | &nbsp;&nbsp;\r\n");
      out.write("\t\t\t<a href=\"#\">帮助</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"login_center\">\r\n");
      out.write("\t\t<div id=\"login_area\">\r\n");
      out.write("\t\t\t<div id=\"login_form\">\r\n");
      out.write("\t\t\t\t<form action=\"login\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t<div id=\"login_tip\">\r\n");
      out.write("\t\t\t\t\t\t用户登录&nbsp;&nbsp;UserLogin\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div><input type=\"text\" name=\"usercode\" class=\"username\"></div>\r\n");
      out.write("\t\t\t\t\t<div><input type=\"password\" name=\"password\" class=\"pwd\"></div>\r\n");
      out.write("\t\t\t\t\t<div id=\"btn_area\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" name=\"submit\" id=\"sub_btn\" value=\"登&nbsp;&nbsp;录\">&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"login_bottom\">\r\n");
      out.write("\t\t版权所有\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}