/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private TreeNode dfs(TreeNode root, int min, int max) {
        if (root.val < min) {
            return dfs(root.right, min, max);
        } else if (root.val > max) {
            return dfs(root.left, min, max);
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return root == null ? null : dfs(root, Math.min(p.val, q.val), Math.max(p.val, q.val));
    }
}
