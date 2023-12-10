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



/*The time complexity of the inorder traversal is O(n), where n is the number of nodes in the binary tree. This is because, in the worst case, we may have to visit all the nodes in the tree. The recursive nature of the algorithm ensures that each node is processed once, and the work done at each node is constant.
*/

/*It's worth noting that the space complexity of the recursive inorder traversal is O(h), where h is the height of the binary tree. This is due to the recursive call stack, which can go as deep as the height of the tree. In the worst case, for a skewed tree (where each node has only one child), the height could be equal to the number of nodes, resulting in O(n) space complexity. However, for a balanced binary tree, the height is logarithmic in the number of nodes, leading to a space complexity of O(log n).
*/