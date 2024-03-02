package leetcode200;

class Solution {
    boolean[][] visited;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited(grid, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    public boolean visited(char[][] grid, int r, int c) {
        if (isIsland(grid, r, c)) {
            if (visited[r][c]) {
                return true;
            }
            visited[r][c] = true;
            visited(grid, r + 1, c );
            visited(grid, r - 1, c);
            visited(grid, r , c + 1);
            visited(grid, r , c - 1);
            return false;
        }
        return true;
    }

    private boolean isIsland(char[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        if (r < 0 || c < 0 || r >= m || c >= n) {
            return false;
        }
        return grid[r][c] == '1';
    }

    public static void main(String[] args) {
        char[][] g = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        Solution s = new Solution();
        s.numIslands(g);
    }
}