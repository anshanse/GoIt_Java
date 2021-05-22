package HWTelegram.HW6;

import java.util.Arrays;

class WordSplitterTest {
    public static void main(String[] args) {
        WordSplitter wordSplitter = new WordSplitter();

        String[] words = wordSplitter.split("Hello      world");

        //[hello, world]
        System.out.println(Arrays.toString(words));
    }
}

public class WordSplitter {
    public String[] split(String phrase){
        int count = 0, j = 0;
        String [] tempArr = phrase.toLowerCase().split(" ");
        for (String s:tempArr) {
            count = s.equals("") ? count : ++count;
        }
        String [] result = new String[count];
        for (String s : tempArr) {
            if (!s.equals("")) {
                result[j++] = s;
            }
        }
        return result;
    }
}
