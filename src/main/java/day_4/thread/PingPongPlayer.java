package task.day_3.thread;

public class PingPongPlayer extends Thread {

    final static int[] turnCount=new int[1];
    final static String[] ball=new String[1];

    public PingPongPlayer(String name) {
        super(name);
    }

    public void run() {
        System.out.println("player " + getName() + " ready");
        while(turnCount[0]<100){
            synchronized (ball){
            turn();}
        }
        }

    private void turn() {
        if(!getName().equals(ball[0])){
            ball[0]=getName();
        System.out.println("turn["+turnCount[0]+"] " + ball[0]);
        turnCount[0]++;}
    }


}