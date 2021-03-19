package com.cvworld.nanjing.bean;

import lombok.Data;

import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name="t_user")
public class User {
    @Id  //主键标识
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String usernum; //用户账号
    private String username;//用户名称
    private boolean sex;//性别
    @Temporal(TemporalType.TIMESTAMP)
    private Date brithday;//生日
    private String realname;//真实姓名
    private String password;//密码
    private String email;//邮箱
    private boolean status;//状态
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;//最后登录时间
    @ManyToOne
    private Role role;//多个用户对应一个角色
    public User(){//空构造函数
    }

    /**
     *超级管理员修改用户权限后
     * @param newUser
     * @return　若相同则返回　ｔｒｕｅ
     */
    public boolean equales(User newUser){
        boolean result = true;
        if (this.status!= newUser.status){
            result = false;
        }
        if (this.role.getId().equals(newUser.getRole().getId())){
            result = false;
        }
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}