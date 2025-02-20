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
    public boolean isBalanced(TreeNode root) {
        int ans = height(root);
        if(ans==-1)
            return false;
        return true;
    }
    
    public int height(TreeNode root){
        if(root==null)
            return 0;
        
        int lf = height(root.left);
        int rh = height(root.right);
        
        if(Math.abs(lf-rh)>1)
            return -1;
        
        //From Subtree if any subtree returned -1
        if(lf==-1 || rh==-1)
            return -1;
        
        return Math.max(lf,rh)+1;
    }
}