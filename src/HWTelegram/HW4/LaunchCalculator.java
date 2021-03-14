package HWTelegram.HW4;

class LaunchCalculator {
    public int calculateTotalPrice(Spaceport spaceport, int passengerCount) {
        return spaceport.calculateTotalPrice(passengerCount);
    }

    public static void main(String[] args) {
        LaunchCalculator calculator = new LaunchCalculator();

        int jupiterStarPrice = calculator.calculateTotalPrice(new JupiterStar(), 100);
        System.out.println("JupiterStar price = " + jupiterStarPrice); //700

        int mercuryBeatPrice = calculator.calculateTotalPrice(new MercuryBeat(), 100);
        System.out.println("MercuryBeat price = " + mercuryBeatPrice); //1500

        int sunHeavenPrice = calculator.calculateTotalPrice(new SunHeaven(), 100);
        System.out.println("SunHeaven price = " + sunHeavenPrice); //2000
    }
}

abstract class Spaceport {
    public abstract int calculateTotalPrice(int passengerCount);
}

class JupiterStar extends Spaceport{

    private final int rateAll = 500;
    private final int rateOne = 2;

    @Override
    public int calculateTotalPrice(int passengerCount) {
        return rateAll+passengerCount*rateOne;
    }
}

class MercuryBeat extends Spaceport{

    final int rateAll = 0;
    final int rateOne = 15;

    @Override
    public int calculateTotalPrice(int passengerCount) {
        return rateAll+passengerCount*rateOne;
    }
}

class SunHeaven extends Spaceport{

     int rateAll = 2000;
     int rateOne = 0;

    @Override
    public int calculateTotalPrice(int passengerCount) {
        return rateAll+passengerCount*rateOne;
    }
}