//package day_5;
//
//import day_4.generic.PersonComparatorByField3;
//import day_4.task2Reflection.newClass;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class streams {
//
//    public static void main(String[] args) {
//
//        System.out.println(Arrays.asList(args));
//        List<newClass> list= new ArrayList<>(Arrays.asList(
//                new newClass("asdf",1199,88),
//                new newClass("55",2,888),
//                new newClass("sdfsdf",0,666)
//        ));
//
//        System.out.println(list);
//        List<String> resultList= list.stream().sorted(new PersonComparatorByField3())
//                .map(newClass::getField1).collect(Collectors.toList());
//        System.out.println(resultList);
//
//        List<String> resultList2= list.stream()
//                .sorted(Comparator.comparing(newClass::getField1))
//                .map(newClass::getField1).collect(Collectors.toList());
//        System.out.println(resultList2);
//    }
//}