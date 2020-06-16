package com.my.heaps;


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class LRUImplementation {

    private Map<Integer,Integer> hashMap = null;
    private Deque<Integer> deque = null;
    private int capacity = 0;

    public LRUImplementation(int capacity) {
        this.capacity = capacity;
        //linkedHashMap = new LinkedHashMap<>(capacity);
        hashMap = new HashMap<>(capacity);
        deque = new LinkedList<>();
    }

    public int get(int key) {
        Integer value = hashMap.get(key);
        if(value == null){
            return -1;
        } else {
            deque.remove(key); 
            //remove from LikedList is through reference.
            //in a deque, it means removing that particular node
            deque.addFirst(key);
            return value;
        }
    }

    public void set(int key, int value) {
        if(hashMap.get(key) != null){
            deque.remove(key);
            hashMap.remove(key);
        }

        if(deque.size() == capacity ){ // means, deletion, a new node. So get space
            int removedKey = deque.removeLast();
            hashMap.remove(removedKey);
        }

        hashMap.put(key,value);
        deque.addFirst(key);
    }
}
