package lectionHW.Functional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ChangeList1 {
    public static void main(String[] args) throws IOException {
        List<String> readList = Files.readAllLines(Paths.get("src/lectionHW/Functional/Resources/File1.txt"));
        BiFunction<Integer,String,String> change = (i, s) -> i + ". " + s;
        Predicate<Integer> check = i-> (i%2) != 0;
        //StringBuilder newList = new StringBuilder();
        /*for (int i = 0; i < readList.size(); i++) {
            if (check.test(i+1)) newList.append(change.apply(i + 1, readList.get(i))).append(", ");
        }*/
        AtomicInteger index = new AtomicInteger();
        List<String> newList = readList.stream()
                .map(n -> index.incrementAndGet() +". "+n)
                .filter(n ->Integer.valueOf(n.charAt(0))%2 !=0)
                .collect(Collectors.toList());
        System.out.println(newList);
    }
}
