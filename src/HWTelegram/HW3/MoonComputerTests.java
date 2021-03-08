package HWTelegram.HW3;

import java.util.*;

public class MoonComputerTests {
    public void testBasicInputOutput() {
        Scanner scanner = new Scanner(System.in);
        String data  =scanner.nextLine();
        System.out.println(data);
        scanner.close();
    }

    //Test output on Hello Java standard input
    public static void main(String[] args) {
        MoonComputerTests computerTests = new MoonComputerTests();
        //computerTests.testBasicInputOutput();
        //computerTests.testMath();
        computerTests.testLogicalOperators();
    }

    public void testMath(){
        Scanner scan = new Scanner(System.in);
        int firstNumber = Integer.valueOf(scan.nextLine());
        int secondNumber = Integer.valueOf(scan.nextLine());
        if (firstNumber != 0 && secondNumber !=0){
            System.out.println((firstNumber+secondNumber) + " " +(firstNumber-secondNumber)+" " + (firstNumber*secondNumber) + " " + (firstNumber/secondNumber) );
        }
        scan.close();
    }

    public void testLogicalOperators(){
        Scanner scanner = new Scanner(System.in);
        boolean first = Boolean.valueOf(scanner.nextLine());
        boolean second = Boolean.valueOf(scanner.nextLine());
        boolean third = Boolean.valueOf(scanner.nextLine());
        System.out.println((first&second&third) + " " + (first|second|third));
        scanner.close();
    }
}
