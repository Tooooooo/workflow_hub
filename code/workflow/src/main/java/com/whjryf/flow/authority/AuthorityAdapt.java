package com.whjryf.flow.authority;

/**
 * @author 涂鼎 tuding27@gmail.com  QQ:200161
 * @version 0.1
 * @since 2022/1/19
 */
public interface AuthorityAdapt {

    User[] allUser();

    User userById(Object userId);

    User userByAccount(String account);

    User[] userByDepartment(Object departmentId);

    User[] userByRole(String role);

    User[] userByGroupId(Object groupId);

    User currentLogin();

    Role[] allRoles();

    /**
     * 按树状结构反映层级关系.
     */
    Department[] allDepartments();

    /**
     * 按树状结构反映层级关系.
     * @param withChildren 是否获取子部门.
     */
    Department departmentById(Object departmentId,boolean withChildren);

    Group[] allGroups();

    Group groupById(Object groupId);

}
