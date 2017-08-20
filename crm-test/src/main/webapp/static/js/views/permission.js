$(function(){
	/*
	 * 抽取所有需要用得元素.
	 */
	var permissionDatagrid,permissionDialog,permissionForm;
	permissionDatagrid = $("#permission_datagrid");
	permissionDialog = $("#permission_dialog");
	permissionForm = $("#permission_form");
	/*
	 * 初始化数据表格 
	 */
	permissionDatagrid.datagrid({
		url:"/permission/list",
		fit:true,
		rownumbers:true,
		singleSelect:true,
		striped:true,
		pagination:true,
		fitColumns:true,
		toolbar:'#permission_datagrid_tb'
	});
	/*
	 * 初始化新增/编辑对话框 
	 */
	permissionDialog.dialog({
		width:300,
		height:300,
		closed:true,
		buttons:'#permission_dialog_bt'
	});
	/*
	 * 对页面按钮进行统一监听
	 */
	$("a[data-cmd]").on("click",function(){
		var cmd = $(this).data("cmd");
		if(cmd){
			cmdObj[cmd]();
		}
	});
	/*
	 * 所有的操作封装到cmdObj对象中,方便管理
	 */
	var cmdObj = {
			load:function(){
				$.messager.confirm("温馨提示","您确定需要重新加载权限吗吗？",function(yes){
					if(yes){
						$.get("/permission/load",function(data){
							if(data.success){
								$.messager.alert("温馨提示",data.msg,"info",function(){
									permissionDatagrid.datagrid("reload");
								});
							}else{
								$.messager.alert("温馨提示",data.msg,"error");
							}
						},"json")
					}
				});
			}
	}
});
