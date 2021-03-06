package day_2;

import day_3.exceptions.DivByZero;

public class Calc {
    public static void main(String[] args){
        double a = -2.666;
        double b = 10;

        System.out.println("a+b=" + add(a, b));
        System.out.println("a-b=" + minus(a, b));
        System.out.println("a*b=" + mult(a, b));
        System.out.println("a/b=" + devide(a, b));
    }

    public static Double add(double a, double b){
        return a+b;
    }

    public static double minus(double a, double b){
        return a-b;
    }

    public static double mult(double a, double b){
        return a*b;
    }

    public static Double devide(double a, double b){
        if(b==0) try {
            throw new DivByZero("Invalid" + b);
        } catch (DivByZero e) {
            e.printStackTrace();
        }
        return a/b;
    }

}
