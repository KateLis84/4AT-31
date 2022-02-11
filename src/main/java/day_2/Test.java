package day_2;

public class Test {
    public static void main(String[] args){
        double a = -2.666;
        double b = 10;

        System.out.println("a+b=" + add(a, b));
        System.out.println("a-b=" + minus(a, b));
        System.out.println("a*b=" + mult(a, b));
        System.out.println("a/b=" + devide(a, b));
    }

    public static double add(double a, double b){
        return a+b;
    }

    public static double minus(double a, double b){
        return a-b;
    }

    public static double mult(double a, double b){
        return a*b;
    }

    public static double devide(double a, double b){
        return a/b;
    }

}
