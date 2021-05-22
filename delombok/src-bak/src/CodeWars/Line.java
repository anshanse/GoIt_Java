package CodeWars;

public class Line {
    public static String Tickets(int[] peopleInLine)
    {
        //Your code is here...
        int count25 = 0;
        int count50 = 0, count100 = 0;
        int sum50 = 0, sum100 = 0;
        if (peopleInLine[0] != 25) return "NO";
        for (int i=0; i<peopleInLine.length; i++){
            if (peopleInLine[i] == 25) count25 += 1;
            if (peopleInLine[i] == 50 && count25 >0 ) {
                count25 -=1;
                count50 +=1;
            }
            else if (peopleInLine[i] == 50) return "NO";
            if (peopleInLine[i] == 100 && (count50 >= 1 && count25 >= 1)) {
                count50 -=1;
                count25 -=2;
            }
            else if (peopleInLine[i] == 100 &&  count25 >= 3){
                count25 -=3;
            }
            else if (peopleInLine[i] == 100) return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        //System.out.println(Line.Tickets(new int[] {25, 25, 50}));
        System.out.println(Line.Tickets(new int[] {25, 50, 25, 50, 100, 50, 100}));
    }
}