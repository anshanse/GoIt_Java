package itrb;

import itrb.ArrayWrapper;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        String [] arr = {"a","b","c"};
        ArrayWrapper<String>arrayWrapper = new ArrayWrapper<>(arr);
        
        String e0 = arrayWrapper.get(0);
        System.out.println(e0);
        arrayWrapper.set(0, "x");
        
        System.out.println(arrayWrapper);
        
        for (String element : arrayWrapper) {
            System.out.println(element);
        }
        
        Pair<String, Long> pair1 = Pair.of("string111", 5L);
        String key = pair1.getKey();
        
        Pair<Integer, Long> pair2 = Pair.of(1, 5L);
        Integer key1 = pair2.getKey();
        
//        Integer [] arr1 = new Integer[3];
//        ArrayWrapper<Integer>arrayWrapper1 = new ArrayWrapper<>(arr1);
//        Integer[] array1 = arrayWrapper1.getArray();
//        
//        String name = "";
//        Integer age = 5;
//        String exemple = arrayWrapper1.exemple(name);
//        Integer exemple1 = arrayWrapper1.exemple(age);
        
    }
    
}
