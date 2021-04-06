package CodeWars;

public class SquareDigit {

    public int squareDigits(int n) {
        // TODO Implement me
        String sb = String.valueOf(n);
        StringBuilder res = new StringBuilder();
        for (char c: sb.toCharArray()) {
            res.append(Character.getNumericValue(c)*Character.getNumericValue(c));
        }
        return Integer.valueOf(res.toString());
    }

}

//import org.junit.Test;
//import static org.junit.Assert.assertEquals;

class SquareDigitTest {
   //@Test
    //public void test() {
   public static void main(String[] args) {
        System.out.println(new SquareDigit().squareDigits(9119));
        System.out.println(new SquareDigit().squareDigits(0));
    }

}