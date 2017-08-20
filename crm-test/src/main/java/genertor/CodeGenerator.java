package genertor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;

import com._520it.crm.domain.Cat;
import com._520it.crm.domain.Role;

import com._520it.crm.domain.SystemLog;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class CodeGenerator {
	private static Configuration conf = new Configuration();
	static{
		try {
			//设置文件模板目录在什么地方
			conf.setDirectoryForTemplateLoading(new File("templates"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception{
//		codeGenerator(SystemLog.class);
		System.out.println("执行完毕。。。。。。");
		
	}
	private static void codeGenerator(Class clazz) throws Exception {
		//System.out.println(MessageFormat.format("今天天气不错,{0}去干{1}", "小明","活"));
		//数据模型
		ClassInfo classInfo = new ClassInfo(clazz);
		//生成Mapper
		createFile("Mapper.java","src/main/java/{0}/mapper/{1}Mapper.java",classInfo);
		createFile("Mapper.xml","src/main/resources/{0}/mapper/{1}Mapper.xml",classInfo);
		//生成Service
		createFile("IService.java","src/main/java/{0}/service/I{1}Service.java",classInfo);
		createFile("ServiceImpl.java","src/main/java/{0}/service/impl/{1}ServiceImpl.java",classInfo);
		//生成QueryObject
		createFile("QueryObject.java","src/main/java/{0}/query/{1}QueryObject.java",classInfo);
		//生成Controller
		createFile("Controller.java","src/main/java/{0}/web/controller/{1}Controller.java",classInfo);
		//生成JSP页面和js
		createFile("target.jsp","src/main/webapp/WEB-INF/views/{2}.jsp",classInfo);
		createFile("target.js","src/main/webapp/js/views/{2}.js",classInfo);
		
	}
	
	/**
	 * 
	 * @param templateName  模板文件名称
	 * @param outPath       文件输出路径
	 * @param classInfo     数据模型
	 */
	private static void createFile(String templateName,String outPath,ClassInfo classInfo) throws Exception{
		Template temp = conf.getTemplate(templateName);
		outPath = MessageFormat.format(outPath, classInfo.getPackageName().replace(".", "/"),classInfo.getClassName(),classInfo.getObjectName());
		File targetFile = new File(outPath);
		//创建目录
		if(!targetFile.getParentFile().exists()){
			targetFile.getParentFile().mkdirs();
		}
		temp.process(classInfo, new FileWriter(targetFile));
	}
}
