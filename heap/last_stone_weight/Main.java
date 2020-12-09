/*
@url https://leetcode-cn.com/problems/last-stone-weight/
@title 1046. 最后一块石头的重量
@date 2020/12/9  15:45
思路：
一开始，我不太熟悉堆的概念，于是先去了解，
了解到，堆就是一棵完全二叉树，
还是不知道怎么写，于是看了排名第一的题解

题解是用c++语言写的，使用priority_queue这个类，
查阅资料后，我了解到，它就是Java中的PriorityQueue类，poll()相当于pop()，add()和offer()相当于push()。
区别是c++中的是大顶堆，完全符合题意，
而Java中的是小顶堆，需要修改顺序。
PriorityQueue修改顺序的方式是在实例化对象时自定义Comparator参数，
在compare函数中将o2减去o1即可。
接着，实例化queue后，将数组装入queue中，
使用while循环，判断条件是当queue的大小>=2时继续，
每次循环，将queue中的前两个元素取出并相减，将大于0的余数再次添加到queue中，
最后返回queue中的第一个元素即可，若此时已无元素则按照题意返回0。
 */



package com.swsbty.heap.last_stone_weight;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Solution().lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }

}


class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : stones) {
            queue.offer(i);
        }
        while (queue.size() >= 2) {
            int m = queue.poll() - queue.poll();
            if (m > 0) {
                queue.offer(m);
            }
        }
        return queue.poll();
    }
}