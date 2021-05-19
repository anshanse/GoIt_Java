package lectionHW.Concurrent;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class H2OProducer {
    static final int H2O_COUNT = 20;
    static final Random rand = new Random();

    static final Lock lock = new ReentrantLock(true);
    static final Condition oxyWait = lock.newCondition();
    static final Condition hydroWait = lock.newCondition();

    static volatile int hydCount = 0;

    public static void main(String[] args) {
        try {
            Thread h1 = new Thread(() -> {
                try {
                    releaseHydrogen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Thread h2 = new Thread(() -> {
                try {
                    releaseHydrogen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Thread o = new Thread(() -> {
                try {
                    releaseOxygen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            h1.setName("hydrogen-1");
            h2.setName("hydrogen-2");
            o.setName("oxygen");

            h1.start();
            h2.start();
            o.start();

            try {
                h1.join();
                h2.join();
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
        }

    }

    public static void releaseHydrogen() throws InterruptedException {
        for (int i = 0; i < H2O_COUNT; i++) {
            lock.lock();
            try {
                while (hydCount == 2) {
                    hydroWait.await();
                }

                hydCount++;
                System.out.print("H");

                if (hydCount == 2) {
                    oxyWait.signalAll();
                }
            } finally {
                lock.unlock();
            }

            randomSleep();
        }
    }

    public static void releaseOxygen() throws InterruptedException {
        for (int i = 0; i < H2O_COUNT; i++) {
            lock.lock();
            try {
                while (hydCount < 2) {
                    oxyWait.await();
                }

                hydCount = 0;
                System.out.println("O");
                System.out.println("");
                hydroWait.signalAll();
            } finally {
                lock.unlock();
            }

            randomSleep();
        }
    }

    public static void randomSleep() {
        int ms = rand.nextInt(500);
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
        }
    }
}