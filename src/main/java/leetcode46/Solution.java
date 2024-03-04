package leetcode46;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        find(nums, 0);
        return res;
    }

    public void find(int[] nums, int index) {
        if (index == nums.length){
            save(nums);
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            find(nums, index + 1);
            swap(nums, i, index);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void save(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for (int num : nums) {
            l.add(num);
        }
        res.add(l);
    }
}