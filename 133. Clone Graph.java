/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
   public Node cloneGraph (Node root) {

		Set<Integer> visited = new HashSet<>();
		Map<Integer, Node> map = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(root);
		
		Node retval = new Node(root.val, new ArrayList<>());
		map.put(root.val, retval);
		
		while(!queue.isEmpty()) {
			Node tempNode = queue.poll();
			if(!visited.contains(tempNode.val)) {
				visited.add(tempNode.val);
				for (Node listNode: tempNode.neighbors) {
					queue.add(listNode);
					if (!map.containsKey(listNode.val)) 
						map.put(listNode.val, new Node(listNode.val, new ArrayList<>()));
					map.get(tempNode.val).neighbors.add(map.get(listNode.val));
				}
			}
		}
		return retval;
	} 
}