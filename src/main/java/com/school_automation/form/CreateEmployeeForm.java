package com.school_automation.form;

public class CreateEmployeeForm
{
    private String name;
    private String job;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getJob() {return job;}

    public void setJob(String job) {this.job = job;}
}
