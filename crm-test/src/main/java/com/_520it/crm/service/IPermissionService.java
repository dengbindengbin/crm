package com._520it.crm.service;
import java.util.List;
import com._520it.crm.domain.Permission;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

public interface IPermissionService {
	int deleteByPrimaryKey(Long id);
    int insert(Permission record);
    Permission selectByPrimaryKey(Long id);
    List<Permission> selectAll();
    int updateByPrimaryKey(Permission record);
	PageResult queryPagePage(QueryObject qo);
	void load();
	PageResult queryPageForRoleForm();
	PageResult selectPageForRoleFormByRoleId(Long roleId);

    /**
     * 根据用户的ID查询对应的权限的Resource集合
     * @param id
     * @return
     */
    List<String> queryPermissionResourceByEmployeeId(Long id);
}
