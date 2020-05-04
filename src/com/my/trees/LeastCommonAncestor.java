package com.my.trees;

import java.util.ArrayList;
import java.util.List;

public class LeastCommonAncestor {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public int lca(TreeNode A, int B, int C) {
        List<TreeNode> list1 = new ArrayList<>();
        if(!lca(A,B,new ArrayList<>(), list1)){
            return -1;
        }


        List<TreeNode> list2 = new ArrayList<>();
        if(!lca(A,C,new ArrayList<>(), list2)){
            return -1;
        }

        TreeNode rootNode = A;
        for(int i=0;i<list1.size() && i<list2.size();i++){
            if(list1.get(i).val == list2.get(i).val){
                rootNode = list1.get(i);
            } else {
                break;
            }

        }

        return rootNode.val;
    }

    public boolean lca(TreeNode A, int B, List<TreeNode> values, List<TreeNode> result) {
        if(A == null){
            return false;
        }

        values.add(A);

        if(A.val == B){
            result.addAll(values);
            return true;
        }

        if(A.left != null){
            if(lca(A.left,B, new ArrayList<>(values),result)){
                return true;
            }
        }

        if(A.right != null){
            if(lca(A.right,B, new ArrayList<>(values),result)){
                return true;
            }
        }
        return false;
    }

}
