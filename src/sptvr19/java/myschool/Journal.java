package sptvr19.java.myschool;

import sptvr19.java.myschool.entity.Person;
import java.util.Date;

public class Journal {
    private Person student;
    private Subject subject;
    private Integer mark;
    private Date date;

    public Journal(Person student, Subject subject, Integer mark, Date date) {
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

    public Date getDate() {
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

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Journal {"
                + "Student: " + student
                + ", Subject: " + subject
                + ", Mark: " + mark
                + ", Date: " + date
                + '}';
    }
    
    
}
