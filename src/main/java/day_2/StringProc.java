package day_2;

public class StringProc {
    public static void main(String[] args) {
        //Task 2
        String words = "Some random text in which I have some words :)";
        System.out.println("Number of words: " + words.split(" ").length);
        String[] array = words.split(" ");
        //Task 3
        System.out.println("Lenght of each word: " + "\t");
        for(String w:array){
            System.out.println(w.length()+"\t"+w);
        }

        //Task 4
        System.out.println("Length of word \"random\": "+wordCount(array, 18));
    }

    private static int wordCount(String[] words, int i) {
        if(words.length<(i+1)){
            throw new RuntimeException("invalid index! Your index is "+i+
                    " However it must be from 0 to " + (words.length-1));
        }
        return words[i].length();
    }
}
