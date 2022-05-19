package task.day_3.thread;

public class Main {

    public static void main(String[] args) {

        PingPongPlayer pingPongPlayer1=new PingPongPlayer("ping");
        PingPongPlayer pingPongPlayer2=new PingPongPlayer("pong");

        pingPongPlayer1.start();
        pingPongPlayer2.start();


    }
}