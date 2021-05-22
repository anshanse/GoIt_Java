package HWTelegram.HW6;

import java.util.Locale;

public class WordCombine {
    public boolean canCombine(String sourceWord, String targetWord){
        int count = 0;
        for (String s : targetWord.toLowerCase().split("")) {
            if (sourceWord.toLowerCase().contains(s)) count++;
        }
        if (count == targetWord.length()) return true;
        return false;
    }
}

class WordCombineTest {
    public static void main(String[] args) {
        //true
        System.out.println(new WordCombine().canCombine("Forest", "tor"));

        //true
        System.out.println(new WordCombine().canCombine("Magic", "Mama"));

        //false
        System.out.println(new WordCombine().canCombine("War", "Piece"));
    }
}