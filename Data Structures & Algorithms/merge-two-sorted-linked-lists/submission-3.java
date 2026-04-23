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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                current.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;

        // PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // while(list1 != null) {
        //     minHeap.add(list1.val);
        //     list1 = list1.next;
        // }

        // while(list2 != null) {
        //     minHeap.add(list2.val);
        //     list2 = list2.next;
        // }

        // if (minHeap.size() == 0) return null;

        // ListNode current = new ListNode(minHeap.poll());
        // ListNode res = new ListNode(0, current); 
        
        // while(minHeap.size() > 0) {
        //     current.next = new ListNode(minHeap.poll());
        //     current = current.next;
        // }

        // return res.next;
    }
}