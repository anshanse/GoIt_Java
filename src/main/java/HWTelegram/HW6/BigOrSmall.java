package HWTelegram.HW6;

public class BigOrSmall {
    public String calculate(String text){
        int upCase = 0, downCase = 0;
        for ( char c: text.toCharArray()) {
            if (Character.isUpperCase(c)) upCase++;
            else downCase++;
        }
        if (upCase > downCase) return "Big";
        else if (downCase > upCase) return "Small";
        else return "Same";
    }
}

class BigOrSmallTest {
    public static void main(String[] args) {
        //Small
        System.out.println(new BigOrSmall().calculate("Java"));

        //Big
        System.out.println(new BigOrSmall().calculate("JAVA"));

        //Same
        System.out.println(new BigOrSmall().calculate("jAvA"));
    }
}