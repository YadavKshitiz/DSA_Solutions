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
    int maxDepth=0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null) return result;
        result.add(root.val);
        rightView(root,0,result);
        return result;
    }

    public void rightView(TreeNode root, int currentDepth, List<Integer> result){
        if(root==null){
            return;
        }
        if(currentDepth>maxDepth){
            result.add(root.val);
            maxDepth=currentDepth;
        }
        rightView(root.right,currentDepth+1,result);
        rightView(root.left,currentDepth+1,result);

    }
}