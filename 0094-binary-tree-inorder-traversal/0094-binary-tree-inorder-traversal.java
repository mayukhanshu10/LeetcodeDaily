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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getInorder(root,list);
        return list;
    }
    
    private void getInorder(TreeNode root,List<Integer> list){
        
        if(root==null){
            return;
        }
        
        getInorder(root.left,list);
        list.add(root.val);
        getInorder(root.right,list);
    }
}