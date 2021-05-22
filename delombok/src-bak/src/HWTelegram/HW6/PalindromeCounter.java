package HWTelegram.HW6;

public class PalindromeCounter {
    public int count(String phrase){
        String[] tempArr = phrase.toLowerCase().split(" ");
        int count = 0;
        for (String s : tempArr) {
            count = s.equals(new StringBuilder(s).reverse().toString()) ? ++count : count;
        }
        return count;
    }
}

class PalindromeCounterTest {
    public static void main(String[] args) {
        PalindromeCounter counter = new PalindromeCounter();

        //1
        System.out.println(counter.count("Level done!"));

        //0
        System.out.println(counter.count("No palindromes"));
    }
}