package leetcode88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copy = nums1.clone();
        int i1 = 0, i2 = 0, insert = 0;
        while (i1 < m && i2 < n) {
            int n1 = copy[i1];
            int n2 = nums2[i2];
            if (n1 < n2) {
                nums1[insert] = n1;
                i1++;
            } else {
                nums1[insert] = n2;
                i2++;
            }
            insert++;
        }
        while (i2 < n) {
            nums1[insert] = nums2[i2];
            insert++;
            i2++;
        }
        while (i1 < m) {
            nums1[insert] = copy[i1];
            insert++;
            i1++;
        }
    }
}