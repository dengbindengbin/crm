package com._520it.crm.mapper;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Permission;
import com._520it.crm.query.EmployeeQueryObject;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Employee record);
    Employee selectByPrimaryKey(Long id);
    List<Employee> selectAll();
    int updateByPrimaryKey(Employee record);
	Employee login(@Param("username")String username, @Param("password")String password);
	Long queryPageCount(EmployeeQueryObject qo);
	List<Employee> queryPageData(EmployeeQueryObject qo);
	void changeState(@Param("employeeId")Long id,@Param("employeeState") int employeeStateQuit);
	void insertRelation(@Param("roleId")Long roleId, @Param("employeeId")Long employeeId);
	List<Permission> queryPermissionByEmployeeId(Long employeeId);
	void deleteRelation(Long id);
    Employee queryByUsername(String username);
}