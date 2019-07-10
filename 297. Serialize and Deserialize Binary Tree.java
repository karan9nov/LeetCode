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

        if (root == null)
            return "[]";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<String> retval = new ArrayList<>();

        while (!queue.isEmpty()) {

            TreeNode temp = queue.poll();
            if (temp != null) {
                retval.add(temp.val+"");
                queue.add(temp.left);
                queue.add(temp.right);
            } else {
                retval.add("null");
            }
        }

        while(retval.get(retval.size() - 1).equals("null")) {
            retval.remove(retval.size() - 1);
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < retval.size(); i++) {
            sb.append(retval.get(i));
            if (i != retval.size() - 1)
                sb.append(",");
            else
                sb.append("]");
        }

        // System.out.println(sb);

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        data = data.substring(1, data.length() - 1);
        if (data.length() == 0)
            return null;
        String[] arr = data.split(",");

        TreeNode retval = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(retval);
        int i = 0;

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            if (node != null) {

                if (2*i+1 < arr.length && !arr[2*i+1].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(arr[2*i+1]));
                    queue.add(node.left);
                } else {
                    queue.offer(null);
                }

                if (2*i+2 < arr.length && !arr[2*i+2].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(arr[2*i+2]));
                    queue.add(node.right);
                } else {
                    queue.offer(null);
                }
                i+=1;
            }
        }

        return retval;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
