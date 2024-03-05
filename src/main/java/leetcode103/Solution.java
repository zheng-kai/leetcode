package leetcode103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        int level = 0;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            if (level % 2 == 0) {
                List<Integer> l = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = nodes.pop();
                    l.add(node.val);
                    if (node.left != null) {
                        nodes.add(node.left);
                    }
                    if (node.right != null) {
                        nodes.add(node.right);
                    }
                }
                res.add(l);
            } else {
                List<Integer> l = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = nodes.removeLast();
                    l.add(node.val);
                    if (node.right != null) {
                        nodes.addFirst(node.right);
                    }
                    if (node.left != null) {
                        nodes.addFirst(node.left);
                    }
                }
                res.add(l);
            }
            level++;
        }
        return res;
    }
}