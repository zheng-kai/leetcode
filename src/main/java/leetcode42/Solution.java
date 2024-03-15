package leetcode42;

class Solution {
    public int trap(int[] height) {
        if (height.length == 1) {
            return 0;
        }
        int maxIndex = 0;
        int maxValue = height[0];
        for (int i = 0; i < height.length; i++) {
            if (maxValue < height[i]) {
                maxValue = height[i];
                maxIndex = i;
            }
        }
        int sum = 0;
        int maxLevel = 0;
        for (int i = 0; i < maxIndex; i++) {
            maxLevel = Math.max(height[i], maxLevel);
            sum += Math.max(maxLevel - height[i],0);
        }
        maxLevel = 0;
        for (int i = height.length - 1; i > maxIndex; i--) {
            maxLevel = Math.max(height[i], maxLevel);
            sum += Math.max(maxLevel - height[i],0);
        }
        return sum;
    }
}