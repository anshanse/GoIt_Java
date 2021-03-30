package HWTelegram.HW6;

public class NameCounter {
    public int count(String text){
        int countNames=0;
        if (text.length()<3) return 0;
        String [] tempArr = text.split(" ");
        for (String s: tempArr) {
            int count = 0;
            if (Character.isUpperCase(s.charAt(0))){
                for (int i = 1; i < s.length() ; i++) {
                    if (Character.isLowerCase(s.charAt(i))) count++;
                }
                if (count == s.length()-1) countNames++;
            }
        }
        return countNames;
    }
}

class NameCounterTest {
    public static void main(String[] args) {
        //1
        System.out.println(new NameCounter().count("Mars is great planet"));

        //2
        System.out.println(new NameCounter().count("Moon is near Earth"));

        //0
        System.out.println(new NameCounter().count("SPACE IS GREAT"));
    }
}