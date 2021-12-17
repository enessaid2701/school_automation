package com.school_automation.form;

public class CreateStudentForm
{
    private String name;

    private String yourClass;

    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String password;

    private Long id;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getYourClass() {return yourClass;}

    public void setYourClass(String yourClass) {this.yourClass = yourClass;}
}
