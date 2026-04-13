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
    public boolean checkTree(TreeNode root) {
        // if(root.left==null && root.right==null){
        //     return true;
        // }
            if(root==null){
                return true;
            }
            if(root.left==null && root.right==null){
                return true;
            }
            int sum=root.left.val + root.right.val;
            if(sum!=root.val){
                return false;
            }
            boolean ans1=checkTree(root.left);
            boolean ans2=checkTree(root.right);
            if(ans1==true && ans2==true){
                return true;
            }
            return false;

    }
}