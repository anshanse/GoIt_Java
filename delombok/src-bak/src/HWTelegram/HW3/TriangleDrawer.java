package HWTelegram.HW3;

public class TriangleDrawer {
    public String drawTriangle(int side){
        int length=0, width=0;
        while (length<side){
            while (width<side){
                System.out.println("*".repeat(side-width));
                width++;
            }
            length++;
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new TriangleDrawer().drawTriangle(3));
    }
}
