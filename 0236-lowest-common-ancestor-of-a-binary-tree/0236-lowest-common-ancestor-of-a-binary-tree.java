/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    //approach 1
   private  TreeNode ans=null;
    public int fun(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return 0;
        }
        int left=fun(root.left,p,q);
        int right=fun(root.right,p,q);

        int self=0;
        if(root==p || root==q){
            self=1;
        }
        int total=left+self+right;
        if(total ==2 && ans==null){
            ans=root;
        }
        return total;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

//    int[] total=new int[1];
  ans=null;
   fun(root,p,q);
   return ans;
        
    }


    //approach2

//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//     // Base Case: if we hit null or find one of the nodes
//     if (root == null || root == p || root == q) {
//         return root;
//     }

//     // Look for p and q in the left and right subtrees
//     TreeNode left = lowestCommonAncestor(root.left, p, q);
//     TreeNode right = lowestCommonAncestor(root.right, p, q);

//     // If left and right both returned something, it means p is on one side 
//     // and q is on the other. This current node is the LCA!
//     if (left != null && right != null) {
//         return root;
//     }

//     // Otherwise, return whichever side found a node
//     return (left != null) ? left : right;
// }
}