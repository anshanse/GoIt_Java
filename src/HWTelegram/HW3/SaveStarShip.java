package HWTelegram.HW3;

import java.util.*;

public class SaveStarShip {
    //Test output
    public int calculateDistance(int distance){
        return Math.abs(distance);
    }

    public String[] getPlanets(String galaxy){
        String [] planets = new String[0];
        if (galaxy.equals("Miaru")) {
                String [] planets1 = new String[3];
                planets1[0] = "Maux";
                planets1[1] = "Reux";
                planets1[2] = "Piax";
                return planets1;
            }
            else  if (galaxy.equals("Milkyway")) {
                String [] planets2 = new String[3];
                planets2[0] = "Earth";
                planets2[1] = "Mars";
                planets2[2] = "Jupiter";
                return planets2;
            }
            else if (galaxy.equals("DangerBanger")) {
                String [] planets3 = new String[2];
                planets3[0] = "Fobius";
                planets3[1] = "Demius";
                return planets3;
            }
            else {
            return planets;
        }
    }

    public String choosePlanet(long distanceToEarth){
        return distanceToEarth<45667 ? "Earth":"Pern";
    }

    public int calculateFuelPrice(String fuel, int count){
        int price;
        if (fuel.equals("STAR100")) price=70;
        else if (fuel.equals("STAR500")) price = 120;
        else if (fuel.equals("STAR1000")) price = 200;
        else price = 50;
        return (price*count);
    }

    public int roundSpeed(int speed){
        return (int) Math.round(speed/10.0)*10;
    }

    public int calculateNeededFuel(int distance){
        int fuel;
        if (distance < 20) fuel = 1000;
        else {
            fuel = 1000 + (distance - 20) *5;
        }
        return fuel;
    }

    public void calculateMaxPower(){
        Scanner scanner = new Scanner(System.in);
        int [] powers = new int[3];
        for (int i=0; i<3; i++) powers[i]=Integer.valueOf(scanner.next());
        int maxPowers=0;
        for (int i=0; i<3; i++){
            if (maxPowers < powers[i]) maxPowers = powers[i];
        }
        float maxPower;
        if (maxPowers < 10) maxPower = maxPowers*0.7f;
        else if (maxPowers>=10 && maxPowers <100) maxPower = maxPowers *1.2f;
        else maxPower = maxPowers*2.1f;
        System.out.println(maxPower);
    }

    public String getMyPrizes(int ticket){
        String prize="";
        if (ticket%10 == 0) {
            if (prize.equals("")) prize += "crystall";
            else prize += " crystall";
        }
        if (ticket%10 == 7){
            if (prize.equals("")) prize += "chip";
            else prize += " chip";
        }
        if (ticket > 200){
            if (prize.equals("")) prize += "coin";
            else prize += " coin";
        }
        return prize;
    }

    public boolean isHangarOk(int side1, int side2, int price){
        return ((side1*side2)>=1500 && ((float)side1/side2<=2.0 && (float)side2/side1<=2.0) && price/(side1*side2)<=1000);
    }

    public static void main(String[] args) {
        SaveStarShip ship = new SaveStarShip();

        //Should be 10
        //System.out.println(ship.calculateDistance(-10));

        //Should be [Fobius, Demius]
        //System.out.println(Arrays.toString(ship.getPlanets("DangerBanger")));

        //System.out.println(Arrays.toString(ship.getPlanets("Unknown")));
        //System.out.println(Arrays.toString(ship.getPlanets("DangerBanger")));

        //System.out.println(ship.choosePlanet(10));

        //Should be 700
        //System.out.println(ship.calculateFuelPrice("STAR7", 5));

        //Should be 60
        //System.out.println(ship.roundSpeed(55));

        //Should be 1005
        //System.out.println(ship.calculateNeededFuel(21));

        //Test stdin data - 1 3 5.
        //Console ouput should be 3.5
        //ship.calculateMaxPower();

        //Should be "crystall coin"
        //System.out.println(ship.getMyPrizes(337));

        //Should be true
        System.out.println(ship.isHangarOk(72, 157, 9484056));
    }
}
