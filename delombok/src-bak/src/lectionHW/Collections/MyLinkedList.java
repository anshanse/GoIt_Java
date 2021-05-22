package lectionHW.Collections;

import java.util.*;


public class MyLinkedList<T> {

    private Element<T> first;
    private Element<T> last;
    private int sizeList;

    private static class Element<T>{
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

    private void lastElement (T e){
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
        x = get(index);
        if (x.prev == null) first = x.next;
        else x.prev.next = x.next;
        if (x.next == null) last = x.prev;
        else x.next.prev = x.next;
        sizeList--;
    }

    public void clear(){
        first = null;
        last = null;
        sizeList = 0;
    }

    public int size(){
        return sizeList;
    }

    public Element<T> get(int index){
        Element<T> x = first;
        if (index>=0 && index<=sizeList) {
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        }
        return x;
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
        int value = myLinkedList.get(1).value;
        int value1 = linkedList.get(1);
        myLinkedList.clear();
        linkedList.clear();
    }
}
