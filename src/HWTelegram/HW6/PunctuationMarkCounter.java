package HWTelegram.HW6;

public class PunctuationMarkCounter {
    public int count(String phrase){
        int count = 0;
        //char[] tempArr = phrase.toCharArray();
        for (char c: phrase.toCharArray()) {
            if (c == '.' || c == ',' || c == '!' || c == ':' || c == ';') count++;
        }
        return count;
    }
}

class PunctuationMarkCounterTest {
    public static void main(String[] args) {
        PunctuationMarkCounter counter = new PunctuationMarkCounter();

        //2
        System.out.println(counter.count("Hello, world!"));

        //1
        System.out.println(counter.count("This is Sparta!"));

        //1
        System.out.println(counter.count("End."));
    }
}