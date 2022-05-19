package day_4.generic;
import day_4.task2Reflection.newClass;
import java.util.Comparator;


public class PersonComparatorByField2 implements Comparator<newClass> {
    public int compare(newClass o1, newClass o2) {
        return o1.getField2().compareTo(o2.getField2());
    }
}