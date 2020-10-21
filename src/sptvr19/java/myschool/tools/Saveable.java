package sptvr19.java.myschool.tools;

import java.util.List;

interface Saveable {
    public void saveToFile(List arrayList, String fileName);
    public List loadFromFile(String fileName);
}
