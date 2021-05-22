package lectionHW.MultiThreads.Chrono;

public class Messager implements Runnable {
    private final int checkTime;
    private final Chronometer chron;
    private boolean isStop = false;

    public Messager(int checkTime, Chronometer chron) {
        this.checkTime = checkTime;
        this.chron = chron;
    }

    public int getCheckTime() {
        return checkTime;
    }

    public void setStop(boolean stop) {
        isStop = stop;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (chron) {
                try {
                    if ((chron.time % checkTime) == 0) {
                        System.out.println("Passed " + chron.time + " sec");
                        chron.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (isStop) return;
            }

        }
    }
}
