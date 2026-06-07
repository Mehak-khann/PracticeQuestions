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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode>mp=new HashMap<>();
        Set<Integer>childSet=new HashSet<>();

        for(int[] d:descriptions){
            int parent = d[0];
            int child=d[1];
            boolean isLeft = d[2]==1;

            mp.putIfAbsent(parent,new TreeNode(parent));//only the node is created in the air
            mp.putIfAbsent(child,new TreeNode(child));// the node  is created in the air...no linking 

            if(isLeft){
                //linking the child with the parent
                mp.get(parent).left=mp.get(child);
                //temp/root/node==mp.get(parent)
                // to set it at left--> temp.left--->mp.get(parent).left
            }
            else{
                mp.get(parent).right=mp.get(child);
            }
            childSet.add(child);

        }

        for(int[] d:descriptions){
            int parent = d[0];
            if(!childSet.contains(parent)){
                return mp.get(parent);
            }
        }
        return null;
    }
}