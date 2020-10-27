package sptvr19.java.myschool;

import java.io.Serializable;
import sptvr19.java.myschool.entity.Person;

public class Journal implements Serializable {
    private Person student;
    private Subject subject;
    private Integer mark;
    private String date;

    public Journal(Person student, Subject subject, Integer mark, String date) {
        this.student = student;
        this.subject = subject;
        this.mark = mark;
        this.date = date;
    }

    public Person getStudent() {
        return student;
    }

    public Subject getSubject() {
        return subject;
    }

    public Integer getMark() {
        return mark;
    }

    public String getDate() {
        return date;
    }

    public void setStudent(Person student) {
        this.student = student;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toStringByStudent() {
        return subject.getName() + " / " + mark + " (" + date + ")";
    }
    
    public String toStringBySubject() {
        return student.getFirstname() + " " + student.getLastname() + " / " + mark + " (" + date + ")";
    }   
}
