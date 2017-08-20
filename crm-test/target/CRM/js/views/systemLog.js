$(function(){
	/*
	 * 抽取所有需要用得元素.
	 */
	var systemLogDatagrid,systemLogDialog,systemLogForm;
	systemLogDatagrid = $("#systemLog_datagrid");
	systemLogDialog = $("#systemLog_dialog");
	systemLogForm = $("#systemLog_form");
	/*
	 * 初始化数据表格 
	 */
	systemLogDatagrid.datagrid({
		url:"/systemLog/list",
		fit:true,
		rownumbers:true,
		singleSelect:true,
		striped:true,
		pagination:true,
		fitColumns:true,
		toolbar:'#systemLog_datagrid_tb'
	});
	/*
	 * 初始化新增/编辑对话框 
	 */
	systemLogDialog.dialog({
		width:300,
		height:300,
		closed:true,
		buttons:'#systemLog_dialog_bt'
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
			 add:function(){
				systemLogForm.form("clear");
				systemLogDialog.dialog("setTitle","新增");
				systemLogDialog.dialog("open");
			},
			edit:function(){
				var rowData = systemLogDatagrid.datagrid("getSelected");
				if(rowData){
					systemLogForm.form("clear");
					systemLogDialog.dialog("setTitle","编辑");
					systemLogDialog.dialog("open");
					if(rowData.dept)
						rowData["dept.id"] = rowData.dept.id;
					systemLogForm.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择需要编辑的数据!","warining");
				}
			},
			del:function(){
				var rowData = systemLogDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定需要删除选中数据吗？",function(yes){
						if(yes){
							$.get("/systemLog/delete?systemLogId="+rowData.id,function(data){
								if(data.success){
									$.messager.alert("温馨提示",data.msg,"info",function(){
										systemLogDatagrid.datagrid("reload");
									});
								}else{
									$.messager.alert("温馨提示",data.msg,"error");
								}
							},"json")
						}
					});
				}else{
					$.messager.alert("温馨提示","请选择需要删除的数据!","warining");
				}
			},
			reload:function(){
				systemLogDatagrid.datagrid("reload");
			},
			save:function(){
				var url;
				var idVal = $("[name='id']").val();
				if(idVal){
					url = "/systemLog/update"
				}else{
					url = "/systemLog/save";
				}
				systemLogForm.form("submit",{
					url:url,
					success:function(data){
						data = $.parseJSON(data);
						if(data.success){
							$.messager.alert("温馨提示",data.msg,"info",function(){
								systemLogDialog.dialog("close");
								systemLogDatagrid.datagrid("reload");
							});
						}else{
							$.messager.alert("温馨提示",data.msg,"error");
						}
					}
				});
			},
			cancel:function (){
				systemLogDialog.dialog("close");
			}
	}
});
