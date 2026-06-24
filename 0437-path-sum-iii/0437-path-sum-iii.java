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
    int count=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return count;
        Map<Long,Integer> map= new HashMap<>();
        map.put(0L,1);
        findCount(root,targetSum,map,0L);
        return count;
    }

    public void findCount(TreeNode root,int targetSum,Map<Long,Integer> map,long runningSum){
        if(root==null) return;
        runningSum+=root.val;
        long needed=runningSum-targetSum;
        if(map.containsKey(needed)) count+=map.get(needed);
        map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);

        findCount(root.left,targetSum,map,runningSum);
        findCount(root.right,targetSum,map,runningSum);
        
        int freq=map.get(runningSum);
        if(freq==0) map.remove(runningSum);
        else map.put(runningSum, map.get(runningSum)-1);

    }
}