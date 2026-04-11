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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if((p==null && q!=null) || (p!=null && q==null)){
            return false;
        }
        Queue<TreeNode>q1=new LinkedList<>();
       Queue<TreeNode>q2=new LinkedList<>();
        q1.add(p);
        q2.add(q);
        while(q1.size()>0 && q2.size()>0){
            TreeNode c1= q1.poll();
            TreeNode c2=q2.poll();
            if(c1.val!=c2.val){
                return false;
            }
            // if(c1.left!=null && c2.left!=null){
            //     // return isSameTree(c1.left,c2.left);
                
            // }
            // if(c1.right!=null && c2.right!=null){
            //     return isSameTree(c1.right,c2.right);
            // }

            if (c1.left != null && c2.left != null) {
                q1.add(c1.left);
                q2.add(c2.left);
            } else if (c1.left != c2.left) { 
                
                return false; 
            }

         
            if (c1.right != null && c2.right != null) {
                q1.add(c1.right);
                q2.add(c2.right);
            } else if (c1.right != c2.right) {
                return false;
            }
        }


        return true;
    }
}