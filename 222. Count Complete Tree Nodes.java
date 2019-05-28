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

    int count = 0;

    public int countNodes(TreeNode root) {
        if (root == null) {
            return count;
        }

        count += 1;
        count = countNodes(root.left);
        count = countNodes(root.right);
        return count;
    }
}
