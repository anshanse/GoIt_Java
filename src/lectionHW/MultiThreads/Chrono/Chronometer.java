package lectionHW.MultiThreads.Chrono;

public class Chronometer {
    public int time =0;


    public void timeCount(Messager msg, int period) throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < period; i++) {
                Thread.sleep(500);
                time++;
                if (time == period) msg.setStop(true);
                if ((time % msg.getCheckTime()) !=0) {
                    System.out.println(time);
                    Thread.sleep(500);
                }

                else {
                    this.notify();
                    this.wait(500);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Chronometer chronometer = new Chronometer();
        Messager msg = new Messager(5, chronometer);
        new Thread(msg).start();
        chronometer.timeCount(msg, 10);
    }
}
