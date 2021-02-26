package lectionHW;

import java.util.Scanner;

public class Greed {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean step = true;
        String dices;
        String [] dice = new String[6];
        while (step){
             dices = in.nextLine();
             if (dices.matches("\\d \\d \\d \\d \\d \\d")){
                 step = false;
                 dice = dices.split(" ");
                 for (int i = 0; i < dice.length-1; i++) {
                     if (Integer.parseInt(dice[i])>6 || Integer.parseInt(dice[i])<1){
                         System.out.println("Enter 1 - 6 digits only");
                     }
                 }
             }
             else {
                 System.out.println("Enter 6 digits only");
             }
        }
        //String dices = in.nextLine();
        //String [] dice = dices.split(" ");
        String diceNum = dice[0];
        int count = 0;
        String diceScore = diceNum;
        //String DiceSum = "";
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
