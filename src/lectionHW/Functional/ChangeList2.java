package lectionHW.Functional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ChangeList2 {
    public static void main(String[] args) throws IOException {
        List<String> readList = Files.readAllLines(Paths.get("src/lectionHW/Functional/Resources/File1.txt"));

        /*Function<String, String> upCase = String::toUpperCase;
        for (int i=0; i< readList.size(); i++) {
            //upCase.apply(str);
            readList.set(i, upCase.apply(readList.get(i)));
        }
        Collections.sort(readList, Comparator.reverseOrder());*/

        //variant with stream
        readList = readList.stream().map(String::toUpperCase).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        System.out.println(readList);
    }
}
