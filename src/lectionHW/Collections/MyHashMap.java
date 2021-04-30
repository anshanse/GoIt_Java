package lectionHW.Collections;

import java.util.*;

public class MyHashMap<K,V> {

    private int sizeHashMap;
    private HashNode<K,V> [] hashArray;
    private final int INITIAL_SIZE = 16;

    public MyHashMap() {

        this.hashArray = new HashNode[INITIAL_SIZE];
        sizeHashMap =0;
    }

    private static class HashNode<K,V>{
        K key;
        V value;
        int hash;
        HashNode<K,V> next;

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

        @Override
        public String toString() {
            return "key=" + key + ", value=" + value;
        }
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
        if (hashArray.length-1<index) this.resize();
        if (hashArray[index] == null) {
            hashArray[index] = newElement;
            sizeHashMap++;
        }
        else {
            x = hashArray[index];
            do {
                if (x.equals(newElement)) {
                    x.value = newElement.value;
                    ismatch = true;
                }
            }while ((x.next) != null);
            if (!ismatch) {
                x.next = newElement;
                sizeHashMap++;
            }
        }
    }

    public void remove(K key) {                         //удаляет пару по ключу
        int index = indexOf(key);
        HashNode<K,V> x;
        if (hashArray[index].next == null) hashArray[index] = null;
        else{
            x = hashArray[index];
            do{
                if (Objects.equals(x.next.key,key)) {
                    x.next = null;
                }
            }while ((x = x.next) != null);
        }
        --sizeHashMap;
    }

    public void clear() {                                   //очищает коллекцию
        hashArray = new HashNode[INITIAL_SIZE];
        sizeHashMap =0;
    }

    public int size() {                                    //возвращает размер коллекции
        return sizeHashMap;
    }

    public HashNode<K,V> get(K key) {                           //возвращает значение (Object value)по ключу
        int index = indexOf(key);
        HashNode<K,V> x, resultGet = null;
        if (hashArray[index].next == null) resultGet = hashArray[index];
        else {
            x = hashArray[index].next;
            do{
                if (Objects.equals(x.key,key)) resultGet = x;
            }while ((x = x.next) != null);
        }
        return resultGet;
    }

    public static void main(String[] args) {
        MyHashMap<Integer, Integer> myMap = new MyHashMap<>();
        myMap.put(1,1);
        myMap.put(2,2);
        myMap.put(10,2);
        myMap.put(2,3);
        myMap.put(3,3);
        myMap.put(4,4);
        myMap.put(17,5);
        System.out.println(myMap.get(17));
        myMap.remove(3);
        int size = myMap.size();
        myMap.clear();
    }
}
