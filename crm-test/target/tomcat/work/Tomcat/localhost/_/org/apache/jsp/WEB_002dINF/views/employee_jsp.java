/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-08-20 12:50:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class employee_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/common.jsp", Long.valueOf(1499851484000L));
  }

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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>员工管理</title>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/static/js/jquery-easyui/themes/default/easyui.css\"><!-- 样式包 -->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/static/js/jquery-easyui/themes/icon.css\"><!-- 图标的样式 -->   \r\n");
      out.write("<script type=\"text/javascript\" src=\"/static/js/jquery-easyui/jquery.min.js\"></script><!-- jQuery核心包 -->   \r\n");
      out.write("<script type=\"text/javascript\" src=\"/static/js/jquery-easyui/jquery.easyui.min.js\"></script><!-- EaysUI核心包 -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"/static/js/jquery-easyui/locale/easyui-lang-zh_CN.js\"></script><!-- 中文包 -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"/static/js/jquery-easyui/base.js\"></script><!-- 补丁包 -->\r\n");
      out.write(" \r\n");
      out.write("<script type=\"text/javascript\" src=\"/static/js/views/employee.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<table id=\"employee_datagrid\">\r\n");
      out.write("\t<thead>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th data-options=\"field:'username',align:'center',width:1\">账号</th>\r\n");
      out.write("\t\t\t<th data-options=\"field:'realname',align:'center',width:1\">真实姓名</th>\r\n");
      out.write("\t\t\t<th data-options=\"field:'inputtime',align:'center',width:1\">入职时间</th>\r\n");
      out.write("\t\t\t<th data-options=\"field:'tel',align:'center',width:1\">联系方式</th>\r\n");
      out.write("\t\t\t<th data-options=\"field:'email',align:'center',width:1\">邮箱</th>\r\n");
      out.write("\t\t\t<th data-options=\"field:'dept',align:'center',width:1,formatter:deptFormatter\">所属部门</th>\r\n");
      out.write("\t\t\t<th data-options=\"field:'state',align:'center',width:1,formatter:stateFormatter\">状态</th>\r\n");
      out.write("\t\t\t<th data-options=\"field:'admin',align:'center',width:1,formatter:adminFormatter\">是否管理员</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</thead>\r\n");
      out.write("</table>\r\n");
      out.write("<!-- 定义对话框 -->\r\n");
      out.write("<div id=\"employee_dialog\">\r\n");
      out.write("\t<form id=\"employee_form\" method=\"post\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"id\">\r\n");
      out.write("\t\t<table align=\"center\" style=\"margin-top: 15px;\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>用户名</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"username\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>真实姓名</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"realname\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>联系方式</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"tel\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>邮箱</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"email\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>所属部门</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input class=\"easyui-combobox\" name=\"dept.id\" data-options=\"valueField:'id',textField:'name',url:'/department/selectListForEmployeeForm'\" />  \r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>角色</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input id=\"roleId\" class=\"easyui-combobox\" data-options=\"multiple:true,valueField:'id',textField:'name',url:'/role/selectListForEmployeeForm'\" />  \r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- 定义顶部按钮 -->\r\n");
      out.write("<div id=\"employee_datagrid_tb\">\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-add\" plain=\"true\" data-cmd=\"add\">新增</a>\r\n");
      out.write("\t\t<a id=\"employee_editBtn\" class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\"  data-cmd=\"edit\">编辑</a>\r\n");
      out.write("\t\t<a id=\"employee_quitBtn\" class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\" data-cmd=\"del\">离职</a>\r\n");
      out.write("\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-search\" plain=\"true\" data-cmd=\"reload\">查询</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t关键字:<input type=\"text\" name=\"keyword\"><a class=\"easyui-linkbutton\" iconCls=\"icon-\r\n");
      out.write("\" data-cmd=\"searchContent\">搜索</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- 对话框底部按钮 -->\r\n");
      out.write("<div id=\"employee_dialog_bt\">\r\n");
      out.write("\t<a class=\"easyui-linkbutton\" iconCls=\"icon-save\" plain=\"true\" data-cmd=\"save\">保存</a>\r\n");
      out.write("\t<a class=\"easyui-linkbutton\" iconCls=\"icon-cancel\" plain=\"true\" data-cmd=\"cancel\">取消</a>\r\n");
      out.write("</div>\r\n");
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
