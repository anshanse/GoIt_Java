package lectionHW.Functional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ChangeList2 {
    public static void main(String[] args) throws IOException {
        List<String> readList = Files.readAllLines(Paths.get("src/lectionHW/Functional/Resources/File1.txt"));
        Consumer<String> upCase = s -> s.toLowerCase();
        for (String str : readList) {
            upCase.accept(str);
        }
        Collections.sort(readList);

        //variant with stream
        //readList = readList.stream().map(String::toUpperCase).sorted().collect(Collectors.toList());

        System.out.println(readList);
    }
}
