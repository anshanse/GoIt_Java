package HWTelegram.HW3;

public class TrurlBank {

    public int sumQuads(int n){
        int count=0, sum=0;
        while (count<=n){
            sum+= count*count;
            count++;
        }
        return sum;
    }

    public int countSumOfDigits(int number){
        int sum=0;
        while (number!=0){
            sum += number%10;
            number /=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        TrurlBank bank = new TrurlBank();

        //Should be 14 - 1 + 4 + 9
        //System.out.println(bank.sumQuads(3));

        //Should be 16 - 5 + 4 + 7
        System.out.println(bank.countSumOfDigits(547));
    }
}
