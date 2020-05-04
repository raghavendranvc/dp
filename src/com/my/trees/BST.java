package com.my.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class BST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    TreeNode root;

    BST(TreeNode root){
        this.root = root;
    }

    private void insert(int key){
        root = insert(key,root);
    }

    private TreeNode insert(int key, TreeNode root){
        if(root == null){
            root = new TreeNode(key);
            return root;
        }

        if(key < root.val) {
            root.left = insert(key, root.left);
        } else if (key > root.val) {
            root.right = insert(key, root.right);
        }

        return root;

    }

    private void printInOrderTravelsal(TreeNode root){
        while(root != null){
            printInOrderTravelsal(root.left);
            System.out.println(root.val);
            printInOrderTravelsal(root.right);
        }
    }

}
