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

    public static void main(String[] args) {
        SaveStarShip ship = new SaveStarShip();

        //Should be 10
        //System.out.println(ship.calculateDistance(-10));

        //Should be [Fobius, Demius]
        //System.out.println(Arrays.toString(ship.getPlanets("DangerBanger")));

        System.out.println(Arrays.toString(ship.getPlanets("Unknown")));
        System.out.println(Arrays.toString(ship.getPlanets("DangerBanger")));
    }
}
