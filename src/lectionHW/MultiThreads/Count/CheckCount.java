package lectionHW.MultiThreads.Count;

import java.util.ArrayList;
import java.util.List;

public class CheckCount implements Runnable{
    private final int checkCount;
    private final Count count;
    private final String msg;
    private boolean isSent;
    private static List<Integer> chkNumber = new ArrayList<>(2);

    public CheckCount(int checkCount, String msg, Count count) {
        this.checkCount = checkCount;
        this.msg = msg;
        this.count = count;
        chkNumber.add(checkCount);
    }

    public int getCheckCount() {
        return checkCount;
    }

    public boolean ChekNumber(){
        return ((count.getNum() % checkCount) == 0 );
    }

    @Override
    public void run() {
        while (true) {
            //isSent = false;
            synchronized (count) {
                try {

                    if (this.ChekNumber() & ((count.getNum() % chkNumber.get(0) == 0) ^ (count.getNum() % chkNumber.get(1) == 0)) ) {
                        System.out.print(", " + msg);
                        count.wait();
                        isSent = true;
                    }
                } catch (InterruptedException e) {
                    //
                }
                //isSent = false;
            }
        }
    }
}

class DoubleCheck implements Runnable{
    private final CheckCount check1;
    private final CheckCount check2;
    private final Count count;

    public DoubleCheck(CheckCount check1, CheckCount check2, Count count) {
        this.check1 = check1;
        this.check2 = check2;
        this.count = count;
    }

    public boolean isDoubleCheck(){
        return check1.ChekNumber() && check2.ChekNumber();
    }

    @Override
    public void run() {
        while (true){
            synchronized (count){
                if (isDoubleCheck()){
                    System.out.print(", fizzbuzz");
                    try {
                        count.wait();
                    } catch (InterruptedException e) {
                        //
                    }
                }
            }
        }
    }
}
