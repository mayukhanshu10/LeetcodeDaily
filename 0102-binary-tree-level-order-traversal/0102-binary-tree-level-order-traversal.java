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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> tempAns = new ArrayList<>();
        while(q.size()>0){
            TreeNode t = q.remove();
            if(t==null){
                ans.add(tempAns);
                tempAns = new ArrayList<>();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            }else{
                tempAns.add(t.val);
                if(t.left!=null){
                    q.add(t.left);
                }
                if(t.right!=null){
                    q.add(t.right);
                }
            }

        }
        return ans;
    }
}