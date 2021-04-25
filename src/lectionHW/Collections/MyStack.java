package lectionHW.Collections;

public class MyStack<E> {

    private int sizeStack;
    private StackNode<E> first;
    private StackNode<E> last;

    private static class StackNode<E>{
        StackNode<E> prev;
        E value;
        StackNode<E> next;

        public StackNode(StackNode<E> prev, E value, StackNode<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    public void push(E value){             // добавляет элемент в конец
        StackNode<E> l = last;
        StackNode<E> newStackNode = new StackNode<>(l,value,null);
        last = newStackNode;
        if (l == null){
            first = newStackNode;
        }
        else{
            l.next=newStackNode;
        }
        sizeStack++;
    }

    public void remove(int index) {             //удаляет элемент под индексом
        StackNode<E> x;

        if (index < 0 || index >= sizeStack) throw new IndexOutOfBoundsException();
        x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        if (x.prev == null) first = x.next;
        else x.prev.next = x.next;
        if (x.next == null) last = x.prev;
        else x.next.prev = x.prev;
        sizeStack--;
    }

    public void clear() {                       //очищает коллекцию
        for (StackNode<E> x = first; x != null;) {
            StackNode<E> tmpNext = x.next;
            x.next=null;
            x.prev=null;
            x.value=null;
            x = tmpNext;
            sizeStack--;
        }
    }

    public int size() {                        //возвращает размер коллекции
        return sizeStack;
    }

    public E peek() {                        //возвращает первый элемент в стеке(LIFO)
        return last.value;
    }

    public E pop() {                         //возвращает первый элемент в стеке и удаляет его из коллекции
        E returnPop = peek();
        remove(sizeStack-1);
        return returnPop;
    }

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        for (int i = 0; i < 5; i++) {
            myStack.push(i);
        }
        System.out.println(myStack.size());
        System.out.println(myStack.peek());
        myStack.remove(2);
        System.out.println(myStack.size());
        System.out.println(myStack.pop());
        System.out.println(myStack.size());
        myStack.clear();
    }


}
