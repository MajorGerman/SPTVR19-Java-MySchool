package sptvr19.java.myschool.tools;

import java.util.List;
import java.util.Scanner;
import sptvr19.java.myschool.entity.Person;

public class PersonManager {
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    
    Scanner scan = new Scanner(System.in);

    public Person createPerson(String role) {
        String name;
        String lastname;
        String phone;
        
        while (true) {
            System.out.print(ANSI_YELLOW + "\nInput name: " + ANSI_RESET);
            name = scan.nextLine();
            if (name.length() > 0 && name.length() < 41 && !name.matches(" (.*)")) {
                break;
            }
            System.out.println(ANSI_RED + "Incorrect name!" + ANSI_RESET);
        }
        
        while (true) {
            System.out.print(ANSI_YELLOW + "Input lastname: " + ANSI_RESET);
            lastname = scan.nextLine();
            if (lastname.length() > 0  && lastname.length() < 41 && !lastname.matches(" (.*)")) {
                break;
            }
            System.out.println(ANSI_RED + "Incorrect lastname!" + ANSI_RESET);
        }
        
        while (true) {
            System.out.print(ANSI_YELLOW + "Input phone number: " + ANSI_RESET);
            phone = scan.nextLine();
            if (phone.length() > 4  && phone.length() < 41 && !phone.matches(" (.*)")) {
                break;
            }
            System.out.println(ANSI_RED + "Incorrect phone number!" + ANSI_RESET);
        }
        
        Person person = new Person(name, lastname, phone, role);
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