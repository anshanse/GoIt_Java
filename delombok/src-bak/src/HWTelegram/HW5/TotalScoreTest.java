package HWTelegram.HW5;

public class TotalScoreTest {
    public static void main(String[] args) {
        int[] score = {10, 20, 100};

        //130
        System.out.println(new TotalScore().sum(score));
    }
}
class TotalScore {
    public int sum(int[] scores) {
        int result = 0;
        int index = 0;

        while(index<scores.length) {
            result += scores[index++];
        }
        return result;
    }
}