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
    
    public int closestValue(TreeNode root, double target) {
		
		if (root == null) return 0;
        int retval = root.val;
        
        TreeNode node = root;
        while (node != null) {
        	
        	if (Math.abs(node.val - target) < Math.abs(retval - target)) {
        		retval = node.val;
        	}
        	
        	if (target < node.val) {
        		node = node.left;
        	} else {
        		node = node.right;
        	}
        }
        
        return retval;
    }
    
}