/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    List<Integer> list = new ArrayList<>();
    
    public boolean isValidBST(TreeNode root) {
        
        inOrder(root);
        
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i+1))
                return false;
        }
        
        return true;
    }
    
    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}