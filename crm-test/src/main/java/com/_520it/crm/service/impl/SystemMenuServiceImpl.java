package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.logging.Filter;

import com._520it.crm.domain.Employee;
import org.apache.ibatis.executor.ReuseExecutor;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.SystemMenu;
import com._520it.crm.mapper.SystemMenuMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.ISystemMenuService;
@Service
public class SystemMenuServiceImpl implements ISystemMenuService {
	@Autowired
	private SystemMenuMapper systemMenuMapper;
	
	public int deleteByPrimaryKey(Long id) {
		return systemMenuMapper.deleteByPrimaryKey(id);
	}

	public int insert(SystemMenu record) {
		return systemMenuMapper.insert(record);
	}

	public SystemMenu selectByPrimaryKey(Long id) {
		return systemMenuMapper.selectByPrimaryKey(id);
	}

	public List<SystemMenu> selectAll() {
		return systemMenuMapper.selectAll();
	}

	public int updateByPrimaryKey(SystemMenu record) {
		return systemMenuMapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult queryPage(QueryObject qo) {
		Long count = systemMenuMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<SystemMenu> result = systemMenuMapper.queryPageDataResult(qo);
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}

	@Override
	public List<SystemMenu> queryTree() {
		return systemMenuMapper.queryTree();
	}

	@Override
	public List<SystemMenu> queryForRole() {
		return systemMenuMapper.queryTree();
	}

	@Override
	public List<Long> queryMenuIdsListForRole(Long roleId) {
		return systemMenuMapper.systemMenuMapper(roleId);
	}

	@Override
	public List<SystemMenu> indexMenu() {
		//根据用户的id查询出该用户拥有的菜单信息
		List<SystemMenu> allMenu =  systemMenuMapper.queryTree();
        Employee currentUser = (Employee) SecurityUtils.getSubject().getPrincipal();
        //判断是否是管理员
        if (currentUser.isAdmin()){
              return allMenu;
        }else {
            //根据用户的id来查询出该用户的菜单信息
          List<Long> currentIds =   systemMenuMapper.queryByEmployeeMenu(currentUser.getId());
          //根据主菜单与自身菜单的id来判断是否该菜单是否还有子菜单
            filterMenu(allMenu,currentIds);

        }
        return allMenu;

	}

    private void filterMenu(List<SystemMenu> allMenu, List<Long> currentIds) {
	    //遍历循环，判断主菜单是否有该菜单的信息，有则删除，否则递归查询是否还有子菜单
       SystemMenu menus = null;
        for (int i = allMenu.size()-1; i >= 0; i--) {
            menus = allMenu.get(i);
              if (!currentIds.contains(menus.getId())){
                  allMenu.remove(i);
                  continue;
              }
              //判断该菜单的儿子菜单信息是否也在主菜单中，进行递归操作
            if (menus.getChildren()!= null && menus.getChildren().size()>0){
                filterMenu(menus.getChildren(),currentIds);
            }

        }
    }
}
