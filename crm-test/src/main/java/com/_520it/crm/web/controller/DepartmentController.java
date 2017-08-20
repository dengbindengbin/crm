package com._520it.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Department;
import com._520it.crm.service.IDepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private IDepartmentService departmentService;
	
	@RequestMapping("/selectListForEmployeeForm")
	@ResponseBody
	public List<Department> selectListForEmployeeForm(){
		 List<Department> result = departmentService.selectAll();
		 return result;
	}
}
