package HWTelegram.HW3;

import java.util.Arrays;

public class HarekDataMaker {
    public String aggregateSingle(String name, String age, String planet){
        return ("name - " + name + ", age - " + age + ", planet - " + planet);
    }

    public String[] aggregateAll(String[] names, int[] ages, String[] planets){
        String [] result =new String [names.length];
        result[0] = aggregateSingle(names[0], Integer.toString(ages[0]), planets[0]);
        result[1] = aggregateSingle(names[1], Integer.toString(ages[1]), planets[1]);
        result[2] = aggregateSingle(names[2], Integer.toString(ages[2]), planets[2]);
        return result;
    }

    public static void main(String[] args) {
        String[] names = new String[] {"hter", "pou", "diz"};
        int[] ages = new int[] {30, 35, 70};
        String[] planets = new String[] {"Mars", "Earth", "Jupiter"};

        HarekDataMaker harekDataMaker = new HarekDataMaker();

        System.out.println(harekDataMaker.aggregateSingle(names[0], Integer.toString(ages[0]), planets[0]));
        System.out.println("###");

        System.out.println(Arrays.toString(harekDataMaker.aggregateAll(names, ages, planets)));
    }
}
