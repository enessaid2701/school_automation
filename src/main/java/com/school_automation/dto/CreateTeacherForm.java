package com.school_automation.dto;

public class CreateTeacherForm
{
    private String name;
    private String userName;
    private String password;
    private String branch;

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getUserName() {return userName;}

    public void setUserName(String userName) {this.userName = userName;}

    public String getBranch() {return branch;}

    public void setBranch(String branch) {this.branch = branch;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}
}
