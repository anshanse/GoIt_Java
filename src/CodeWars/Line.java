package CodeWars;

public class Line {
    public static String Tickets(int[] peopleInLine)
    {
        //Your code is here...
        int change = 0;
        int count50 = 0, count100 = 0;
        int sum50 = 0, sum100 = 0;
        if (peopleInLine[0] != 25) return "NO";
        for (int i=0; i<peopleInLine.length; i++){
            if (peopleInLine[i] == 25) change += peopleInLine[i];
            if (peopleInLine[i] == 50) {
                sum50 += peopleInLine[i];
                count50++;
            }
            if (peopleInLine[i] == 100) {
                sum100 += peopleInLine[i];
                count100++;
            }
        }
        if (((sum50 - (25*count50))<change) && ((sum100 - (25*count100))-(sum50 - (25 * count50)) < change)) {
            return "YES";
        }
        else return "NO";
    }

    public static void main(String[] args) {
        System.out.println(Line.Tickets(new int[] {25, 25, 50}));
    }
}