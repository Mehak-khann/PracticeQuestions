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
    public void serialize(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append(",#,");
            return;
        }
        sb.append(",");
        sb.append(root.val);
        sb.append(",");

        serialize(root.left,sb);
        serialize(root.right,sb);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder t=new StringBuilder();
        StringBuilder s=new StringBuilder();
        serialize(root,t);
        serialize(subRoot,s);
        if(t.toString().contains(s.toString())){
            return true;
        }
        return false;
    }
}