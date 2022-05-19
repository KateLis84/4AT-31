package day_4.task2Reflection;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        newClass myClass = new newClass("some", 1234);

        System.out.println(get(myClass, "field1"));
        System.out.println(set(myClass, "field1", "another"));
        System.out.println(clear(myClass, "field1"));
    }

    private static Object clear(Object object, String fieldName) {
        Class thisClass = object.getClass();
        try {
            Field cl = thisClass.getDeclaredField(fieldName);
            cl.setAccessible(true);
            cl.set(object, "");
            return cl.get(object);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Object set(Object object, String fieldName, String text) {
        Class thisClass = object.getClass();
        try {
            Field cl = thisClass.getDeclaredField(fieldName);
            cl.setAccessible(true);
            cl.set(object, text);
            return cl.get(object);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Object get(Object object, String fieldName) {
        Class thisClass = object.getClass();
        try {
            Field cl = thisClass.getDeclaredField(fieldName);
            cl.setAccessible(true);
            return cl.get(object);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}