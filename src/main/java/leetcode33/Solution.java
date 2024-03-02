package leetcode33;

class Solution {
    public int search(int[] nums, int target) {
        return bs(nums, target, 0, nums.length - 1);
    }

    public int bs(int[] nums, int target, int l, int r) {
        if (l < 0 || r >= nums.length || l > r) {
            return -1;
        }
        int mid = (l + r) / 2;
        if (target == nums[l]) {
            return l;
        } else if (target == nums[r]) {
            return r;
        } else if (target == nums[mid]) {
            return mid;
        }
        if (target > nums[l]) {
            if (nums[mid] > nums[l]) {
                if (target < nums[mid]) {
                    return bs(nums, target, l + 1, mid - 1);
                } else {
                    return bs(nums, target, mid + 1, r - 1);
                }
            } else {
                return bs(nums, target, l + 1, mid - 1);
            }

        } else if (target < nums[r]) {
            if (nums[mid] < nums[r]) {
                if (target > nums[mid]) {
                    return bs(nums, target, mid + 1, r - 1);
                } else {
                    return bs(nums, target, l + 1, mid - 1);
                }
            } else {
                return bs(nums, target, mid + 1, r - 1);
            }

        } else {
            return -1;
        }

    }
}