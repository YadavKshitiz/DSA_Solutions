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

    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map =
            new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        vertical(root, 0, 0);

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> innerList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    innerList.add(pq.poll());
                }
            }

            result.add(innerList);
        }
        return result;
    }

    public void vertical(TreeNode root, int row, int col) {
        if (root == null) {
            return;
        }
        map
            .computeIfAbsent(col, k -> new TreeMap<>())
            .computeIfAbsent(row, k -> new PriorityQueue<>())
            .offer(root.val);
        vertical(root.left, row + 1, col - 1);
        vertical(root.right, row + 1, col + 1);
    }
}
     