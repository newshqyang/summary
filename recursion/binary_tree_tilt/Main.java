/*
@url https://leetcode-cn.com/problems/binary-tree-tilt/
@title 563. 二叉树的坡度
@date 2020/12/3  17:55
思路：
我想了半个小时，没想出头绪

然后看了题解。。
题解的思路是利用递归的特点，先计算左子节点的坡度，再计算右子节点的坡度，
将两个坡度求差值后累加到全局变量中，返回左右坡度加当前节点值的和。
 */



package com.swsbty.recursion.binary_tree_tilt;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new Solution().findTilt(root));
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
    int sum = 0;
    public int findTilt(TreeNode root) {
        getDifference(root);
        return sum;
    }

    int getDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDifference(root.left);
        int right = getDifference(root.right);
        sum += Math.abs(left - right);
        return left + right + root.val;
    }
}