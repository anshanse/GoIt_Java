package HWTelegram.HW6;

import java.util.Arrays;

public class SensitiveDataSearcher {
    public boolean isSensitiveDataPresent(String phrase){
        String[] alarmWord = {"pass", "key", "login", "email"};
        for (String s : phrase.toLowerCase().split(" ")){
            for (int i = 0; i < alarmWord.length; i++) {
                if (s.contains(alarmWord[i])) return true;
            }
        }
        return false;
    }
}

class SensitiveDataSearcherTest {
    public static void main(String[] args) {
        SensitiveDataSearcher searcher = new SensitiveDataSearcher();

        //false
        System.out.println(searcher.isSensitiveDataPresent("Hello world"));

        //true
        System.out.println(searcher.isSensitiveDataPresent("Pass: swordfish"));
    }
}