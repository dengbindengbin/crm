package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.Department;

public interface IDepartmentService {
	int deleteByPrimaryKey(Long id);
    int insert(Department record);
    Department selectByPrimaryKey(Long id);
    List<Department> selectAll();
    int updateByPrimaryKey(Department record);
}
