package HWTelegram.HW3;

public class CaptainDisputeAgain {
    public static int findMin(int[] triple){
        int max= triple[0];
        for (int i = 0; i < triple.length; i++) {
            max = triple[i]<max ? triple[i]:max ;
        }
        return max;
    }

    public static void main(String[] args) {
        CaptainDispute disp = new CaptainDispute();
        System.out.println(findMin(new int[] {1, 10, 3}));
    }
}
