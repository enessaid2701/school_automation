package com.school_automation.entity;

import com.school_automation.dto.EmployeeDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class EmployeeEntity extends BaseEntity
{
    private String name;

    private String job;

    public String getJob() {return job;}

    public void setJob(String job) {this.job = job;}

    //@Column(name = "last_name")

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public EmployeeDTO toDTO(){
        return EmployeeDTO
                .builder()
                .id(this.getId())
                .job(this.getJob())
                .name(this.getName())
                .build();
    }

}
