package HWTelegram.HW6;

public class DoubleSpaceCleaner {
    public String clean(String phrase){
        return phrase.replaceAll("[\\s]{2,}", " ").trim();
    }
}

class DoubleSpaceCleanerTest {
    public static void main(String[] args) {
        DoubleSpaceCleaner cleaner = new DoubleSpaceCleaner();

        //Hello World
        System.out.println(cleaner.clean("Hello World"));

        //Hello World
        System.out.println(cleaner.clean("       Hello              World          "));
    }
}