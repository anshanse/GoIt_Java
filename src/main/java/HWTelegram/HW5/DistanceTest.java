package HWTelegram.HW5;

import static java.lang.Math.*;

class DistanceTest {
    public static void main(String[] args) {
        //Expect 14
        System.out.println(new Distance(10, 10, 20, 20).getDistance());

        //Expect 23
        System.out.println(new Distance(10, 10, 27, 25).getDistance());
    }
}
class Distance{
    private double startX, startY;
    private  double endX, endY;
    public Distance(int startX, int startY, int endX, int endY){
        this.startX = (double) startX;
        this.startY = (double) startY;
        this.endX = (double) endX;
        this.endY = (double) endY;
    }

    public int getDistance(){
        return (int) Math.round(Math.sqrt(Math.pow(this.endX-this.startX,2)+Math.pow(this.endY-this.startY,2)));
    }
}