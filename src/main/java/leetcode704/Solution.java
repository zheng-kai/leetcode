package leetcode704;

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        if (target < nums[l] || target > nums[r]) {
            return -1;
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            int n = nums[mid];
            if (n == target) {
                return mid;
            } else if (n > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }


}