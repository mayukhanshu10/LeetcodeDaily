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
    public int kthSmallest(TreeNode root, int k) {
        
        List<Integer> list = new ArrayList<>();
        findInorder(root,list);
        if(list.size()==1){
            return list.get(0);
        }
        return list.get(k-1);
        
    }
    
    private void findInorder(TreeNode root,List<Integer> arr){
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
                arr.add(curr.val);
                curr=curr.right;
            }else{
                TreeNode temp = curr.left;
                while(temp.right!=null && temp.right!=curr){
                    temp=temp.right;
                }
                if(temp.right==null){
                    temp.right=curr;
                    curr=curr.left;
                }else{
                    temp.right=null;
                    arr.add(curr.val);
                    curr=curr.right;
                }
            }
        }
    }
}