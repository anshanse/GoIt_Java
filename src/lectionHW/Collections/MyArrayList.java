package lectionHW.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArrayList <E>{
    private E [] array;
    private int sizeArr;

    public MyArrayList(E[] array) {
        this.array = array;
        sizeArr = 0;
    }

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int capacity) {
        this.array = (E[]) new Object [capacity];
        sizeArr = 0;
    }

    public void add(E a){
        if (sizeArr == array.length){
            Object [] newArray = new Object[array.length+10];
            System.arraycopy(array,0,newArray,0,array.length);
            array = (E[]) newArray;
        }
        array[sizeArr++] = a;
    }

    public int size(){
        return sizeArr;
    }

    public E[] remove(int index){
        E [] newArr =(E[]) new Object[sizeArr-1];
        int j=0;
        for (int i=0; i<sizeArr; i++){
            if (i != index) {
                newArr[j++] =(E) array[i];
            }
        }
        return array = (E[]) newArr;
    }

    public E[] clear (){
        sizeArr = 0;
        return array = (E[]) new Object [10];
    }

    @Override
    public String toString() {
        int iMax = sizeArr - 1;
        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(array[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }

    }

    public static void main(String[] args) {
        MyArrayList<Integer> myArrList = new MyArrayList<>();
        List<Integer> arrList = new ArrayList<>();
        myArrList.add(5);
        arrList.add(5);
        myArrList.add(6);
        myArrList.add(7);
        myArrList.add(8);
        arrList.add(6);
        System.out.println(myArrList.remove(1));
        System.out.println(arrList.remove(1));

    }

}
