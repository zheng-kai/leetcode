package leetcode15;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int startIndex = 0; startIndex < nums.length - 2; startIndex++) {
            if (startIndex > 0 && nums[startIndex] == nums[startIndex - 1]){
                continue;
            }
            int l = startIndex + 1;
            int r = nums.length - 1;
            int three = nums[startIndex];
            while (l < r) {
                int sum = nums[l] + nums[r] + three;
                if (sum == 0) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(nums[l]);
                    pair.add(nums[r]);
                    pair.add(nums[startIndex]);
                    res.add(pair);
                    while ( l+1 < nums.length && l+1 < r && nums[l + 1] == nums[l]) {
                        l++;
                    }
                    while (r - 1 >= 0 && l < r - 1 && nums[r - 1] == nums[r]) {
                        r--;
                    }
                    l ++;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
