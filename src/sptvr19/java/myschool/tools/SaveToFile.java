package sptvr19.java.myschool.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import sptvr19.java.myschool.entity.Journal;
import sptvr19.java.myschool.entity.Person;
import sptvr19.java.myschool.entity.Subject;

public class SaveToFile {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SPTVR19LaabeSchool");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    public void savePersonToFile(List<Person> arrayList) {
        tx.begin();
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i) != null && arrayList.get(i).getId() == null) {
                em.persist(arrayList.get(i));
                break;
            } else {
                em.merge(arrayList.get(i));
            }
        }
        tx.commit();
    }

    public void saveSubjectToFile(List<Subject> arrayList) {
        tx.begin();
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i) != null && arrayList.get(i).getId() == null) {
                em.persist(arrayList.get(i));
                break;
            } else {
                em.merge(arrayList.get(i));
            }
        }
        tx.commit();
    }
        
    public void saveJournalToFile(List<Journal> arrayList) {
        tx.begin();
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i) != null && arrayList.get(i).getId() == null) {
                em.persist(arrayList.get(i));
                break;
            } else {
                em.merge(arrayList.get(i));
            }
        }
        tx.commit();
        
    }
    
//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        try {
//            fos = new FileOutputStream(fileName);
//            oos = new ObjectOutputStream(fos);
//            oos.writeObject(arrayList);
//            oos.flush();
//        } catch (FileNotFoundException ex) {
//            System.out.println("Не найден файл");
//        } catch (IOException ex) {
//            System.out.println("Ошибка ввода/вывода");
//        }

    public List loadPersonFromFile() {
        try {
            return em.createQuery("SELECT person FROM Person person").getResultList();
        } catch (Exception e) {
            System.out.println("No data");
            return new ArrayList<>();
        }
    }
     
    public List loadSubjectFromFile() {
        try {
            return em.createQuery("SELECT subject FROM Subject subject").getResultList();
        } catch (Exception e) {
            System.out.println("No data");
            return new ArrayList<>();
        }
    }

    public List loadJournalFromFile() {
        try {
            return em.createQuery("SELECT journal FROM Journal journal").getResultList();
        } catch (Exception e) {
            System.out.println("No data");
            return new ArrayList<>();
        }
    }  
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
//        try {
//            fis = new FileInputStream(fileName);
//            ois = new ObjectInputStream(fis);
//            return (List) ois.readObject();
//        } catch (FileNotFoundException ex) {
//            System.out.println("Не найден файл");
//        } catch (IOException ex) {
//            System.out.println("Ошибка ввода/вывода");
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Ошибка: не найден класс");
//        }
//        return new ArrayList();
}
