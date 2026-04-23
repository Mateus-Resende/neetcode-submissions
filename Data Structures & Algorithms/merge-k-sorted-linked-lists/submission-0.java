/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;

        if (k == 0) return null;

        if (k == 1) return lists[0];

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(k, (n1, n2) -> Integer.compare(n1.val, n2.val));
        for (int i = 0; i < k; i++) {
            minHeap.add(lists[i]);
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(!minHeap.isEmpty()) {

            ListNode node = minHeap.poll();

            current.next = node;
            current = current.next;

            if (node.next != null) {
                minHeap.add(node.next); 
            }
        }

        return dummy.next;
    }
}
