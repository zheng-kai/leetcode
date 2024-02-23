package leetcode215;


class Solution {

    public int findKthLargest(int[] nums, int k) {
        int[] counts = new int[20001];
        for (int num : nums) {
            counts[num + 10000] += 1;
        }
        int count = 0;
        for (int i = counts.length - 1; i >=0; i--) {
            count += counts[i];
            if (count >= k){
                return i - 10000;
            }
        }
        return -1;
    }
}