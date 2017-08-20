<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理</title>
<%@include file="common.jsp" %> 
<script type="text/javascript" src="/static/js/views/employee.js"></script>
</head>
<body>
<table id="employee_datagrid">
	<thead>
		<tr>
			<th data-options="field:'username',align:'center',width:1">账号</th>
			<th data-options="field:'realname',align:'center',width:1">真实姓名</th>
			<th data-options="field:'inputtime',align:'center',width:1">入职时间</th>
			<th data-options="field:'tel',align:'center',width:1">联系方式</th>
			<th data-options="field:'email',align:'center',width:1">邮箱</th>
			<th data-options="field:'dept',align:'center',width:1,formatter:deptFormatter">所属部门</th>
			<th data-options="field:'state',align:'center',width:1,formatter:stateFormatter">状态</th>
			<th data-options="field:'admin',align:'center',width:1,formatter:adminFormatter">是否管理员</th>
		</tr>
	</thead>
</table>
<!-- 定义对话框 -->
<div id="employee_dialog">
	<form id="employee_form" method="post">
		<input type="hidden" name="id">
		<table align="center" style="margin-top: 15px;">
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>真实姓名</td>
				<td><input type="text" name="realname"></td>
			</tr>
			<tr>
				<td>联系方式</td>
				<td><input type="text" name="tel"></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>所属部门</td>
				<td>
					<input class="easyui-combobox" name="dept.id" data-options="valueField:'id',textField:'name',url:'/department/selectListForEmployeeForm'" />  
				</td>
			</tr>
			<tr>
				<td>角色</td>
				<td>
					<input id="roleId" class="easyui-combobox" data-options="multiple:true,valueField:'id',textField:'name',url:'/role/selectListForEmployeeForm'" />  
				</td>
			</tr>
		</table>
	</form>
</div>
<!-- 定义顶部按钮 -->
<div id="employee_datagrid_tb">
	<div>
		<a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a>
		<a id="employee_editBtn" class="easyui-linkbutton" iconCls="icon-edit" plain="true"  data-cmd="edit">编辑</a>
		<a id="employee_quitBtn" class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del">离职</a>
		<a class="easyui-linkbutton" iconCls="icon-search" plain="true" data-cmd="reload">查询</a>
	</div>
	<div>
		关键字:<input type="text" name="keyword"><a class="easyui-linkbutton" iconCls="icon-
" data-cmd="searchContent">搜索</a>
	</div>
</div>
<!-- 对话框底部按钮 -->
<div id="employee_dialog_bt">
	<a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
	<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
</div>
</body>
</html>