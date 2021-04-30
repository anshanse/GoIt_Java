package lectionHW.IO.ReadFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadOutJson {
    public static void main(String[] args) throws IOException {
        List<User> user = new ArrayList<>();
        try (Scanner sc = new Scanner(new BufferedInputStream(ReadFile.class.getResourceAsStream("/file2.txt")))) {
            String readData;
            while (sc.hasNext()){
                readData = sc.nextLine();
                //int l = readData.length();
                if (readData.length() != 0 && (!readData.contains("name") || !readData.contains("age"))){
                    user.add(new User(readData.split(" ")[0], Integer.valueOf(readData.split(" ")[1])));
                }
            }
        }
        try (FileWriter fw = new FileWriter("src/lectionHW/IO/ReadFile/Resources/file2Json.json")){
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
