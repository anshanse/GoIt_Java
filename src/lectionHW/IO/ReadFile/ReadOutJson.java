package lectionHW.IO.ReadFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadOutJson {
    public static void main(String[] args) throws IOException {
        List<User> user = new ArrayList<>();
        try (Scanner sc = new Scanner(new File("src/lectionHW/IO/ReadFile/file2.txt"))) {
            String readData;
            while (sc.hasNext()){
                readData = sc.nextLine();
                //int l = readData.length();
                if (readData.length() != 0 && (!readData.contains("name") || !readData.contains("age"))){
                    user.add(new User(readData.split(" ")[0], Integer.valueOf(readData.split(" ")[1])));
                }
            }
        }
        try (FileWriter fw = new FileWriter("src/lectionHW/IO/ReadFile/file2Json.txt")){
            //Gson gson = new GsonBuilder().
            fw.write(new GsonBuilder().setPrettyPrinting().create().toJson(user));
        }
    }

    static class User{
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
