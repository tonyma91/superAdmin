
package com.laoma.admin.bean;

import javax.persistence.*;

@Entity
@Table(name="t_organ")
public class Organ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String organname;//机构名称
    private boolean status;//状态->启用or禁用
    public Organ(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganname() {
        return organname;
    }

    public void setOrganname(String organname) {
        this.organname = organname;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

//    @Override
//    public String toString() {
//        return "Organ{" +
//                "id=" + id +
//                ", organname='" + organname + '\'' +
//                ", status=" + status +
//                '}';
//    }
}
