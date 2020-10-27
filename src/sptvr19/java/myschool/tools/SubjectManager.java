package sptvr19.java.myschool.tools;

import java.util.List;
import java.util.Scanner;
import sptvr19.java.myschool.entity.Person;
import sptvr19.java.myschool.Subject;

public class SubjectManager {
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    
    Scanner scan = new Scanner(System.in);
    
    PersonManager personManager = new PersonManager();
    
    public Subject createSubject(List<Person> listPersons) {       
        System.out.print(ANSI_YELLOW + "\nInput name: " + ANSI_RESET);
        String subject_name = scan.nextLine();
        System.out.print(ANSI_YELLOW + "Input duration (hours): " + ANSI_RESET);
        String subject_duration = scan.nextLine();
        personManager.showList("Teacher", listPersons);
        while (true) {
        System.out.print(ANSI_YELLOW + "\nChoose teacher;s ID: " + ANSI_RESET);      
        String subject_teacher = scan.nextLine();    
            try {
                Subject subject = new Subject(subject_name, subject_duration, listPersons.get(Integer.parseInt(subject_teacher)));
                return subject; 
            } catch (Exception e) {
                System.out.println(ANSI_RED + " There is no teacher like that!" + ANSI_RESET);              
            }       
        }
    }
    
    public void addSubjectToList(Subject subject, List<Subject> listSubjects) {
        listSubjects.add(subject);
        SaveToFile saveToFile = new SaveToFile();
        saveToFile.saveToFile(listSubjects, "listSubjects");
    }
    
    public void showList(List<Subject> listSubjects) {
        int j = 1;
        System.out.println("");
        for (int i = 0; i < listSubjects.size(); i++) {
            if (listSubjects.get(i) != null) {
                System.out.println(ANSI_CYAN + j + ". " + (String)(listSubjects.get(i).toString()) + ANSI_RESET);
                j++;
            }
        }
    }
}   