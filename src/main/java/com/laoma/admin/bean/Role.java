package com.laoma.admin.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="t_role")
public class Role implements Serializable {
    @Id //主键标识
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    private Long id;
    private String rolename;//角色名称
    private boolean status;//状态

    @OneToMany(mappedBy = "role")
    private  List<User> user=new ArrayList<>();//一个角色对应多个用户

    private boolean userAdmin;//用户管理权限
    private boolean userAdmin_list;//用户列表
    private boolean userAdmin_add;//用户新增
    private boolean userAdmin_edit;//用户编辑
    private boolean userAdmin_delete;//用户删除

    private boolean menuAdmin;//菜单管理权限

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", rolename='" + rolename + '\'' +
                ", status=" + status +
                ", user=" + user +
                ", userAdmin=" + userAdmin +
                ", userAdmin_list=" + userAdmin_list +
                ", userAdmin_add=" + userAdmin_add +
                ", userAdmin_edit=" + userAdmin_edit +
                ", userAdmin_delete=" + userAdmin_delete +
                ", menuAdmin=" + menuAdmin +
                ", menuAdmin_list=" + menuAdmin_list +
                ", menuAdmin_add=" + menuAdmin_add +
                ", menuAdmin_edit=" + menuAdmin_edit +
                ", menuAdmin_delete=" + menuAdmin_delete +
                ", roleAdmin=" + roleAdmin +
                ", roleAdmin_list=" + roleAdmin_list +
                ", roleAdmin_add=" + roleAdmin_add +
                ", roleAdmin_edit=" + roleAdmin_edit +
                ", roleAdmin_delete=" + roleAdmin_delete +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public boolean isUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(boolean userAdmin) {
        this.userAdmin = userAdmin;
    }

    public boolean isUserAdmin_list() {
        return userAdmin_list;
    }

    public void setUserAdmin_list(boolean userAdmin_list) {
        this.userAdmin_list = userAdmin_list;
    }

    public boolean isUserAdmin_add() {
        return userAdmin_add;
    }

    public void setUserAdmin_add(boolean userAdmin_add) {
        this.userAdmin_add = userAdmin_add;
    }

    public boolean isUserAdmin_edit() {
        return userAdmin_edit;
    }

    public void setUserAdmin_edit(boolean userAdmin_edit) {
        this.userAdmin_edit = userAdmin_edit;
    }

    public boolean isUserAdmin_delete() {
        return userAdmin_delete;
    }

    public void setUserAdmin_delete(boolean userAdmin_delete) {
        this.userAdmin_delete = userAdmin_delete;
    }

    public boolean isMenuAdmin() {
        return menuAdmin;
    }

    public void setMenuAdmin(boolean menuAdmin) {
        this.menuAdmin = menuAdmin;
    }

    public boolean isMenuAdmin_list() {
        return menuAdmin_list;
    }

    public void setMenuAdmin_list(boolean menuAdmin_list) {
        this.menuAdmin_list = menuAdmin_list;
    }

    public boolean isMenuAdmin_add() {
        return menuAdmin_add;
    }

    public void setMenuAdmin_add(boolean menuAdmin_add) {
        this.menuAdmin_add = menuAdmin_add;
    }

    public boolean isMenuAdmin_edit() {
        return menuAdmin_edit;
    }

    public void setMenuAdmin_edit(boolean menuAdmin_edit) {
        this.menuAdmin_edit = menuAdmin_edit;
    }

    public boolean isMenuAdmin_delete() {
        return menuAdmin_delete;
    }

    public void setMenuAdmin_delete(boolean menuAdmin_delete) {
        this.menuAdmin_delete = menuAdmin_delete;
    }

    public boolean isRoleAdmin() {
        return roleAdmin;
    }

    public void setRoleAdmin(boolean roleAdmin) {
        this.roleAdmin = roleAdmin;
    }

    public boolean isRoleAdmin_list() {
        return roleAdmin_list;
    }

    public void setRoleAdmin_list(boolean roleAdmin_list) {
        this.roleAdmin_list = roleAdmin_list;
    }

    public boolean isRoleAdmin_add() {
        return roleAdmin_add;
    }

    public void setRoleAdmin_add(boolean roleAdmin_add) {
        this.roleAdmin_add = roleAdmin_add;
    }

    public boolean isRoleAdmin_edit() {
        return roleAdmin_edit;
    }

    public void setRoleAdmin_edit(boolean roleAdmin_edit) {
        this.roleAdmin_edit = roleAdmin_edit;
    }

    public boolean isRoleAdmin_delete() {
        return roleAdmin_delete;
    }

    public void setRoleAdmin_delete(boolean roleAdmin_delete) {
        this.roleAdmin_delete = roleAdmin_delete;
    }

    private boolean menuAdmin_list;//菜单列表
    private boolean menuAdmin_add;//菜单新增
    private boolean menuAdmin_edit;//菜单编辑
    private boolean menuAdmin_delete;//菜单删除

    private boolean roleAdmin;//角色管理权限
    private boolean roleAdmin_list;//角色列表
    private boolean roleAdmin_add;//角色新增
    private boolean roleAdmin_edit;//角色编辑
    private boolean roleAdmin_delete;//角色删除

    public Role(){//空构造函数

    }

    public boolean equales(Role newRole){
        if (this.getId().equals(newRole.getId())){
            return true;
        }
        return false;
    }
}
