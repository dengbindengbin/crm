<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${objectCNName}管理</title>
<%@include file="common.jsp" %>
<script type="text/javascript" src="/js/views/${objectName}.js"></script> 
</head>
<body>
	<!-- 数据表格 -->
	<table id="${objectName}_datagrid">
		<thead>
			<tr>
				<#assign h = fieldMap> 
				<#assign keys = h?keys> 
				<#list keys as key>
				<th data-options="field:'${key}',width:1,align:'center'">${h[key]}</th>
				</#list> 
			</tr>
		</thead>
	</table>
	<!-- 新增编辑对话框 -->
	<div id="${objectName}_dialog">
		<form id="${objectName}_form" method="post">
		<table align="center" style="margin-top: 15px;">
			<input type="hidden" name="id">
			<#list keys as key>
			<tr>
				<td>${h[key]}</td>
				<td><input type="text" name="${key}"></td>
			</tr>
			</#list> 
		</table>
		</form>
	</div>
	<!-- 数据表格CRUD按钮 -->
	<div id="${objectName}_datagrid_tb">
		<div>
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="edit">編輯</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del">刪除</a>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="reload">刷新</a>
		</div>
	</div>
	<!-- 对话框保存取消按钮 -->
	<div id="${objectName}_dialog_bt">
		<a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
	</div>
</body>
</html>