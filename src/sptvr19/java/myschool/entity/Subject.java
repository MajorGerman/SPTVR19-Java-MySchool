package sptvr19.java.myschool.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subject implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long Id;
    private String name;
    private String duration;
    private Person teacher;

    public Subject(String name, String duration, Person teacher) {
        this.name = name;
        this.duration = duration;
        this.teacher = teacher;
    }
    
    public Subject() {
        
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.duration);
        hash = 29 * hash + Objects.hashCode(this.teacher);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Subject other = (Subject) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.duration, other.duration)) {
            return false;
        }
        if (!Objects.equals(this.teacher, other.teacher)) {
            return false;
        }
        return true;
    } 
    

    public Long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }
     
    
    
}
