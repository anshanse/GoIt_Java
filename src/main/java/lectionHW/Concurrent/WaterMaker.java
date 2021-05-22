package lectionHW.Concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class WaterMaker {
    private final static CyclicBarrier oxyBarrier = new CyclicBarrier(1);
    private final static CyclicBarrier hydroBarrier = new CyclicBarrier(2);
    private final int MOL_COUNT = 10;

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new Thread(new Hydrogen(hydroBarrier)).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(new Oxygen(oxyBarrier)).start();
        }
    }
}
