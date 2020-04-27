package com.my.stacksqueues;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    List<Node> nodeList = new ArrayList<Node>();

    class Node{
        int val;
        Node min;
        Node (int val){
            this.val = val;
            if(nodeList.isEmpty()){
                min = this;
            } else {
                Node minNode = nodeList.get(nodeList.size()-1).min;
                if(minNode.val > this.val ){
                    min = this;
                } else {
                    min = minNode;
                }
            }
        }
    }

    public void push(int x) {
        nodeList.add(new Node(x));
    }

    public void pop() {
        if(nodeList.isEmpty()){
            return;
        }
        Node topNode = nodeList.remove(nodeList.size()-1);
    }

    public int top() {
        if(nodeList.isEmpty()){
            return -1;
        }
        return nodeList.get(nodeList.size()-1).val;
    }

    public int getMin() {
        if(nodeList.isEmpty()){
            return -1;
        }
        return nodeList.get(nodeList.size()-1).min.val;
    }

}
