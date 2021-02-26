package lectionHW;

import java.util.Scanner;

public class Greed {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean step = true;
        String dices = "";
        while (step){
             dices = in.nextLine();
             if (dices.matches("\\d[1-6] {6}")){
                 step = false;
             }
             else {
                 System.out.println("Enter 0 - 6 digits only");
             }
        }
        String [] dice = dices.split(" ");
        String diceNum = dice[0];
        int count = 0;
        String diceScore = diceNum;
        for (int i = 1; i < dice.length+1 ; i++) {
            if (i < dice.length && diceNum.equals(dice[i])){
                diceScore = diceScore + dice[i];
                diceNum = dice[i];
            }
            else if (!diceScore.equals(null)){
                switch (diceScore){
                    case "111":
                       count += 1000;
                       break;
                    case "666":
                        count += 600;
                        break;
                    case "555":
                        count += 500;
                        break;
                    case "444":
                        count += 400;
                        break;
                    case "333":
                        count += 300;
                        break;
                    case "222":
                        count += 200;
                        break;
                    case "1":
                        count += 100;
                        break;
                    case "5":
                        count += 50;
                        break;
                }
                if (i< dice.length){
                    diceScore = dice [i];
                    diceNum = dice [i];
                }
            }
        }
        System.out.println("Your score is: " + count);
    }
}
