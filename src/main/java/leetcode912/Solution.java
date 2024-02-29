package leetcode912;

// 计数排序
public class Solution {
    public int[] sortArray(int[] nums) {
        int[] count = new int[100000 + 1];
        for (int num : nums) {
            count[num + 5 * 10000]++;
        }
        int[] res = new int[nums.length];
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            int c = count[i];
            while (c-- > 0) {
                res[index++] = i - 5 * 10000;
            }
        }
        return res;
    }
}
