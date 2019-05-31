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
        
    public boolean isValidBST(TreeNode root) {
        
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }
    
    private boolean isValidBST(TreeNode root, long min, long max) {
        
        if (root == null) return true;
        
        // if (root.left == null && root.right == null) return true;
        
        if (min < root.val && root.val < max) {
            boolean left = false;
            if (root.left == null) {
                min = root.val;
                left = true;
            } else {
                left = isValidBST(root.left, min, root.val);
            }
            // System.out.println("min: " + min);
            
            boolean right = false;
            if (root.right == null) {
                max = root.val;
                right = true;
            } else {
                right = isValidBST(root.right, root.val, max);
            }
            // System.out.println("max: " + max);
            
            return left && right;
        } else {
            return false;
        }
    }
}