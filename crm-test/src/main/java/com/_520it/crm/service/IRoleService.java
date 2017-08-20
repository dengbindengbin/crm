package com._520it.crm.service;
import java.util.ArrayList;
import java.util.List;
import com._520it.crm.domain.Role;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

public interface IRoleService {
	int deleteByPrimaryKey(Long id);
    int insert(Role record);
    Role selectByPrimaryKey(Long id);
    List<Role> selectAll();
    int updateByPrimaryKey(Role record);
	PageResult queryPage(QueryObject qo);
	List<Long> queryRoleIdListForEmployeeForm(Long employeeId);
	void addMenu(ArrayList<Long> ids, Long roleId);

    /**
     * 根据员工的ID查询对应的角色SN集合
     * @param id
     * @return
     */
    List<String> queryRoleSnListByEmployeeId(Long id);
}
