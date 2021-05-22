package HWTelegram.HW6;

public class EmailDetector {
    public boolean isPresent(String text){
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '@' && text.charAt(i-1) != ' ' && text.charAt(i-2) != ' ' && text.charAt(i+1) != ' ' && text.charAt(i+2) != ' ') return true;
        }
        return false;

    }
}

class EmailDetectorTest {
    public static void main(String[] args) {
        //true
        System.out.println(new EmailDetector().isPresent("This email is no-reply@goo.com"));

        //false
        System.out.println(new EmailDetector().isPresent("No email present, but @ there"));
    }
}