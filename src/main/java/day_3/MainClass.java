package day_3;

public class MainClass {
    //Task 1
    public static void main(String[] args){
        double[] array = {5, 9, 3, 2, 0, -4, -8.3, 3, -4};
        double max = array[0];
        for(double e:array){
            if(e>max){
                max=e;
            }
        }
        System.out.println("max: " + max);


        //Task 2
        int[] array_2 = {1, 6, 3, 3, 4, 5, 5, 6, 0};
        int[] result_2 = new int[array_2.length];
        int i=0;
        for(int e:array_2){
            if(!contains(result_2, e)){
                result_2[i++]=e;
            }
        }

        java.util.Arrays.sort(result_2);
        java.util.Arrays.stream(result_2).forEach(System.out::println);


        //Task 3
        String[] array_3 = {"12","23", "34", "12", "56", "67"};
        for(int i3=0; i3<array_3.length; i3++){
            if(array_3[i3].equals("12")){
                array_3[i3] = "replaced";
            }
        }

        System.out.println("Task 3:");
        java.util.Arrays.stream(array_3).forEach(System.out::println);

        //Task 4
        String[] array_4 = {"12", "23", "34", "12", "56", "67"};
        String[] res_4 = new String[array_4.length];
        for(int i4=0; i4<array_4.length; i4++){
            res_4[(res_4.length-i4)-1]=array_4[i4];
        }

        System.out.println("Task 4");
        java.util.Arrays.stream(res_4).forEach(System.out::println);
    }

    private static boolean contains(int[] array, int test_element){
        for(int e:array){
            if(test_element==e){
                return true;
            }
        }
        return false;
    }
}
