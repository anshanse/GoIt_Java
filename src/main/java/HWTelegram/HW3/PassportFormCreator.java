package HWTelegram.HW3;

import java.util.Locale;
import java.util.Scanner;

public class PassportFormCreator {
    public void createForms(){
        Scanner scanner = new Scanner(System.in);
        String fName = scanner.nextLine();
        String sName = scanner.nextLine();
        int age = scanner.nextInt();
        scanner.close();
        System.out.println(fName + " " + sName + " " + age*10);
        System.out.println(fName.toUpperCase());
        System.out.println(sName.toUpperCase());
        System.out.println(age*10);
    }

    public String[] createEmptyNameArray() {
        String[] result = new String [10];
        return result;
    }
}


