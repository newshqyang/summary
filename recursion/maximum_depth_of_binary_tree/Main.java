/*
@url https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
@title 104. 二叉树的最大深度
@date 2020/12/4  9:47

思路：
定义一个全局变量maxDepth用来记录最大深度，
然后通递归的方式沿着树每一条分支往下记录分支的深度，
每一条分支到达尾部的时候，将该分支的深度和全局变量maxDepth比较，
保留最大的那个深度，
最后返回该全局变量。

 */




package com.swsbty.recursion.maximum_depth_of_binary_tree;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().maxDepth(root));
    }

}




class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxDepth;
    public int maxDepth(TreeNode root) {
        recursionTree(root, 0);
        return maxDepth;
    }

    void recursionTree(TreeNode root, int depth) {
        if (root == null) {
            maxDepth = Math.max(maxDepth, depth);
            return;
        }
        depth++;
        recursionTree(root.left, depth);
        recursionTree(root.right, depth);
    }
}