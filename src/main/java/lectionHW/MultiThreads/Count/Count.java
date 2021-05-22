package lectionHW.MultiThreads.Count;

public class Count {
    private int num = 1;


    public int getNum() {
        return num;
    }

    public void Counter (int count, CheckCount check1, CheckCount check2) throws InterruptedException {

        synchronized (this){
            for (int i =0 ; i < count; i++) {
                //int chNum1 = check1.getCheckCount();
                //int  chNum2 = check2.getCheckCount();
                if (num == 1) System.out.print(num);
                else if ((num % check1.getCheckCount()) !=0 && (num % check2.getCheckCount()) !=0) {
                    System.out.print(", " + num);
                }
                else{
                    this.notify();
                    this.wait(1);
                }
                num++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        CheckCount checkCount1 = new CheckCount(3,"fizz", count);
        CheckCount checkCount2 = new CheckCount(5,"buzz", count);
        DoubleCheck doubleCheck = new DoubleCheck(checkCount1,checkCount2,count);
        Thread checkThread1 = new Thread(checkCount1);
        Thread checkThread2 = new Thread(checkCount2);
        Thread doubleThread = new Thread(doubleCheck);
        checkThread1.setDaemon(true);
        checkThread2.setDaemon(true);
        doubleThread.setDaemon(true);
        doubleThread.start();
        checkThread1.start();
        checkThread2.start();
        count.Counter(15, checkCount1, checkCount2);
    }
}
