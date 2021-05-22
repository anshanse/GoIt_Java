package lectionHW.Collections;

//import java.util.*;

public class MyQueue<E> {
    private int sizeQueue;
    private MyNode<E> first;
    private MyNode<E> last;

    private static class MyNode<E>{
        MyNode<E> prev;
        E value;
        MyNode<E> next;

        public MyNode(MyNode<E> prev, E value, MyNode<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    public void add(E value) {
        MyNode<E> l = last;
        MyNode<E> newNode = new MyNode<>(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        }
        else {
            l.next = newNode;
        }
        sizeQueue++;
    }

    public void remove(int index) {
        MyNode<E> x;

        if (index < 0 || index >= sizeQueue) throw new IndexOutOfBoundsException();
        x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        if (x.prev == null) first = x.next;
        else x.prev.next = x.next;
        if (x.next == null) last = x.prev;
        else x.next.prev = x.prev;
        sizeQueue--;
    }

    public void clear() {
        first = null;
        last = null;

    }
    public int size() {
        return sizeQueue;
    }
    public E peek() {            //возвращает первый элемент в очереди (FIFO)
        return first.value;
    }
    public E poll(){             //возвращает первый элемент в очереди и удаляет его из коллекции
        E result = peek();
        remove(0);
        return result;
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.remove(2);
        System.out.println(myQueue.size());
        Integer peek = myQueue.peek();
        System.out.println(myQueue.poll());
        myQueue.clear();
    }
}
