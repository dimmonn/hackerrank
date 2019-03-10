package algos.hackerrank.dc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SuperHashMap<K, V> {
    private Entry<K, V>[] kvEntry;
    private int size;

    public int size() {
        return size;
    }

    public SuperHashMap() {
        this(5);
    }

    public SuperHashMap(int capacity) {
        kvEntry = new Entry[capacity];
        size = capacity;
    }

    public V put(K key, V val) {

        int bucketIndex = key.hashCode() % size;
        Entry<K, V> entry = new Entry<>(key, val, null);
        if (kvEntry[bucketIndex] == null) {
            kvEntry[bucketIndex] = entry;
        } else {
            Entry<K, V> kvEntry = this.kvEntry[bucketIndex];
            if (kvEntry.k.equals(key)) {
                kvEntry.v = val;
                return val;
            }
            while (kvEntry.next != null) {
                kvEntry = kvEntry.next;
                if (kvEntry.k.equals(key)) {
                    kvEntry.v = val;
                    return val;
                }
            }
            kvEntry.next = entry;

        }
        return val;
    }

    public Set<Entry<K, V>> getKvEntry() {
        return new HashSet<>(Arrays.asList(kvEntry));
    }

    public V get(K key) {

        int bucket = key.hashCode() % size;
        Entry<K, V> kvEntry = this.kvEntry[bucket];
        if (kvEntry.k.equals(key)) {
            return kvEntry.v;
        } else {
            while (kvEntry.next != null) {
                if (kvEntry.next.k.equals(key)) {
                    return kvEntry.next.v;
                }
                kvEntry = kvEntry.next;
            }

        }
        return null;
    }
}