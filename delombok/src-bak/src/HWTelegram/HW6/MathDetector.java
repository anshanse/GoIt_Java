package HWTelegram.HW6;

public class MathDetector {
    public boolean isMath(String text){
        char [] charArr = text.toCharArray();
        for (char c : charArr ) {
            if (c == '=') return true;
            if (c == '+' | c == '-' | c == '*' | c == '/') return true;
        }
        return false;
    }
}

class MathDetectorTest {
    public static void main(String[] args) {
        //true
        System.out.println(new MathDetector().isMath("2+24"));
        System.out.println(new MathDetector().isMath("196163+528540=y"));

        //false
        System.out.println(new MathDetector().isMath("1992 is great year"));

        //false
        System.out.println(new MathDetector().isMath("Venus vs Earth"));
    }
}