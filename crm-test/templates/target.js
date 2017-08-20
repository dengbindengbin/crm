$(function(){
	/*
	 * 抽取所有需要用得元素.
	 */
	var ${objectName}Datagrid,${objectName}Dialog,${objectName}Form;
	${objectName}Datagrid = $("#${objectName}_datagrid");
	${objectName}Dialog = $("#${objectName}_dialog");
	${objectName}Form = $("#${objectName}_form");
	/*
	 * 初始化数据表格 
	 */
	${objectName}Datagrid.datagrid({
		url:"/${objectName}/list",
		fit:true,
		rownumbers:true,
		singleSelect:true,
		striped:true,
		pagination:true,
		fitColumns:true,
		toolbar:'#${objectName}_datagrid_tb'
	});
	/*
	 * 初始化新增/编辑对话框 
	 */
	${objectName}Dialog.dialog({
		width:300,
		height:300,
		closed:true,
		buttons:'#${objectName}_dialog_bt'
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
				${objectName}Form.form("clear");
				${objectName}Dialog.dialog("setTitle","新增");
				${objectName}Dialog.dialog("open");
			},
			edit:function(){
				var rowData = ${objectName}Datagrid.datagrid("getSelected");
				if(rowData){
					${objectName}Form.form("clear");
					${objectName}Dialog.dialog("setTitle","编辑");
					${objectName}Dialog.dialog("open");
					if(rowData.dept)
						rowData["dept.id"] = rowData.dept.id;
					${objectName}Form.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择需要编辑的数据!","warining");
				}
			},
			del:function(){
				var rowData = ${objectName}Datagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定需要删除选中数据吗？",function(yes){
						if(yes){
							$.get("/${objectName}/delete?${objectName}Id="+rowData.id,function(data){
								if(data.success){
									$.messager.alert("温馨提示",data.msg,"info",function(){
										${objectName}Datagrid.datagrid("reload");
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
				${objectName}Datagrid.datagrid("reload");
			},
			save:function(){
				var url;
				var idVal = $("[name='id']").val();
				if(idVal){
					url = "/${objectName}/update"
				}else{
					url = "/${objectName}/save";
				}
				${objectName}Form.form("submit",{
					url:url,
					success:function(data){
						data = $.parseJSON(data);
						if(data.success){
							$.messager.alert("温馨提示",data.msg,"info",function(){
								${objectName}Dialog.dialog("close");
								${objectName}Datagrid.datagrid("reload");
							});
						}else{
							$.messager.alert("温馨提示",data.msg,"error");
						}
					}
				});
			},
			cancel:function (){
				${objectName}Dialog.dialog("close");
			}
	}
});
