package day_3.exceptions;

import day_2.Calc;

public class MainException {
    public static void main(String[] args) {
        System.out.println("a/b" + Calc.devide(5, 0));
    }
}
