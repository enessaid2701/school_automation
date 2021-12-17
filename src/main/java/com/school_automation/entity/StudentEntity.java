package com.school_automation.entity;

import com.school_automation.dto.StudentDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class StudentEntity extends BaseEntity
{
    private String name;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String yourClass;

    private String password;

    private String userName;

    public String getYourClass() {return yourClass;}

    public void setYourClass(String yourClass) {this.yourClass = yourClass;}

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;}


    public StudentDTO toDTO(){
        return StudentDTO.builder()
                .id(this.getId())
                .name(this.getName())
                .yourClass(this.getYourClass())
                .build();
    }

}
