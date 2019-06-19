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
    
    int i = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list.get(k-1);
    }
    
    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) 
            return;
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}