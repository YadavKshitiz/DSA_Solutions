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
    int start = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int leftBound = 0, rightBound = inorder.length - 1;
        int i = 0;
        while (i < inorder.length) {
            map.put(inorder[i], i);
            i++;
        }
        return build(preorder, leftBound, rightBound);

    }

    public TreeNode build(int[] preorder, int leftBound, int rightBound) {
        if (leftBound > rightBound) {
            return null;
        }

        TreeNode root;
        root = new TreeNode(preorder[start++]);
        int rootIndex = map.get(root.val);
        root.left = build(preorder, leftBound, rootIndex - 1);
        root.right = build(preorder, rootIndex + 1, rightBound);
        return root;
    }
}