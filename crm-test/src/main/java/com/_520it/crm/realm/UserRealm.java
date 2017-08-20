package com._520it.crm.realm;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Role;
import com._520it.crm.service.IEmployeeService;
import com._520it.crm.service.IPermissionService;
import com._520it.crm.service.IRoleService;
import lombok.Setter;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lanxw on 2017/7/12.
 */
public class UserRealm extends AuthorizingRealm {
    @Setter
    private IEmployeeService employeeService;
    @Setter
    private IRoleService roleService;
    @Setter
    private IPermissionService permissionService;
    @Override
    public String getName() {
        return "UserRealm";
    }
    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        Employee currentUser = employeeService.queryByUsername(username);
        if(currentUser==null){
            //找不到用户返回null
            return null;
        }
        System.out.println("***************************************");
        System.out.println(currentUser);
        System.out.println(currentUser.getPassword());
        System.out.println("***************************************");
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(currentUser,currentUser.getPassword(),getName());
        return info;
    }
    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Employee currentUser = (Employee) principals.getPrimaryPrincipal();
        List<String> roles = null;
        List<String> perms = null;
        if(currentUser.isAdmin()){
            //如果是超级管理员,拥有所有的角色,所有的权限
            List<Role> roleList = roleService.selectAll();
            roles = new ArrayList<String>();
            for(Role role:roleList){
                roles.add(role.getSn());
            }
            perms = new ArrayList<String>();
            perms.add("*:*");
        }else{
            //根据用户的ID查询对应的角色集合,权限集合
            roles = roleService.queryRoleSnListByEmployeeId(currentUser.getId());
            perms = permissionService.queryPermissionResourceByEmployeeId(currentUser.getId());
        }
        //返回授权信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roles);
        info.addStringPermissions(perms);
        return info;
    }


}
