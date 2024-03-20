package leetcode4;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        m = nums1.length;
        n = nums2.length;
        int l = 0, r = m;
        while (true) {
            // 使用i,j分割nums1,nums2。验证是否左半小于右半。
            // 因为中位数的特性，i和j 满足关系 i + j = (n + m + 1) / 2
            int i = (l + r) / 2;
            int j = (n + m + 1) / 2 - i;
            int leftMax = Math.max(get(nums1, i - 1), get(nums2, j - 1));
            int rightMin = Math.min(get(nums1, i), get(nums2, j));
            if (leftMax <= rightMin) {
                if ((n + m) % 2 == 0) {
                    return (leftMax + rightMin) * 1.0 / 2;
                } else {
                    return leftMax;
                }
            } else {
                if (get(nums1, i - 1) > get(nums2, j)) {
                    r = i - 1;
                } else {
                    l = i + 1;
                }
            }
        }
    }

    public int get(int[] arr, int index) {
        if (index < 0) {
            return Integer.MIN_VALUE;
        } else if (index >= arr.length) {
            return Integer.MAX_VALUE;
        }
        return arr[index];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
    }
}