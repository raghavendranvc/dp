package com.my.trees;

public class SumNodeTree {

    public static class Node{
        Node left;
        Node right;
        int value;
        public Node(int value){
            this.value = value;
        }
    }

    public static class BinaryTree {
        Node root;
        public BinaryTree(Node root){
            this.root = root;
        }

        public void printInOrder(Node node){
            if(node == null){
                return;
            }

            printInOrder(node.left);
            System.out.print(node.value+" ");
            printInOrder(node.right);
        }


        public int sumTree(Node node){

            if(node == null) {
                return 0;
            }

            int save_val = node.value;

            node.value = sumTree(node.left) + sumTree(node.right);

            return save_val + node.value;
        }
    }


    public static void main(String args[])  {

        BinaryTree tree = new BinaryTree(new Node(10));

        /* Constructing tree given in the above figure */
        tree.root.left = new Node(-2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(-4);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(5);

        System.out.println("Original Tree Inorder:");
        tree.printInOrder(tree.root);
        System.out.println();
        tree.sumTree(tree.root);

        System.out.println("Inorder Traversal of the resultant tree is:");
        tree.printInOrder(tree.root);
        System.out.println();
    }
}
