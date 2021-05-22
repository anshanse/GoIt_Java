package HWTelegram.HW6;

public class WaterCounter {
    public double count(String text){
        return (double) (text.length()-text.replace(" ", "").length())/text.length();
    }
}

class WaterCounterTest {
    public static void main(String[] args) {
        //0.07692307692307693
        System.out.println(new WaterCounter().count("Moon invaders"));

        //0
        System.out.println(new WaterCounter().count("NoWater"));
    }
}