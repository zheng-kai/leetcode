package leetcode3;

import java.util.HashSet;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 解法 ： 滑动窗口
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int lIndex = 0;
        int rIndex = 0;
        while (lIndex <= rIndex && rIndex < s.length()) {
            if (!containDedup(s, lIndex, rIndex)) {
                max = Math.max(max, rIndex - lIndex + 1);
                rIndex ++;
            }else {
                lIndex ++;
            }
        }
        return max;
    }

    private boolean containDedup(String s, int l, int r) {
        HashSet<Character> set = new HashSet<Character>();
        for (int i = l; i <= r; i++) {
            set.add(s.charAt(i));
        }
        return set.size() < (r - l + 1);
    }

}

