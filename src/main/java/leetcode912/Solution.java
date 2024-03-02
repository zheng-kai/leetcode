package leetcode912;

// 计数排序
//public class Solution {
//    public int[] sortArray(int[] nums) {
//        int[] count = new int[100000 + 1];
//        for (int num : nums) {
//            count[num + 5 * 10000]++;
//        }
//        int[] res = new int[nums.length];
//        int index = 0;
//        for (int i = 0; i < count.length; i++) {
//            int c = count[i];
//            while (c-- > 0) {
//                res[index++] = i - 5 * 10000;
//            }
//        }
//        return res;
//    }
//}

// 快速排序
public class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        int pivot = nums[mid];
        swap(nums, mid, r);
        int smaller = l - 1;
        int larger = l;
        while (larger < r) {
            if (nums[larger] < pivot) {
                smaller++;
                swap(nums, smaller, larger);
            }
            larger++;
        }
        swap(nums, smaller + 1, r);
        quickSort(nums, l, smaller);
        quickSort(nums, smaller + 2, r);
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}