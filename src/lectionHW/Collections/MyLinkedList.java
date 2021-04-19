package lectionHW.Collections;

import java.util.*;


public class MyLinkedList<T> {

    Element<T> first;
    Element<T> last;
    int sizeList;

    class Element<T>{
        Element<T> prev;
        T value;
        Element<T> next;

        public Element(Element<T> prev, T value, Element<T> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    public MyLinkedList() {
    }

    public void lastElement (T e){
        Element<T> l = last;
        Element<T> newElement = new Element<>(l,e,null);
        last = newElement;
        if (l == null){
            first = newElement;
        }
        else l.next = newElement;
        sizeList++;
    }

    public void add(T value){
        lastElement(value);
    }

    public void remove(int index){

        Element<T> x;
        T removeValue;
        Element<T> removeNext;
        Element<T> removePrev;

        if (index>=0 && index<=sizeList){
            x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            removeValue = x.value;
            removePrev = x.prev;
            removeNext = x.next;
            if (removePrev == null){
                first = removeNext;
            }
            else {
                removePrev.next = removeNext;
                x.prev = null;
            }
            if (removeNext == null) {
                last = removePrev;
            }
            else {
                removeNext.prev = removePrev;
                x.next = null;
            }
            x.value=null;
            sizeList--;
        }
        else throw new IndexOutOfBoundsException();

    }

    public void clear(){
        for (Element<T> x = first; x != null;) {
            Element<T> tmpNext = x.next;
            x.next=null;
            x.prev=null;
            x.value=null;
            x = tmpNext;
        }
        sizeList = 0;
    }

    public int size(){
        return sizeList;
    }

    public T get(int index){
        Element<T> x = first;
        if (index>=0 && index<=sizeList) {
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        }
        return x.value;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        List<Integer> linkedList = new LinkedList<>();
        myLinkedList.add(1);
        linkedList.add(1);
        myLinkedList.add(2);
        linkedList.add(2);
        myLinkedList.add(3);
        linkedList.add(3);
        myLinkedList.remove(1);
        linkedList.remove(1);
        int size = myLinkedList.size();
        int size1 = linkedList.size();
        int value = myLinkedList.get(1);
        int value1 = linkedList.get(1);
        myLinkedList.clear();
        linkedList.clear();
    }
}
