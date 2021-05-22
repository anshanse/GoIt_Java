package lectionHW.Concurrent;

import lombok.SneakyThrows;

import java.util.concurrent.*;

public class Hydrogen implements Runnable {
    private CyclicBarrier hydroBarrier;
     private static int hydroCount;

    public Hydrogen(CyclicBarrier hydroBarrier) {
        this.hydroBarrier = hydroBarrier;
        //this.count = count;
    }


    public void releaseHydrogen() throws BrokenBarrierException, InterruptedException {
        hydroBarrier.await();
        if (hydroCount <= 2){

            System.out.print("H");
        }
        else{
            Thread.sleep(10);
            hydroCount=0;
        }
    }

    @Override
    public void run() {
        //while (true){
        try {
            releaseHydrogen();
        } catch (BrokenBarrierException e) {
            //e.printStackTrace();
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
        System.out.println();
        //}
    }
}
