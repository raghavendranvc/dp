package com.my.heaps;


import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;


public class LRUImplementation {

    private Map<Integer,Integer> linkedHashMap = null;
    private Deque<Integer> deque = null;
    private int capacity = 0;

    public LRUImplementation(int capacity) {
        this.capacity = capacity;
        linkedHashMap = new LinkedHashMap<>(capacity);
        deque = new LinkedList<>();
    }

    public int get(int key) {
        Integer value = linkedHashMap.get(key);
        if(value == null){
            return -1;
        } else {
            deque.remove(key);
            deque.addFirst(key);
            return value;
        }
    }

    public void set(int key, int value) {
        if(linkedHashMap.get(key) != null){
            deque.remove(key);
            linkedHashMap.remove(key);
        }

        if(deque.size() == capacity ){
            int removedKey = deque.removeLast();
            linkedHashMap.remove(removedKey);
        }

        linkedHashMap.put(key,value);
        deque.addFirst(key);
    }
}
