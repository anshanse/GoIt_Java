package lectionHW.IO.ReadFile;

import java.io.*;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) throws IOException {

        try (Scanner sc = new Scanner(new FileInputStream("src/lectionHW/IO/ReadFile/Resources/file1.txt"))) {
            String phoneNumber;
            while (sc.hasNext()) {
                phoneNumber = sc.nextLine();
                if (phoneNumber.matches("\\(\\d{3}\\)?[-\\s]\\d{3}-\\d{4}") || phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}")) {
                    System.out.println(phoneNumber);
                }
            }
        }
    }
}
