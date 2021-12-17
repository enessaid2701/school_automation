package com.school_automation.entity;

import com.school_automation.dto.TeacherDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class TeacherEntity extends BaseEntity
{
    private String name;

    //@Column(name = "last_name")
    private String userName;

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    private String password;

    public String getBranch() {return branch;}

    public void setBranch(String branch) {this.branch = branch;}

    private String branch;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public TeacherDTO toDTO(){
        return TeacherDTO.builder()
                .branch(this.getBranch())
                .id(this.getId())
                .name(this.getName())
                .build();
    }


}
