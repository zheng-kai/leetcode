package lt5;

public class Solution {
    public int[][] len; // 0 没有判断， num - 1 表示长度

    public String longestPalindrome(String s) {
        len = new int[s.length()][s.length()];
        int l = 0, r = s.length() - 1;
        int maxL = 0, maxR = 0, maxLen = 0;
        while (l <= r) {
            int m = maxPalindrome(s, l, r);
            if (m > maxLen) {
                maxLen = m;
                int sub = ((r - l + 1) - maxLen) / 2;
                maxL = l + sub;
                maxR = r - sub;
            }
            l++;
        }
        l = 0;
        r = s.length() - 1;
        while (l <= r) {
            int m = maxPalindrome(s, l, r);
            if (m > maxLen) {
                maxLen = m;
                int sub = ((r - l + 1) - maxLen) / 2;
                maxL = l + sub;
                maxR = r - sub;
            }
            r--;
        }
        return s.substring(maxL, maxR + 1);
    }

    private int maxPalindrome(String s, int l, int r) {
        if (len[l][r] != 0) {
            return len[l][r] - 1;
        }
        if (l == r) {
            len[l][r] = 1 + 1;
            return len[l][r] - 1;
        }
        if (l == r - 1) {
            if (s.charAt(l) == s.charAt(r)) {
                len[l][r] = 2 + 1;
                return len[l][r] - 1;
            } else {
                len[l][r] = 0 + 1;
                return len[l][r] - 1;
            }
        }
        int maxSub = maxPalindrome(s, l + 1, r - 1);
        if (maxSub == r - l + 1 - 2) {
            if (s.charAt(l) == s.charAt(r)) {
                len[l][r] = maxSub + 2 + 1;
            } else {
                len[l][r] = maxSub + 1;
            }
        } else {
            len[l][r] = maxSub + 1;
        }
        return len[l][r] - 1;
    }
}

//class Solution {
//    public String longestPalindrome(String s) {
//        if (s == null || s.length() < 1) {
//            return "";
//        }
//        int start = 0, end = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int len1 = expandAroundCenter(s, i, i);
//            int len2 = expandAroundCenter(s, i, i + 1);
//            int len = Math.max(len1, len2);
//            if (len > end - start) {
//                start = i - (len - 1) / 2;
//                end = i + len / 2;
//            }
//        }
//        return s.substring(start, end + 1);
//    }
//
//    public int expandAroundCenter(String s, int left, int right) {
//        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//            --left;
//            ++right;
//        }
//        return right - left - 1;
//    }
//}

