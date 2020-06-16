package com.my.trees;

import java.util.ArrayList;

public class CountInversions {

    class TreeNode{
        int val;
        int gVal;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            gVal = 0;
        }
    }

    public int countInversionsTriedUsingTree(ArrayList<Integer> A) {
        TreeNode rootNode = null;
        for(int i : A) {
            rootNode = insert(rootNode, i);
        }

        int countInversions = 0;
        for(int i : A){
            TreeNode tempNode = rootNode;
            while(tempNode.val != i){ // We only move if the element is not found. Loop is terminated when the element is found
                if(tempNode.val < i){ // Found larger Element. So tempNodes gVal is ignored
                    tempNode = tempNode.right;
                } else {
                    countInversions += (tempNode.gVal+1); // We need to count all parent(1) and all the greater values(gVal)
                    tempNode = tempNode.left;
                }
            }
        }
        return countInversions;
    }


    private TreeNode insert(TreeNode root, int val){
        if(root == null){
            root = new TreeNode(val);
            return root;
        }

        if(root.val > val){
            root.left = insert(root.left, val);
        } else if (root.val < val){
            root.right = insert(root.right, val);
            root.gVal++;
        }
        return root;
    }

    /*
    Simple merge Sort to count inversions
     */

    public int countInversions(ArrayList<Integer> A) {
        if(A.size() < 2){
            return 0;
        }
        int m = (A.size()+1)/2;
        ArrayList<Integer> leftArray = new ArrayList<>(A.subList(0, m)); //m is not included
        ArrayList<Integer> rightArray = new ArrayList<>(A.subList(m,A.size()));

        //We add up. Don't multiply //TODO remember
        return countInversions(leftArray) + countInversions(rightArray) + mergeCount(A, leftArray, rightArray);

    }

    public int mergeCount(ArrayList<Integer> result, ArrayList<Integer> left, ArrayList<Integer> right) {
        int i=0, j=0;
        int count = 0;

        while (i < left.size() || j < right.size()){
            if(i == left.size()){
                result.set(i+j, right.get(j));
                j++;
            } else if (j == right.size()){
                result.set(i+j, left.get(i));
                i++;
            } else if (left.get(i) <= right.get(j)){
                result.set(i+j, left.get(i));
                i++;
            } else {
                result.set(i+j, right.get(j));
                count += (left.size()-i); //TODO check how the count increases
                j++;
            }
            
            // left ....i .....mid .....j ......right
            //  if(j<i), then number of inversions = left elements that are greater than j
            // meaning all elements from i too mid meaning left.size()-i
            // all elements from : left to mid are sorted
            // all elements from : mid to right are sorted
            // so the only ones which counts are from "i to mid" which would be greater
            // than j. The ones from j+1 to right are obviously not counted
        }
        return count;
    }


}
