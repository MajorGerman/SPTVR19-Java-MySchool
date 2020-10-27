package sptvr19.java.myschool.tools;

import java.util.List;
import java.util.Scanner;
import sptvr19.java.myschool.entity.Person;

public class PersonManager {
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    
    Scanner scan = new Scanner(System.in);

    public Person createPerson(String role) {
        System.out.print(ANSI_YELLOW + "\nInput name: " + ANSI_RESET);
        String student_name = scan.nextLine();
        System.out.print(ANSI_YELLOW + "Input lastname: " + ANSI_RESET);
        String student_lastname = scan.nextLine();
        System.out.print(ANSI_YELLOW + "Input phone: " + ANSI_RESET);
        String student_phone = scan.nextLine();
        Person person = new Person(student_name, student_lastname, student_phone, role);
        return person;               
    }

    public void addPersonToList(Person student, List<Person> listPersons) {
        listPersons.add(student);
        SaveToFile saveToFile = new SaveToFile();
        saveToFile.saveToFile(listPersons, "listPersons");
    }
    
    public void showList(String role, List<Person> listPersons) {
        int j = 1;
        System.out.println("");
        for (int i = 0; i < listPersons.size(); i++) {
            if (listPersons.get(i).getRole().equals(role)) {
                System.out.println(ANSI_CYAN + j + ". " + (String)(listPersons.get(i).toString()) + "(ID: " + i + ")" + ANSI_RESET);
                j++;
            }
        }
    }
  
}