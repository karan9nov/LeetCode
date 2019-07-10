/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        
		if (root == null) return root;
		
		Queue<Node> nodeQ = new LinkedList<>();
		nodeQ.offer(root);
		nodeQ.offer(null);
		
		while(!nodeQ.isEmpty()) {
            
			Node node = nodeQ.poll();
			if (node != null) {
                node.next = nodeQ.peek();
                
				if (node.left != null) 
					nodeQ.offer(node.left);
				
				if (node.right != null)
					nodeQ.offer(node.right);
                
                if (node.next == null)
					nodeQ.offer(null);
			}
		}
		
		return root;
    }
}