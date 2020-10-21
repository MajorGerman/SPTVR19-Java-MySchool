package sptvr19.java.myschool;

import sptvr19.java.myschool.entity.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import sptvr19.java.myschool.tools.PersonManager;
import sptvr19.java.myschool.tools.SubjectManager;
import sptvr19.java.myschool.tools.SaveToFile;


class App {    
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    
    Scanner scan = new Scanner(System.in);
    
    List<Person> listPersons = new ArrayList<>();
    PersonManager personManager = new PersonManager(); 
    
    List<Subject> listSubjects = new ArrayList<>();
    SubjectManager subjectManager = new SubjectManager();  
    
    public App() {
        SaveToFile saveToFile = new SaveToFile();
        this.listPersons = saveToFile.loadFromFile("listPersons");
        this.listSubjects = saveToFile.loadFromFile("listSubjects");
    }
    
    public void run() {
        
        System.out.println(ANSI_PURPLE + "   ~~~ MySchool ~~~" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "~~~ by Georg Laabe ~~~" + ANSI_RESET);
        
        boolean work = true;
        
        while(work) {
        
            System.out.println(ANSI_YELLOW + "\n[ Functions ]" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + " 1. Add Student" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + " 2. Student List" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + " 3. Add Teacher" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + " 4. Teacher List" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + " 5. Add Subject" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + " 6. Subject List" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + " 7. Add Mark" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + " 8. Change Mark" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + " 8. Mark List for Student" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + " 9. Mark List for Subject" + ANSI_RESET);   
            System.out.println(ANSI_YELLOW + " 10. Exit" + ANSI_RESET);
                        
            System.out.print(ANSI_YELLOW + "\n> Choose function: " + ANSI_RESET);  
            int function = scan.nextInt();
            
            switch(function) {              
                case 1:
                    System.out.println(ANSI_YELLOW + "\n[ Functions -> Add Student ]" + ANSI_RESET);
                    
                    Person student = personManager.createPerson("Student");                          
                    personManager.addPersonToList(student, listPersons);
                    
                    System.out.println(ANSI_GREEN + "Student has been added successfully!" + ANSI_RESET);
                    System.out.println(ANSI_YELLOW + "--------------------------------" + ANSI_RESET);
                    
                    break;
                case 2:
                    System.out.println(ANSI_YELLOW + "\n[ Functions -> Student List ]" + ANSI_RESET);
                    
                    personManager.showList("Student", listPersons);
                    System.out.println(ANSI_YELLOW + "--------------------------------" + ANSI_RESET);
                    
                    break;
                case 3:
                    System.out.println(ANSI_YELLOW + "\n[ Functions -> Add Teacher ]" + ANSI_RESET);
                    
                    Person teacher = personManager.createPerson("Teacher");                          
                    personManager.addPersonToList(teacher, listPersons);
                    
                    System.out.println(ANSI_GREEN + "Teacher has been added successfully!" + ANSI_RESET);
                    System.out.println(ANSI_YELLOW + "--------------------------------" + ANSI_RESET);
                    
                    break;
                case 4:
                    System.out.println(ANSI_YELLOW + "\n[ Functions -> Teacher List ]" + ANSI_RESET);
                    
                    personManager.showList("Teacher", listPersons);
                    System.out.println(ANSI_YELLOW + "--------------------------------" + ANSI_RESET);
                    
                    break;
                case 5:
                    System.out.println(ANSI_YELLOW + "\n[ Functions -> Add Subject ]" + ANSI_RESET);                  
                    
                    Subject subject = subjectManager.createSubject(listPersons);  
                    
                    System.out.println(ANSI_GREEN + "Subject has been added successfully!" + ANSI_RESET);
                    

                    System.out.println(ANSI_YELLOW + "--------------------------------" + ANSI_RESET);
                    
                    break;                    
                case 6:
                    System.out.println(ANSI_YELLOW + "\n[ Functions -> Subject List ]" + ANSI_RESET);
                    
                    subjectManager.showList(listSubjects);
                    System.out.println(ANSI_YELLOW + "--------------------------------" + ANSI_RESET);
                    
                    break;
                case 7:
                    
                    break;
                case 8:
                    
                    break;
                case 9:
                    
                    break;
                case 10:
                    work = false;
                    break;
                default:
                    System.out.println(ANSI_RED + "There is no function like that!" + ANSI_RESET);
                    System.out.println(ANSI_YELLOW + "--------------------------------" + ANSI_RESET);
                    break;                
            }         
        }             
    } 
}
