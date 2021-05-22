package lectionHW.Concurrent;

import lombok.SneakyThrows;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Oxygen implements Runnable {
    //private final Semaphore oxySemaphore;
    private CyclicBarrier oxyBarrier;
    private static int oxyCount;
    //private final Lock lock = new ReentrantLock();

    public Oxygen(CyclicBarrier oxyBarrier) {
        this.oxyBarrier = oxyBarrier;
        //this.oxySemaphore = oxySemaphore;
        //this.count = count;
    }

    public void releaseOxygen() throws BrokenBarrierException, InterruptedException {
        oxyBarrier.await();
        if (oxyBarrier.getNumberWaiting() <= 1) {

            System.out.print("0");
        }
        else {
            Thread.sleep(10);
            oxyCount = 0;
        }
    }


    @Override
    public void run() {
        //while (true){
        try {
            releaseOxygen();
        } catch (BrokenBarrierException e) {
            //e.printStackTrace();
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
        //}

    }
}
