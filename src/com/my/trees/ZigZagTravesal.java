package com.my.trees;

import java.util.*;

public class ZigZagTravesal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        zigzagLevelOrder(Collections.singletonList(A), result, 0);
        return result;
    }

    public void zigzagLevelOrder(List<TreeNode> nodeList, ArrayList<ArrayList<Integer>> result, int depth) {

        while(!nodeList.isEmpty()) {

            List<TreeNode> nextList = new LinkedList<>();

            Iterator<TreeNode> iterator = nodeList.iterator();
            while (iterator.hasNext()) {
                TreeNode tempNode = iterator.next();
                if (tempNode.left != null) {
                    nextList.add(tempNode.left);
                }

                if (tempNode.right != null) {
                    nextList.add(tempNode.right);
                }
            }
            ArrayList<Integer> values = getValues(nodeList);
            if(depth % 2 == 1) {
                Collections.reverse(values);
            }
            result.add(values);
            nodeList = nextList;
            depth++;
        }
    }

    private ArrayList<Integer> getValues(List<TreeNode> nodeList){
        ArrayList<Integer> valList = new ArrayList<>();

        Iterator<TreeNode> iterator = nodeList.iterator();
        while(iterator.hasNext()) {
            TreeNode tempNode = iterator.next();
            valList.add(tempNode.val);
        }
        return valList;
    }
}
