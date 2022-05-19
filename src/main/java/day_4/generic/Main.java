package day_4.generic;

import day_4.task2Reflection.newClass;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Make two different comparators for your Custom class
        // (simple java class with few fields).
        // End users should be able to use ‘min’, ‘max’, ‘sotr’ methods
        // with that comparators.

        List<newClass> list = new ArrayList<>(Arrays.asList(
                new newClass("some1", 123),
                new newClass("etg", 28),
                new newClass("fgjm", 321),
                new newClass("fhu76", 2)
        ));
        System.out.println(list);
        System.out.println(max(list, new PersonComparatorByField2()));
        System.out.println(min(list, new PersonComparatorByField2()));
        sort(list, new PersonComparatorByField2());
        System.out.println(list);
    }

    private static void sort(List<newClass> list, PersonComparatorByField2 personComparatorByField2) {
        Collections.sort(list, personComparatorByField2);
    }

    private static newClass min(List<newClass> list, PersonComparatorByField2 personComparatorByField2) {
        return Collections.min(list, personComparatorByField2);
    }

    private static newClass max(List<newClass> list, Comparator personComparatorByField2) {
        return Collections.max(list, personComparatorByField2);
    }
}