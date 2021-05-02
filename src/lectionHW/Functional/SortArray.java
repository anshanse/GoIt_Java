package lectionHW.Functional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortArray {
    public static void main(String[] args) {
        String[] array = {"1, 2, 0", "4, 5"};
        String sortResult = Arrays.stream(array)
                .map(s -> s.split(", "))
                .flatMap(Stream::of)
                .map(Integer::valueOf)
                .sorted()
                .map(Objects::toString)
                .collect(Collectors.joining(", "));

        System.out.println(sortResult);
    }
}
