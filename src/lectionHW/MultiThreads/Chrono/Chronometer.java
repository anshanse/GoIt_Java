package lectionHW.MultiThreads.Chrono;

public class Chronometer {
    public int time =0;

    public void timeCount(Massager msg) throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < 15; i++) {
                Thread.sleep(1);
                time++;
                if ((time % msg.getCheckTime()) !=0) {
                    System.out.println(time);
                }
                else this.wait();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Chronometer chronometer = new Chronometer();
        Massager msg = new Massager(5, chronometer);
        msg.start();
        chronometer.timeCount(msg);
    }
}
