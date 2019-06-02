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

    Map<Integer, Integer> map;
    int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            for (int j = 0; j < inorder.length; j++) {
                if (preorder[i] == inorder[j]) {
                    map.put(i, j);
                    break;
                }
            }
        }

        System.out.println(map);

        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int inorderStart, int inorderEnd) {

        if (inorderStart > inorderEnd || preorderIndex >= preorder.length)
            return null;

        TreeNode root = new TreeNode(preorder[preorderIndex]);

        int temp = preorderIndex;

        preorderIndex++;
        root.left = buildTree(preorder, inorder, inorderStart, map.get(temp) - 1);
        if (root.left == null) preorderIndex--;

        preorderIndex++;
        root.right = buildTree(preorder, inorder, map.get(temp) + 1, inorderEnd);
        if (root.right == null) preorderIndex--;

        return root;

    }
}
