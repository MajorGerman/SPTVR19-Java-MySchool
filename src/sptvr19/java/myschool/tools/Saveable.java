package sptvr19.java.myschool.tools;

import java.util.List;
import sptvr19.java.myschool.entity.Journal;
import sptvr19.java.myschool.entity.Person;
import sptvr19.java.myschool.entity.Subject;

interface Saveable {
    public void savePersonToFile(List<Person> arrayList);
    public void saveSubjectToFile(List<Subject> arrayList);    
    public void saveJournalToFile(List<Journal> arrayList);
    public List loadPersonFromFile();
    public List loadSubjectFromFile() ;
    public List loadJournalFromFile() ;
}
