package com.my.trees;

import java.util.ArrayList;
import java.util.Collections;

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

    // Merge Sort is the preferred approach
    public int countInversionsNotWorking(ArrayList<Integer> A) {
        return mergeSort(A, 0, A.size()-1);
    }

    // end is inclusive
    public int mergeSort(ArrayList<Integer> A, int start, int end){
        int count = 0;
        if(start < end){
            int mid = (start+end)/2;
            count += mergeSort(A, start, mid);
            count += mergeSort(A, mid+1, start);
            count += merge(A,start,mid,end);
        }

        return count;
    }


    private int merge(ArrayList<Integer> A, int start, int mid, int end){
        ArrayList<Integer> leftArray = new ArrayList<>(A.subList(start,mid+1)); // mid needs to be included
        ArrayList<Integer> rightArray = new ArrayList<>(A.subList(mid+1, end+1)); // end needs to be included

        int i=0,j=0,k=start;
        int swaps=0;

        while( i < leftArray.size() && j <rightArray.size()){
            if(leftArray.get(i) <= rightArray.get(j)){
                A.set(k++,leftArray.get(i++));
            } else {
                A.set(k++,rightArray.get(j++));
                swaps += leftArray.size()-i;  // => (mid+1-start) - i
                //swaps += (mid + 1) - (start + i);
            }
        }

        while (i<leftArray.size()){
            A.set(k++,leftArray.get(i++));
        }

        while (j<rightArray.size()){
            A.set(k++,rightArray.get(j++));
        }
        return swaps;
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
                count += (left.size()-i);
                j++;
            }
        }
        return count;
    }


}
