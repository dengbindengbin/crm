package com._520it.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Department;
import com._520it.crm.mapper.DepartmentMapper;
import com._520it.crm.service.IDepartmentService;
@Service
public class DepartmentServiceImpl implements IDepartmentService {
	@Autowired
	private DepartmentMapper DepartmentMapper;
	public int deleteByPrimaryKey(Long id) {
		return DepartmentMapper.deleteByPrimaryKey(id);
	}

	public int insert(Department record) {
		int count = DepartmentMapper.insert(record);
		return count;
	}

	public Department selectByPrimaryKey(Long id) {
		return DepartmentMapper.selectByPrimaryKey(id);
	}

	public List<Department> selectAll() {
		return DepartmentMapper.selectAll();
	}

	public int updateByPrimaryKey(Department record) {
		return DepartmentMapper.updateByPrimaryKey(record);
	}

}
