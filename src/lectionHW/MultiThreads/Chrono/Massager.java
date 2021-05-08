package lectionHW.MultiThreads.Chrono;

public class Massager extends Thread{
    private int checkTime;
    private Chronometer chron;

    public Massager(int checkTime, Chronometer chron) {
        this.checkTime = checkTime;
        this.chron = chron;
    }

    public int getCheckTime() {
        return checkTime;
    }

    @Override
    public void run() {
        synchronized (chron){
            if ((chron.time % checkTime) ==0) {
                System.out.println("Passed " + chron.time + " sec");
            }
            else System.out.println( "pass");
            chron.notify();
        }
    }
}
