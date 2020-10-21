package sptvr19.java.myschool.entity;

import java.io.Serializable;

public class Person implements Serializable{
    private String firstname;
    private String lastname;
    private String phone;
    private String role;

    public Person(String firstname, String lastname, String phone, String role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.role = role;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getRole() {
        return role;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + "(" + role + ", " + phone + ")";
    }
    
}
