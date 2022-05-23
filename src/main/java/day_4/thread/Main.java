package day_4.thread;

public class Main {

    public static void main(String[] args) {

        day_4.thread.PingPongPlayer pingPongPlayer1=new day_4.thread.PingPongPlayer("ping");
        day_4.thread.PingPongPlayer pingPongPlayer2=new day_4.thread.PingPongPlayer("pong");

        pingPongPlayer1.start();
        pingPongPlayer2.start();


    }
}