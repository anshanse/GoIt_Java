package lectionHW.Collections;

import java.util.*;

public class MyHashMap<K,V> {

    private static int sizeHashMap;
    private HashNode<K,V> first;
    private HashNode<K,V> last;
    private HashNode<K,V> [] hashArray;

    public MyHashMap() {
        int INITIAL_SIZE = 16;
        this.hashArray = new HashNode[INITIAL_SIZE];
        sizeHashMap =0;
    }

    private class HashNode<K,V>{
        K key;
        V value;
        int hash;
        HashNode<K,V> next;
        int index;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.hash = hash(key);
        }

        final int hash (K key){
            int h;
            return (key == null) ? 0 : (h = key.hashCode()) ^ (h>>>16);
        }

        @Override
        public boolean equals(Object o) {
            if (this ==  o) return true;
            if (!(o instanceof HashNode)) return false;
            HashNode<K, V> hashNode = (HashNode<K, V>) o;
            return hash == hashNode.hash && Objects.equals(key, hashNode.key);
        }

        /*@Override
        public int hashCode() {
            return Objects.hash(key);
        }*/
    }

    private int indexOf(K key){
        return (hashArray.length-1) & key.hashCode();
    }

    private void resize(){
        HashNode<K,V>[] newArray = new HashNode[hashArray.length*2];
        System.arraycopy(hashArray,0,newArray,0,hashArray.length);
        hashArray=newArray;
    }

    public void put(K key, V value) {             //добавляет пару ключ + значение
        boolean ismatch = false;
        HashNode<K,V> x;
        HashNode<K,V> newElement = new HashNode<>(key, value);
        int index = indexOf(newElement.key);
        if (hashArray[index] == null) {
            hashArray[index] = newElement;
            sizeHashMap++;
            ismatch = true;
            //hashArray[index].next = newElement;
        }
        else {
            //HashNode<K,V> x;
            x = hashArray[index];
            do {
                if (x.equals(newElement)) {
                    x.value = newElement.value;
                    ismatch = true;
                }
                //x = x.next;
            }while ((x = x.next) != null);
            /*for (x = hashArray[index]; x.next != null;){
                ;
            }*/
        }
        if (!ismatch) {
            for (x = hashArray[index]; x.next != null;) x = x.next;
            x.next = newElement;
            sizeHashMap++;
        }

    }

    public void remove(Object key) {                        //удаляет пару по ключу
        int hashKey = Objects.hash(key);
        HashNode<K,V> removeNext;
        for (HashNode<K,V> x = first; x != null;){
            removeNext = x;
            if (hashKey == x.next.hash){
                removeNext.next = x.next.next;
                x.next.value = null;
                x.next.key = null;
                x.next.next = null;
                break;
            }
            x = x.next;
        }
    }

    public void clear() {                                   //очищает коллекцию
        first = null;
        last = null;
        sizeHashMap = 0;
    }

    public int size() {                                    //возвращает размер коллекции
        return sizeHashMap;
    }

    public V get(K key) {                           //возвращает значение (Object value)по ключу
        int hashKey = Objects.hash(key);
        V searchValue = null;
        for (HashNode<K,V> x = first; x != null;){
            if (hashKey == x.hash){
                searchValue = x.value;
            }
            x=x.next;
        }
        return searchValue;
    }

    public static void main(String[] args) {
        MyHashMap<Integer, Integer> myMap = new MyHashMap<>();
        //new HashMap<>();
        myMap.put(1,1);
        myMap.put(2,2);
        myMap.put(10,2);
        myMap.put(2,3);
        myMap.put(3,3);
        myMap.put(4,4);
        myMap.remove(3);
        int size = myMap.size();
        int value0 = myMap.get(2);
        myMap.clear();
    }
}
