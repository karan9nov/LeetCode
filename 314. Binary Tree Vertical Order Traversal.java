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
    public List<List<Integer>> verticalOrder(TreeNode root) {

		List<List<Integer>> retval = new ArrayList<>();
		if (root == null)
			return retval;

		int max = 0;
		int min = 0;

		Queue<TreeNode> nodeQ = new LinkedList<>();
		Queue<Integer> colQ = new LinkedList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();

		nodeQ.offer(root);
		colQ.offer(0);

		while (!nodeQ.isEmpty()) {
			TreeNode node = nodeQ.poll();
			int col = colQ.poll();

			if (!map.containsKey(col))
				map.put(col, new ArrayList<>());
            
			map.get(col).add(node.val);

			if (node.left != null) {
				nodeQ.offer(node.left);
				colQ.offer(col - 1);
				min = Math.min(min, col - 1);
			}

			if (node.right != null) {
				nodeQ.offer(node.right);
				colQ.offer(col + 1);
				max = Math.max(max, col + 1);
            }
		}

		for (int i = min; i <= max; i++)
			retval.add(map.get(i));
		
		return retval;
	}
}