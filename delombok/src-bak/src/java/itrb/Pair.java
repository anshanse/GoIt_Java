package itrb;

public class Pair <K,V> {
    
    private K key;
    
    private V value;

    private Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public static <E,V> Pair<E,V> of(E key, V value) {
        return new Pair(key, value);
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pair{" + "key=" + key + ", value=" + value + '}';
    }
    
}
