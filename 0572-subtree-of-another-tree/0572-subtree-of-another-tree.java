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
    boolean check=false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        return isTree(root, subRoot);
    }

    public boolean isTree(TreeNode root, TreeNode subRoot) {
    if(root==null) return false;
       if(root.val==subRoot.val&&isSame(root,subRoot)){
            return true;
       }
    return isTree(root.left, subRoot)||isTree(root.right, subRoot);

    }

    public boolean isSame(TreeNode root, TreeNode subRoot){
        if(root==null&&subRoot==null) return true;
        if(root==null||subRoot==null) return false;
        if(root.val!=subRoot.val){
            return false;
        }
        return isSame(root.left,subRoot.left)&&isSame(root.right,subRoot.right);
    }

}