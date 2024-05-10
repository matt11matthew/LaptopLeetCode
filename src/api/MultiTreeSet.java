package api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MultiTreeSet<T> {
    public final TreeMap<T, Integer> map;

    public MultiTreeSet() {
        map = new TreeMap<>();
    }



    public void add(T element) {
        map.put(element, map.getOrDefault(element, 0) + 1);
    }

    public void remove(T element) {
        int count = map.getOrDefault(element, 0);
        if (count > 1) {
            map.put(element, count - 1);
        } else {
            map.remove(element);
        }
    }

    public T first() {
        return map.firstKey();
    }

    public T last() {
        return map.lastKey();
    }

    public T pollFirst() {
        if (map.isEmpty()) {
            return null;
        }
        T first = map.firstKey();
        remove(first);
        return first;
    }

    public int size() {
        int totalSize = 0;
        for (int count : map.values()) {
            totalSize += count;
        }
        return totalSize;
    }

    public List<T> getList() {
        List<T> values =new ArrayList<>();

        for (T t : map.keySet()) {
            for (int i = 0; i < map.get(t); i++) {
                values.add(t);
            }
        }
        return values;
    }
}