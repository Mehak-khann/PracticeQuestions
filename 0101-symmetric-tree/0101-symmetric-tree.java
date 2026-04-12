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
    public boolean check(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        boolean ans1=check(p.left,q.right);
        boolean ans2=check(p.right,q.left);
        if(ans1==true && ans2==true){
            return true;
        }
        return false;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
      boolean ans=check(root.left,root.right);
      return ans;
    }
}