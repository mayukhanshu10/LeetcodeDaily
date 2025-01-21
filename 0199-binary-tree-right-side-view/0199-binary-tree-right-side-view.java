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
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> ans = new ArrayList<>();
        ans.add(root.val);
        while(q.size()>0){
            TreeNode t = q.remove();
            if(t==null){
                if (!q.isEmpty()) {
                    q.add(null);
                    ans.add(q.peek().val);
                }
            }else{
                if(t.right!=null){
                    q.add(t.right);
                }
                if(t.left!=null){
                    q.add(t.left);
                }
            }

        }
        return ans;
    }
}