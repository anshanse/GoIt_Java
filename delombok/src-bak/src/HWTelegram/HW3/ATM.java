package HWTelegram.HW3;

public class ATM {
    public int countBanknotes(int sum){
        int [] banknotes = {500,200,100,50,20,10,5,2,1};
        int numbers=0, i=0;
        while (sum!=0){
            if (sum >= banknotes[i]) {
                numbers = numbers + sum / banknotes[i];
                sum = sum - (sum / banknotes[i]) * banknotes[i];
            }
            i++;
        }
        return numbers;
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        System.out.println(atm.countBanknotes(1550));
    }

}
