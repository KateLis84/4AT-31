package day_3.exceptions;

public class DivByZero extends Exception{
    public DivByZero(String message){
        super("my DivByZero exception: " + message);
    }
}
