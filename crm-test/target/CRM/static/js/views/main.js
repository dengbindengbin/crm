$(function(){
	$("#main_menu").tree({
		url:'/systemMenu/indexMenu',
		onClick:function(node){
			var mainTabs = $("#main_tabs");
			//判断当前点击的节点是否已经创建对应的面板了?
			if(mainTabs.tabs("exists",node.text)){
				//选中选项卡
				mainTabs.tabs("select",node.text);
			}else{
				//新增选项卡
				//找到选项卡,往选项卡中添加面板
				mainTabs.tabs("add",{
					title:node.text,
					closable:true,
					//href:node.attributes.url//只能加载远程页面中的body部分的内容
					content:'<iframe src="'+node.attributes.url+'" style="width:100%;height:100%" frameborder="0"></iframe>'
				});
			}
		}
	});
});