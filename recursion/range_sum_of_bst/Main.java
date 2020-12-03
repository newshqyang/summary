/*
@url https://leetcode-cn.com/problems/range-sum-of-bst/
@title 938. 二叉搜索树的范围和
@date 2020/12/3  17:00
思路：
一开始，我按照二叉树题目的惯用手法，采用递归的方式+全局变量的方式，
在每次递归时进行判断值的范围，在范围内就加到全局变量里，然后左右子树递归，
这样时间复杂度是1ms，以前提交时是7ms，有进步。

接着，我以一种自我优化的心态去思考如何优化这个算法，让它达到0ms，
然后我发现，可以通过添加判断条件的方式，减少递归次数，
这样优化后，时间复杂度减少到了0ms，good！
 */


package com.swsbty.recursion.range_sum_of_bst;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);
        System.out.println(new Solution().rangeSumBST(root, 7, 15));
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        getSum(root, low, high);
        return sum;
    }

    void getSum(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.val >= low && root.val <= high) {
            sum += root.val;
            getSum(root.left, low, high);
            getSum(root.right, low, high);
        } else if (root.val < low) {
            getSum(root.right, low, high);
        } else {
            getSum(root.left, low, high);
        }
    }
}