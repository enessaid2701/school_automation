package com.school_automation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class StudentEntity extends BaseEntity
{
    private String name;

    //@Column(name = "last_name")

    private String yourClass;

    public String getYourClass() {return yourClass;}

    public void setYourClass(String yourClass) {this.yourClass = yourClass;}

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;}

}
