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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        findPath(root,targetSum,0,new ArrayList<>(),result);
        return result;
    }

    public void findPath(TreeNode root, int targetSum, int currentSum,List<Integer> current,List<List<Integer>> result){
        if(root==null) return;
        if(currentSum+root.val==targetSum &&root.left==null&&root.right==null){
            current.add(root.val);
            result.add(new ArrayList<>(current));
            current.remove(current.size()-1);
            return;
        }
        current.add(root.val);
        currentSum+=root.val;
        findPath(root.left,targetSum,currentSum,current,result);
        findPath(root.right,targetSum,currentSum,current,result);
        current.remove(current.size()-1);
        currentSum-=root.val;
    }
}