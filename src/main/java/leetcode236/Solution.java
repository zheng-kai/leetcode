package leetcode236;

import javax.lang.model.util.Elements;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    private TreeNode result;
    private int maxLevel = -1;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root,p,q,0);
        return result;
    }

    public int find(TreeNode root, TreeNode p, TreeNode q, int level) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        if (root == p || root == q) {
            count++;
        }
        count += find(root.left, p, q, level + 1);
        count += find(root.right, p, q, level + 1);
        if (count == 2) {
            if (level > maxLevel) {
                maxLevel = level;
                result = root;
            }
        }
        return count;
    }
}