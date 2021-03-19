package com.cvworld.nanjing.bean;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="t_role")
public class Role {
    @Id //主键标识
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    private Long id;
    private String rolename;//角色名称
    private boolean status;//状态

    @OneToMany(mappedBy = "role")
    private List<User> user=new ArrayList<>();//一个角色对应多个用户

    private boolean userAdmin;//用户管理权限
    private boolean userAdmin_list;//用户列表
    private boolean userAdmin_add;//用户新增
    private boolean userAdmin_edit;//用户编辑
    private boolean userAdmin_delete;//用户删除

    private boolean menuAdmin;//菜单管理权限
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
