package CodeWars;

//import org.junit.Test;
//import static org.junit.Assert.assertEquals;
//import org.junit.runners.JUnit4;
import java.util.Arrays;

// TODO: Replace examples and use TDD development by writing your own tests

class SampleTest {
    //@Test
    public void testEvenString() {
        String s = "abcdef";
        String s1 = "HelloWorld";
        Arrays.toString(StringSplit.solution(s));
        Arrays.toString(StringSplit.solution(s1));
    }

    //@Test
    //public void testOddString() {
    public static void main(String[] args) {
        String s = "abcdef";
        String s1 = "LovePizza";
        String s2 = "Hello Wold!";
        System.out.println(Arrays.toString(StringSplit.solution(s)));
        System.out.println(Arrays.toString(StringSplit.solution(s1)));
        System.out.println(Arrays.toString(StringSplit.solution(s2)));
    }
}

public class StringSplit {
    public static String[] solution(String s) {
        //Write your code here
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            //if (s.charAt(i) == ',') sb.append("++");
            if ((i%2 ==0) && i != s.length()-1){
                sb.append(s.charAt(i));
            }
            else if (i%2 !=0 && i != s.length()-1){
                sb.append(s.charAt(i)).append("++");
            }else if (i%2 ==0 && i == s.length()-1){
                sb.append(s.charAt(i)).append("_");
            }
            else sb.append(s.charAt(i));
        }
        return sb.toString().split("[+]{2}");
    }
}
