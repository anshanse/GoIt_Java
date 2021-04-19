package lectionHW.Collections;

import java.util.ArrayList;
//import java.util.Arrays;
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
        Object[] newArr = new Object[sizeArr-1];
        int j=0;
        for (int i=0; i<sizeArr; i++){
            if (i != index) {
                newArr[j++] =(E) array[i];
            }
        }
        return array = (E[]) newArr;
    }

    public void clear (){
        sizeArr = 0;
        array = (E[]) new Object [10];
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String[] args) {
        MyArrayList<Integer> myArrList = new MyArrayList<>();
        List<Integer> arrList = new ArrayList<>();
        myArrList.add(5);
        arrList.add(5);
        myArrList.add(6);
        arrList.add(6);
        myArrList.remove(1);
        arrList.remove(1);
        myArrList.clear();
        arrList.clear();

    }

}
