package HWTelegram.HW6;

import java.util.Locale;

public class WordFreqCounter {
    public float countFreq(String phrase, String word){
        String[] tempArr = phrase.toLowerCase().split(" ");
        float count = 0;
        for (String s: tempArr) {
            count = s.equals(word.toLowerCase()) ? ++count : count;
        }
        return count/tempArr.length;
    }

}

class WordFreqCounterTest {
    public static void main(String[] args) {
        WordFreqCounter freqCounter = new WordFreqCounter();

        //0.5
        System.out.println(freqCounter.countFreq("Hello Java", "java"));

        //0
        System.out.println(freqCounter.countFreq("Hello World", "java"));
    }
}
