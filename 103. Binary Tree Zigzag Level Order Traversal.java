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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) return new ArrayList<>();

        Stack<TreeNode> q1 = new Stack<>();
        Stack<TreeNode> q2 = new Stack<>();

        List<List<Integer>> retval = new ArrayList<>();

        q1.push(root);

        while (!q1.isEmpty() || !q2.isEmpty()) {

            List<Integer> tempList = new ArrayList<>();

            while(!q1.isEmpty()) {
                TreeNode temp = q1.pop();
                tempList.add(temp.val);
                if (temp.left != null) q2.push(temp.left);
                if (temp.right != null) q2.push(temp.right);
            }

            if (!tempList.isEmpty()) {
                retval.add(new ArrayList<>(tempList));
                tempList.clear();
            }

            while(!q2.isEmpty()) {
                TreeNode temp = q2.pop();
                tempList.add(temp.val);
                if (temp.right != null) q1.push(temp.right);
                if (temp.left != null) q1.push(temp.left);
            }

            if (!tempList.isEmpty()) {
                retval.add(new ArrayList<>(tempList));
                tempList.clear();
            }

        }

        return retval;

    }
}
