package HWTelegram.HW6;

public class AvgWordLength {
    public double count(String phrase){
        double result = 0;
        for (String s:phrase.split(" ")) {
            result += s.length();
        }
        return (result/phrase.split(" ").length);
    }
}

class AvgWordLengthTest {
    public static void main(String[] args) {
        //6
        System.out.println(new AvgWordLength().count("Launch Rocket"));

        //4.5
        System.out.println(new AvgWordLength().count("Life is strange thing"));
    }
}