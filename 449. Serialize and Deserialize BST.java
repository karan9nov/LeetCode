/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) return "";

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                list.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                list.add(null);
            }
        }

        int i = list.size() - 1;
        while(list.get(i) == null) {
            list.remove(i);
            i--;
        }

        StringBuilder sb = new StringBuilder();
        for (Integer x: list) {
            sb.append(x + ",");
        }

        // System.out.println(sb.substring(0, sb.length() - 1).toString());

        return sb.substring(0, sb.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null || data.length() == 0)
            return null;

        String[] arr = data.split(",");

        if (arr.length == 0)
            return null;

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);

        int i = 1;

        while (!q.isEmpty()) {

            TreeNode temp = q.poll();
            if (temp != null) {

                if (i < arr.length && !arr[i].equals("null")) {
                    // System.out.println(arr[i]);
                    temp.left = new TreeNode(Integer.parseInt(arr[i]));
                    q.offer(temp.left);
                }

                if (i+1 < arr.length && !arr[i+1].equals("null")) {
                    // System.out.println(arr[i+1]);
                    temp.right = new TreeNode(Integer.parseInt(arr[i+1]));
                    q.offer(temp.right);
                }
                i+=2;
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
