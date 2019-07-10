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
	public boolean isSubtree(TreeNode s, TreeNode t) {
		
		if (s == null && t == null) return true;
		if (s == null) return false;
		if (t == null) return false;
		
		return isEqual(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

	private boolean isEqual(TreeNode s, TreeNode t) {
		// TODO Auto-generated method stub
		if (s == null && t == null) return true;
		if (s == null) return false;
		if (t == null) return false;
		
		return s.val == t.val && isEqual(s.left, t.left) && isEqual(s.right, t.right);
	}
}