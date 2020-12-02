import java.util.List;
import java.util.LinkedList;



public class Main {
    public static void main(String[] args) {
        int[][] r = new Solution().findContinuousSequence(9);
        for (int[] arr : r) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}


/*
看了官方解答后优化，主要对循环结束条件做了优化，
由原先的在target结束，改为在 (target - 1) / 2结束，
事实上确实如此，两个连续的数相加等于目标值的话，单个的数最大肯定不会超过目标值的一半。
*/
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> resultList = new LinkedList<>();
        int limit = (target - 1) / 2;
        for (int i = 1;i <= limit;i++) {
            int sum = i;
            for (int j = i + 1;;j++) {
                sum += j;
                if (sum == target) {
                    addResult(resultList, i, j);
                    break;
                } else if (sum > target) {
                    break;
                }
            }
        }
        return resultList.toArray(new int[resultList.size()][]);
    }

    private void addResult(List<int[]> resultList, int start, int end) {
        int[] array = new int[end - start + 1];
        int index = 0;
        for (int i = start;i <= end;i++) {
            array[index++] = i;
        }
        resultList.add(array);
    }
}


/*
我第一次写出来的代码，超时了
class MySolution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> resultList = new LinkedList<>();
        for (int i = 1;i < target;i++) {
            int sum = i;
            for (int j = i + 1;j < target;j++) {
                sum += j;
                if (sum == target) {
                    addResult(resultList, i, j);
                    break;
                }
            }
        }
        return resultList.toArray(new int[resultList.size()][]);
    }

    private void addResult(List<int[]> resultList, int start, int end) {
        int[] array = new int[end - start + 1];
        int index = 0;
        for (int i = start;i <= end;i++) {
            array[index++] = i;
        }
        resultList.add(array);
    }
}

*/