package HWTelegram.HW6;

import java.util.Arrays;

public class DigitExtracter {
    public int[] extract(String text){
        StringBuilder tempInt = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) tempInt.append(text.charAt(i)).append(" ");
        }
        int [] result = new int[tempInt.toString().split(" ").length];
        int i=0;
        for (String s: tempInt.toString().split(" ")) {
            result[i] = Integer.valueOf(s);
            i++;
        }
        return result;
    }
}

class DigitExtracterTest {
    public static void main(String[] args) {
        DigitExtracter digitExtracter = new DigitExtracter();

        int[] extracted = digitExtracter.extract("april 5, year 2000");

        //[5, 2, 0, 0, 0]
        System.out.println(Arrays.toString(extracted));
    }
}