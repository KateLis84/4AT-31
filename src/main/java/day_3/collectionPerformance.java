package day_3;

import java.util.*;

public class collectionPerformance {
    public static void main(String[] args) {
        java.util.List<String> list1 = new ArrayList<>(List.of("Hell oworld and others"));
        java.util.List<String> linkedList = new LinkedList<>(list1);
        System.out.println(list1);
        System.out.println(linkedList);
        System.out.println("ArrayList: " + checkGet(list1));
        System.out.println("Linked List: " + checkGet(list1));
    }

    private static long checkGet(List<String> arrayList){
        long start = new Date().getTime();
        int size = arrayList.size();
        for(int i=0; i<1000; i++){
            int randIndex = new Random().nextInt(size);
            int wSize = arrayList.get(randIndex).length();
        }

        return new Date().getTime()-start;
    }
}
