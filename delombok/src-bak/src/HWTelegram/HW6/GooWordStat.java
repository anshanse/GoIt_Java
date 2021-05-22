package HWTelegram.HW6;

public class GooWordStat {
    private final String word;
    private final int freq;

    public GooWordStat(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }

    public String getWord() {
        return word;
    }

    public int getFreq() {
        return freq;
    }

    @Override
    public String toString() {
        String freq = null;
        if (this.freq >= 0 && this.freq <1000) freq = "LOW";
        else if (this.freq >= 1000 && this.freq <100000) freq = "MEDIUM";
        else if (this.freq >= 100000 && this.freq <10000000) freq = "HIGH";
        else if (this.freq >= 10000000) freq = "EXTRA HIGH";
        return "Word is [" + word + "], search freq is " + freq;
    }
}

class GooWordStatTest {
    public static void main(String[] args) {
        //Word is [human], search freq is LOW
        System.out.println(new GooWordStat("human", 10));

        //Word is [mars], search freq is MEDIUM
        System.out.println(new GooWordStat("mars", 10000));

        //Word is [space], search freq is HIGH
        System.out.println(new GooWordStat("space", 9965499));

        //Word is [life], search freq is EXTRA HIGH
        System.out.println(new GooWordStat("life", 564785654));
    }
}