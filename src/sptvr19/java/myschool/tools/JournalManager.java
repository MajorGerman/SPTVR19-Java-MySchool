package sptvr19.java.myschool.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import sptvr19.java.myschool.entity.Journal;
import sptvr19.java.myschool.entity.Subject;
import sptvr19.java.myschool.entity.Person;

public class JournalManager {
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    
    Scanner scan = new Scanner(System.in);
    
    PersonManager personManager = new PersonManager();
    SubjectManager subjectManager = new SubjectManager();   

    public Journal createJournal(List<Person> listPersons, List<Subject> listSubjects) {
        Person student;
        Subject subject;
        int mark;
        
        personManager.showList("Student", listPersons);
        while (true) { 
            System.out.print(ANSI_YELLOW + "\nInput student's ID: " + ANSI_RESET);
            String student_id = scan.nextLine();
            try {
                student = listPersons.get(Integer.parseInt(student_id));
                if (listPersons.get(Integer.parseInt(student_id)).getRole().equals("Student")) {
                    break;
                } else {
                    System.out.println(ANSI_RED + "There is no student with this ID!" + ANSI_RESET);
                }
            } catch(Exception e) {
                System.out.println(ANSI_RED + "There is no student with this ID!" + ANSI_RESET);
            }
        }
        
        subjectManager.showList(listSubjects);
        while (true) {
            System.out.print(ANSI_YELLOW + "\nInput subject number: " + ANSI_RESET);
            String subject_id = scan.nextLine();
            try {
                subject = listSubjects.get(Integer.parseInt(subject_id)-1);
                break;
            } catch(Exception e) {
                System.out.println(ANSI_RED + "There is no subject with this number!" + ANSI_RESET);
            }
        }  
        
        while (true) {
            System.out.print(ANSI_YELLOW + "\nInput mark: " + ANSI_RESET);
            mark = scan.nextInt();
            if (mark < 1 || mark > 5) {
                System.out.println(ANSI_RED + "Mark cannot be less that 1 and greater than 5!" + ANSI_RESET);
            } else {
                break;
            }      
        }
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  
        
        Journal journal = new Journal(student, subject, mark, formatter.format(date));
        return journal;               
    }

    public void addJournalToList(Journal journal, List<Journal> listJournals) {
        listJournals.add(journal);
        SaveToFile saveToFile = new SaveToFile();
        saveToFile.saveToFile(listJournals, "listJournals");
    }
    
    public void showListByStudent(List<Person> listPersons, List<Journal> listJournals) {
        personManager.showList("Student", listPersons);
        System.out.print(ANSI_YELLOW + "\nInput student's ID: " + ANSI_RESET);
        int student_choosed = scan.nextInt();
        System.out.println("");
        int j = 1;
        for (int i = 0; i < listJournals.size(); i++) {  
            if (listJournals.get(i).getStudent().equals(listPersons.get(student_choosed))) {
                System.out.println(ANSI_CYAN + j + ". " + (String)(listJournals.get(i).toStringByStudent()) + ANSI_RESET);
                j++;
            }
        }
    }
    
    public void showListBySubject(List<Subject> listSubjects, List<Journal> listJournals) {
        if (listSubjects.size() < 1) {
            System.out.println(ANSI_RED + "There is no any subject!" + ANSI_RESET);
        } else {           
            subjectManager.showList(listSubjects);
            System.out.print(ANSI_YELLOW + "\nInput subject number: " + ANSI_RESET);
            int subject_choosed = scan.nextInt();
            System.out.println("");
            int j = 1;
            for (int i = 0; i < listJournals.size(); i++) {
                if (listJournals.get(i).getSubject().getName().equals(listSubjects.get(subject_choosed-1).getName())) {
                    System.out.println(ANSI_CYAN + j + ". " + (String)(listJournals.get(i).toStringBySubject()) + ANSI_RESET);
                    j++;
                }
            }
        }
    }
}
