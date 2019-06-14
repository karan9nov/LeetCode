/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        
        Node retval = new Node(0, null, null);
        Node tempHead = head;
        Node tempRetval = retval;
        
        Map<Integer, Node> map = new HashMap<>();
        
        while (tempHead != null) {
            tempRetval.next = new Node(tempHead.val, null, null);
            map.put(tempHead.val, tempRetval.next);
            tempHead = tempHead.next;
            tempRetval = tempRetval.next;
        }
        
        tempHead = head;
        tempRetval = retval;
        
        while (tempHead != null) {
            if (tempHead.next == tempHead.random) {
                tempRetval.next.random = tempRetval.next.next;
            } else {
                if (tempHead.random != null) {
                    tempRetval.next.random = map.get(tempHead.random.val);
                }
            }
            tempHead = tempHead.next;
            tempRetval = tempRetval.next;
        }
        
        return retval.next;
    }
}