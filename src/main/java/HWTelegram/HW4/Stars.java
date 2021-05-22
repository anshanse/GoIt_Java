package HWTelegram.HW4;

public class Stars {
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        // count/1000 + "X"+(count%1000)/100+"Y"+(count%100)/10+"Z"+(count/10)+"*"
        String result = "";
        for (int i = 0; i < count/1000; i++) {
                result +="X";
        }
        for (int i = 0; i < (count%1000)/100; i++) {
            result +="Y";
        }
        for (int i = 0; i < (count%100)/10; i++) {
            result +="Z";
        }
        for (int i = 0; i < (count%10); i++) {
            result +="*";
        }
        return result;
    }

    public static void main(String[] args) {
        Stars stars = new Stars();
        stars.setCount(153);
        System.out.println(stars);
        System.out.println(stars.getCount());
    }
}
