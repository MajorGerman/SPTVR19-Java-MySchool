package sptvr19.java.myschool.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Journal implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
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
    
    public Journal() {
        
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

    @Override
    public String toString() {
        return "Journal{" + "student=" + student + ", subject=" + subject + ", mark=" + mark + ", date=" + date + '}';
    }    
    

    public String toStringByStudent() {
        return subject.getName() + " / " + mark + " (" + date + ")";
    }
    
    public String toStringBySubject() {
        return student.getFirstname() + " " + student.getLastname() + " / " + mark + " (" + date + ")";
    }   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.student);
        hash = 59 * hash + Objects.hashCode(this.subject);
        hash = 59 * hash + Objects.hashCode(this.mark);
        hash = 59 * hash + Objects.hashCode(this.date);
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
        final Journal other = (Journal) obj;
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.student, other.student)) {
            return false;
        }
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        if (!Objects.equals(this.mark, other.mark)) {
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
