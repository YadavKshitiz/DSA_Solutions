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
    Map<Integer, Integer> postMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            postMap.put(postorder[i], i);
        }
        return build(preorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] postorder,
                           int postStart, int postEnd) {
if(postStart>postEnd) return null;
        TreeNode root = new TreeNode(preorder[start++]);
        if (postStart == postEnd) {
            return root;
        }

        int leftRoot = preorder[start];
        int leftRootIndex = postMap.get(leftRoot);

        root.left = build(preorder, postorder,
                          postStart, leftRootIndex);
        root.right = build(preorder, postorder,
                           leftRootIndex + 1, postEnd - 1);

        return root;
    }
}