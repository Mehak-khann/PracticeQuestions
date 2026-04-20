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

 //approach 1

//   public void serialize(TreeNode root,StringBuilder sb){
//         if(root==null){
//             sb.append(",#,");
//             return;
//         }
//         sb.append(",");
//         sb.append(root.val);
//         sb.append(",");

//         serialize(root.left,sb);
//         serialize(root.right,sb);
//     }
//     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//         StringBuilder t=new StringBuilder();
//         StringBuilder s=new StringBuilder();
//         serialize(root,t);
//         serialize(subRoot,s);
//         if(t.toString().contains(s.toString())){
//             return true;
//         }
//         return false;
//     }

//approach 2
class Solution {
    public boolean identical(TreeNode p,TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        boolean ans1=identical(p.left,q.left);
        boolean ans2=identical(p.right,q.right);

        if(ans1==true && ans2==true){
            return true;
        }
        return false;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null) return true;
        if(root==null)return false;
      
        boolean ans1=identical(root,subRoot);
        
        if(ans1 ==true){
            return true;
        }

        boolean left=isSubtree(root.left,subRoot);
        boolean right = isSubtree(root.right,subRoot);

        if(left==true || right==true){
            return true;
        }
        return false;
    }
}