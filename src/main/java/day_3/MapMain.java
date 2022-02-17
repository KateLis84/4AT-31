package day_3;

import java.util.Arrays;

public class MapMain {
    //Task
    public static void main(String[] args) {
        String inputString = "Hello World!!! Today is great day. I think";
        java.util.Map<String, Integer> result = new java.util.HashMap<>();
        Arrays.stream(inputString.split(" ")).forEach(w->{
            String key = String.valueOf(w.charAt(0));
            result.putIfAbsent(key, 1);
            result.put(key, result.get(key)+1);
        });
        System.out.println(result);
    }
}
