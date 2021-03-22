package com.laoma.admin.bean;

import javax.persistence.*;

@Entity
@Table(name="t_menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String menuname;//菜单名称
    private Long parentid;//父级菜单
    private String remark;//备注
    private boolean status;//状态
    private String groupy;//group
    private String model;//model
    private String action;//action
    public Menu(){  //空函数
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getGroupy() {
        return groupy;
    }

    public void setGroupy(String groupy) {
        this.groupy = groupy;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Cmenu{" +
                "id=" + id +
                ", menuname='" + menuname + '\'' +
                ", parentid=" + parentid +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", group='" + groupy + '\'' +
                ", model='" + model + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}
