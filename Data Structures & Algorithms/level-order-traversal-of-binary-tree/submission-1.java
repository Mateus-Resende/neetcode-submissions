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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return List.of();

        Deque<TreeNode> queue = new ArrayDeque<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int level = 0;

        queue.addLast(root);
        
        while(queue.peek() != null) {
            map.put(level, new ArrayList<>());
            int currentSize = queue.size();

            for (int i = 0; i < currentSize; i++) {
                TreeNode node = queue.poll();
                map.get(level).add(node.val);
                
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }

            level++;
        }

        return map.values().stream().toList();
    }
}
