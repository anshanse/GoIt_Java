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

    public E get (int index){
        return array[index];
    }

    public int size(){
        return sizeArr;
    }

    public E[] remove(int index){
        Object[] newArr = new Object[array.length-1];
        System.arraycopy(array,0,newArr,0, index);
        System.arraycopy(array,index+1,newArr,index,array.length-index-1);
        sizeArr--;
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
        myArrList.add(6);
        myArrList.add(7);
        myArrList.add(8);
        arrList.add(5);
        myArrList.add(9);
        arrList.add(6);
        myArrList.remove(1);
        arrList.remove(1);
        int a = myArrList.get(2);
        myArrList.clear();
        arrList.clear();

    }

}
