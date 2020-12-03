package com.swsbty.binary_search.he_wei_sde_lian_xu_zheng_shu_xu_lie_lcof;

/*
这是我第一次写的代码，没看题解，报错了。。。
看了题解之后，我觉得错误原因应该是没有看清题意。。。

利用二分查找算法，
每次遍历时，判断该值是否等于正确值，
若小于正确值，说明左半边的数组中存在缺失数字，
若等于正确值，说明右半边的数组中存在缺失数字，
遍历到最后，若数组的个数只有2时，说明找到了缺失值，
左边值+1后，即是所求值。

class MySolution {
    public int missingNumber(int[] nums) {
        if (nums.length == 1) {
            if (nums[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (nums.length == 2) {
            if (nums[0] == 0) {
                if (nums[1] == 1) {
                    return 2;
                } else {
                    return 1;
                }
            } else {
                return 0;
            }
        }
        int left = 0;
        int right = nums.length - 1;
        while (right - left > 1) {
            int t = (left + right) / 2;
            int v = nums[(right + left) / 2];
            if (v < t) {
                // 在左半边
                right = t;
            } else if (v == t) {
                // 在右半边
                left = t;
            }
        }
        // 找到了
        return nums[left] + 1;
    }
}

@Date 2020/12/2
*/


/*
本题考查了 二分查找，需要在一个递增的数组中找出缺失的那个数，
数组长度为n，正确的数组应当元素从 0开始 一直到 n-1，
但是参数中的数组缺少了一个数，需要通过算法求出这个缺失的数字。

@url https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 */

public class Main {
    public static void main(String[] args) {
        int[] sample = new int[] {0, 1, 3};
        System.out.println(new Solution().missingNumber(sample));
    }
}


class Solution {
    /*
    参考链接：
    https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/solution/mian-shi-ti-53-ii-0n-1zhong-que-shi-de-shu-zi-er-f/
     */
    public int missingNumber(int[] nums) {
        int i = 0;  // 左边开始的数
        int j = nums.length - 1;    // 右边开始的数
        while (i <= j) {        // 有“=”是因为考虑到有n=1的情况
            int m = (i + j) / 2;    // 求出正确的中间值
            if (nums[m] == m) i = m + 1;    // 如果数组中该位的值和正确值相等，则缺失值在右半边
            else j = m - 1;         // 不相等，则缺失值在左半边
        }               // 因为最终结果会在右子数组的第一个元素，
        return i;       // 所以跳出时，变量 i 和 j 分别指向 “右子数组的首位元素” 和 “左子数组的末位元素” 。因此返回 i 即可。
    }
}




