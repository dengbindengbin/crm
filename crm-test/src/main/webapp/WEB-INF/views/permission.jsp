<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限管理</title>
<%@include file="common.jsp" %>
<script type="text/javascript" src="/static/js/views/permission.js"></script> 
</head>
<body>
	<!-- 数据表格 -->
	<table id="permission_datagrid">
		<thead>
			<tr>
				<th data-options="field:'name',width:1,align:'center'">名称</th>
				<th data-options="field:'resource',width:1,align:'center'">表达式</th>
			</tr>
		</thead>
	</table>
	<!-- 新增编辑对话框 -->
	<div id="permission_dialog">
		<form id="permission_form" method="post">
		<table align="center" style="margin-top: 15px;">
			<input type="hidden" name="id">
			<tr>
				<td>表达式</td>
				<td><input type="text" name="resource"></td>
			</tr>
			<tr>
				<td>名称</td>
				<td><input type="text" name="name"></td>
			</tr>
		</table>
		</form>
	</div>
	<!-- 数据表格CRUD按钮 -->
	<div id="permission_datagrid_tb">
		<div>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="load">加载权限</a>
		</div>
	</div>
	<!-- 对话框保存取消按钮-->
	<div id="permission_dialog_bt">
		<a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
	</div>
</body>
</html>