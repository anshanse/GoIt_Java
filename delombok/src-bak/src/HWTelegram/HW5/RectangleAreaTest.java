package HWTelegram.HW5;

import static java.lang.Math.*;

class RectangleAreaTest {
    public static void main(String[] args) {
        int[] coords = {2, 2, 12, 12};

        //Expect 100
        System.out.println(new RectangleArea(coords).getArea());
    }
}
class RectangleArea{
    private int startX, startY;
    private int endX, endY;
    public RectangleArea(int[] coords){
        this.startX = coords[0];
        this.startY = coords[1];
        this.endX = coords[2];
        this.endY = coords[3];
    }
    public int getArea(){
        return (abs(this.endX-this.startX))*abs((this.endY-this.startY));
    }
}
