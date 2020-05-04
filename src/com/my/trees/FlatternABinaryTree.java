package com.my.trees;

import java.util.Stack;

public class FlatternABinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    /*
    1. If there is a node with both left & right, but no grand children
                    root
                    /   \
                left    right

            them make it as root
                                \
                                 left
                                    \
                                    right

    2. If there is a node with only right, but no grand children
                root        root
                /               \
              left              right

    3. Recursively do for all the nodes


     */

    public TreeNode flattenR(TreeNode a) {
        flattenRecur(a);
        return a;
    }

    public void flattenRecur(TreeNode a) {
        if(a == null || (a.left == null && a.right == null)) {
            return;
        }

        if(a.left != null){
            flattenRecur(a.left);  //Recursion for left

            TreeNode storedRightNode = a.right;
            a.right = a.left; //make left as right
            a.left = null; //once the leaf is made as right, make left as null

            // we now should insert right to the bottom most of the tree

            TreeNode traverseNode = a.right; //This definitely is not null
            while(traverseNode.right != null){
                traverseNode = traverseNode.right;
            }

            traverseNode.right = storedRightNode;
        }
        flattenRecur(a.right); //Recursion for right. Don't bother about NULL. If it is null, we anyway set it correctly.
    }

    public TreeNode flattenCopied(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode right = root.right;
        root.right = flattenCopied(root.left);
        root.left = null;

        TreeNode curr = root;
        while(curr.right != null) {
            curr = curr.right;
        }

        curr.right = flattenCopied(right);

        return root;
    }

    //PreOrder Traversal would work

    //TODO practice this again

    public TreeNode flatten(TreeNode a) {

        TreeNode saveRoot = a;
        Stack<TreeNode> stack = new Stack<>();

        while(a != null){

            if(a.right != null) {
                stack.push(a.right); //save the right node in the stack
            }

            a.right = a.left;
            a.left = null;

            // Now pop the value from the stack as left child
            while (a.right == null && !stack.isEmpty()){
                a.right = stack.pop(); //N
            }

            a = a.right;
        }

        return saveRoot;
    }


}
