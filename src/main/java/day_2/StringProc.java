package day_2;

public class StringProc {
    public static void main(String[] args) {
        //Task 2
        String words = "Hello world";
        System.out.println("Number of words: " + words.split(" ").length);

        //Task 3
        System.out.println("Lenght: " + "\t");
        for(String w:words.split(" ")){
            System.out.println(w.length()+"\t"+w);
        }
    }
}
