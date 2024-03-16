package leetcode72;

class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dis = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            dis[i][0] = i;
        }
        for (int i = 0; i < word2.length() + 1; i++) {
            dis[0][i] = i;
        }
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                int a = 1 + Math.min(dis[i][j - 1], dis[i - 1][j]);
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dis[i][j] = Math.min(a, dis[i - 1][j - 1]);
                } else {
                    dis[i][j] = Math.min(a, dis[i - 1][j - 1] + 1);
                }
            }
        }
        return dis[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.minDistance("horse", "ros");
    }
}