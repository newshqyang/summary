/*
@url https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
@title 783. 二叉搜索树节点最小距离
@date 2020/12/4  18:04

思路：

我第一次的时候做错了，
第二次看了题解，
题解的思路是定义2个全局变量pre、min，
采用中序遍历递归计算最小差值，
因为二叉搜索树在中序遍历时值是按照从小到大的顺序，
所以用pre来存储前一个节点的值，
通过当前节点值减去pre求差值，和当前最小差值比较的方式，
求得最终的最小差值。
 */




package com.swsbty.recursion.minimum_distance_between_bst_nodes;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        System.out.println(new Solution().minDiffInBST(root));
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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Integer pre, min;
    public int minDiffInBST(TreeNode root) {
        pre = null;
        min = Integer.MAX_VALUE;
        dfs(root);
        return min;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != null) {
            min = Math.min(min, root.val - pre);
        }
        pre = root.val;
        dfs(root.right);
    }
}






/*
我没看官解写的，运行错误
class MySolution {
    int min = 98;
    public int minDiffInBST(TreeNode root) {
        getMin(root);
        return min;
    }

    void getMin(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            int leftMin = root.val - root.left.val;
            min = Math.min(min, leftMin);
            getMin(root.left);
        }
        if (root.right != null) {
            int rightMin = root.right.val - root.val;
            min = Math.min(min, rightMin);
            getMin(root.right);
        }
    }
}

*/