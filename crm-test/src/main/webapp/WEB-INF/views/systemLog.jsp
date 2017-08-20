<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统日志管理</title>
<%@include file="common.jsp" %>
<script type="text/javascript" src="/js/views/systemLog.js"></script> 
</head>
<body>
	<!-- 数据表格 -->
	<table id="systemLog_datagrid">
		<thead>
			<tr>
				<th data-options="field:'opIp',width:1,align:'center'">操作IP</th>
				<th data-options="field:'opUser',width:1,align:'center'">操作人</th>
				<th data-options="field:'opTime',width:1,align:'center'">操作时间</th>
				<th data-options="field:'params',width:1,align:'center'">操作参数</th>
				<th data-options="field:'function',width:1,align:'center'">操作内容</th>
			</tr>
		</thead>
	</table>
	<!-- 新增编辑对话框 -->
	<div id="systemLog_dialog">
		<form id="systemLog_form" method="post">
		<table align="center" style="margin-top: 15px;">
			<input type="hidden" name="id">
			<tr>
				<td>操作IP</td>
				<td><input type="text" name="opIp"></td>
			</tr>
			<tr>
				<td>操作人</td>
				<td><input type="text" name="opUser"></td>
			</tr>
			<tr>
				<td>操作时间</td>
				<td><input type="text" name="opTime"></td>
			</tr>
			<tr>
				<td>操作参数</td>
				<td><input type="text" name="params"></td>
			</tr>
			<tr>
				<td>操作内容</td>
				<td><input type="text" name="function"></td>
			</tr>
		</table>
		</form>
	</div>
	<!-- 数据表格CRUD按钮 -->
	<div id="systemLog_datagrid_tb">
		<div>
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="edit">編輯</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del">刪除</a>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="reload">刷新</a>
		</div>
	</div>
	<!-- 对话框保存取消按钮 -->
	<div id="systemLog_dialog_bt">
		<a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
	</div>
</body>
</html>