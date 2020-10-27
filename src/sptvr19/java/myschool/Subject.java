package sptvr19.java.myschool;

import java.io.Serializable;
import sptvr19.java.myschool.entity.Person;

public class Subject implements Serializable{
    private String name;
    private String duration;
    private Person teacher;

    public Subject(String name, String duration, Person teacher) {
        this.name = name;
        this.duration = duration;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return name + "(" + duration + "hrs, " + teacher.getFirstname() + " " + teacher.getLastname() + ")";
    } 
    
}
