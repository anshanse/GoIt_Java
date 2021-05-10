package lectionHW.MultiThreads.Chrono;

public class Chronometer {
    public int time =0;


    public void timeCount(Messager msg, int period) throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < period; i++) {
                Thread.sleep(500);
                time++;
                    System.out.println(time);
                    Thread.sleep(500);
                    this.notify();
                    this.wait(500);
                if (time == period-1) {
                    msg.setStop(true);
                    this.notify();
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
