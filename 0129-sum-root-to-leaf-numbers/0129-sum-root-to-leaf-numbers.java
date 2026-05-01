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
    public void fun(TreeNode root,StringBuilder sb,List<Integer>res){
        if(root==null){
            return;
        }
        int n =sb.length();
         sb.append(root.val);
        if(root.left==null && root.right==null){
           // sb.append(root.val);
            res.add(Integer.parseInt(sb.toString()));
        
        }
       
        else{
             if(root.left!=null){
            // sb.append(root.val);
            fun(root.left,sb,res);
              }
         if(root.right!=null){
            // sb.append(root.val);
            fun(root.right,sb,res);
              }
        }
        sb.setLength(n);
    }
    public int sumNumbers(TreeNode root) {
        if(root.left==null && root.right==null){
            return root.val;
        }
        StringBuilder sb=new StringBuilder();
        List<Integer>res=new ArrayList<>();
        fun(root,sb,res);
        int sum=0;
        for(int i=0;i<res.size();i++){
            sum+=res.get(i);
        }
        return sum;
    }
}