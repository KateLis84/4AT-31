package day_3;

import java.util.ArrayList;
import java.util.HashSet;

public class MainCollection {
    public static void main(String[] args) {
        Integer e1=1;
        Integer e2=9;
        java.util.List<Integer> collection1 = new ArrayList<>(java.util.Arrays.asList(1, 6, 3, 3, 4, 5, 5, 6, 0));
        System.out.println("Task 1");
        System.out.println(collection1);
        int halfIndex = collection1.size()/2;
        for(int i = 0; i<halfIndex; i++){
            if(collection1.get(i).equals(e1)){
                collection1.set(i, e2);
            }
        }
        System.out.println(collection1);


        //Task 2 a and b
        java.util.List<java.util.List<Integer>> collection_2 = new ArrayList<>(java.util.Arrays.asList(
                    java.util.Arrays.asList(1, 6, 1, 3),
                    java.util.Arrays.asList(1, 3, 4, 4),
                    java.util.Arrays.asList(2, 6, 1, 3),
                    java.util.Arrays.asList(2, 6, 1, 0)));

        for(int i=0; i<collection_2.size(); i++){
            System.out.println();
            for(int j=0;j<collection_2.get(0).size(); j++){
                System.out.println(collection_2.get(i).get(j)+"\t");
            }
        }
        System.out.println();
        java.util.Set<Integer> uniqueElements = new HashSet<>();
        for(int i=0; i<collection_2.size(); i++){
            for(int j=0;j<collection_2.get(0).size(); j++){
                if(uniqueElements.contains(collection_2.get(i).get(j))){
                    collection_2.get(i).set(j, 0);
                } else{
                    uniqueElements.add(collection_2.get(i).get(j));
                }
                System.out.println(collection_2.get(j).get(i)+"\t");
            }
        }
        System.out.println();

    }
}
