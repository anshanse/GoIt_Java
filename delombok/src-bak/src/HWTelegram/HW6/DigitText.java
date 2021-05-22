package HWTelegram.HW6;

public class DigitText {
    public boolean detect(String text){
        if (!text.matches("[0-9\\s]*")) return false;
        return true;
    }
}

class DigitTextTest {
    public static void main(String[] args) {
        //true
        System.out.println(new DigitText().detect("23 50"));

        //false
        System.out.println(new DigitText().detect("Year 1990"));
    }
}