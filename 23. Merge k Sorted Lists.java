class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0) return null;

        ListNode retval = new ListNode(0);
        ListNode retvalCurrentNode = retval;

        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        };

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(comparator);

        for (ListNode listNode: lists) {
            if (listNode != null)
                minHeap.add(listNode);
        }

        while(!minHeap.isEmpty()) {
            ListNode temp = minHeap.poll();
            if (temp.next != null) {
                minHeap.add(temp.next);
            }
            retvalCurrentNode.next = new ListNode(temp.val);
            retvalCurrentNode = retvalCurrentNode.next;
        }

        return retval.next;
    }
}
