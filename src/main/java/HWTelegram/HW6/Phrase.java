package HWTelegram.HW6;

import java.util.Arrays;

public class Phrase {
    private final String[] words;

    public Phrase(String[] words) {
        this.words = new String[words.length];
        for (int i =0; i< words.length; i++) {
            this.words[i] = words[i];
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (this.words.length == 0 ) result.append("zero");
        for (String s: this.words) {
            result.append(s + " ");
        }
        return result.toString();
    }
}

class PhraseTest {
    public static void main(String[] args) {
        String[] words = {"alpha", "beta", "gamma"};

        Phrase phrase = new Phrase(words);

        //alpha beta gamma
        System.out.println(phrase);

        words[0] = "zero";

        //alpha beta gamma
        System.out.println(phrase);
    }
}