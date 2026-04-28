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
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=minDepth(root.left);
        int right=minDepth(root.right);
        if(root.left==null || root.right==null){
            return 1+left+right;
            //as if anyone of these is null then its answer will be 0 so won't make any difference during additoin
        }
        return 1+Math.min(left,right);
    }
}