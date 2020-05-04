package com.my.trees;

import java.util.Stack;

public class KthSmallestElement {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public int kthsmallest(TreeNode A, int B) {
        TreeNode node = inOrderTraversal(A,  B);
        return node.val;

    }

    int count=0; //TODO check this global varaible. Can't have it as a local variable
    public TreeNode inOrderTraversal(TreeNode A, int B) {
        if(A == null){
            return null;
        }
        TreeNode left = inOrderTraversal(A.left,  B);
        if(left != null){
            return left;
        }
        count++;
        if(count == B){
            return A;
        }
        return inOrderTraversal(A.right,  B);
    }

    public int kthSmallestCopied(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;
        int result = -1;

        while(!stack.isEmpty() || p != null){
            if(p != null){
                stack.push(p);
                p = p.left;
            } else {
                TreeNode temp = stack.pop();
                k--;
                if(k == 0){
                    result = temp.val;
                    break;
                }
                p = temp.right;
            }
        }
        return result;
    }

    /*

    7 2 1 3 -1 -1 -1 -1

    7

        7
    2

            7
        2

     1


        2
      1      7
           3



     */
}
