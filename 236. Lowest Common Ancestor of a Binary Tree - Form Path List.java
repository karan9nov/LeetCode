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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode retval = root;

        List<TreeNode> pathP = findPath(root, p);
        List<TreeNode> pathQ = findPath(root, q);

        for (int i = 0; i < pathP.size() && i < pathQ.size(); i++) {
            if (pathP.get(i) == pathQ.get(i))
                retval = pathP.get(i);
        }

        return retval;

    }

    private List<TreeNode> findPath(TreeNode root, TreeNode node) {

        List<TreeNode> retval = new ArrayList<>();
        findPath(root, node, retval);
        return retval;

    }

    private boolean findPath(TreeNode root, TreeNode node, List<TreeNode> list) {

        if (root == null) return false;
        if (root == node) {
            list.add(root);
            return true;
        }

        list.add(root);
        if (findPath(root.left, node, list)) {
            return true;
        } else if(findPath(root.right, node,list)){
            return true;
        } else {
            list.remove(list.size() - 1);
        }
        return false;
    }
}
