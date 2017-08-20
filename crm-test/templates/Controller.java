package ${packageName}.web.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import ${packageName}.domain.${className};
import ${packageName}.page.AjaxResult;
import ${packageName}.page.PageResult;
import ${packageName}.query.${className}QueryObject;
import ${packageName}.service.I${className}Service;

@Controller
@RequestMapping("/${objectName}")
public class ${className}Controller {
	@Autowired
	I${className}Service ${objectName}Service;
	
	@RequestMapping("")
	public String index(){
		return "${objectName}";
	}
	@RequestMapping("/list")
	@ResponseBody
	public PageResult list(${className}QueryObject qo){
		PageResult pageResult = null;
		pageResult = ${objectName}Service.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(${className} ${objectName}){
		AjaxResult result = null;
		try{
			${objectName}Service.insert(${objectName});
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult update(${className} ${objectName}){
		AjaxResult result = null;
		try{
			${objectName}Service.updateByPrimaryKey(${objectName});
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long ${objectName}Id){
		AjaxResult result = null;
		try{
			${objectName}Service.deleteByPrimaryKey(${objectName}Id);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("删除失败,请联系管理员！");
		}
		return result;
	}
}
