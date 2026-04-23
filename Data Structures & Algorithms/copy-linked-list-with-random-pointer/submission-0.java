/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> copyByOriginal = new HashMap<>();
        Node current = head;
        
        while(current != null) {
            copyByOriginal.put(current, new Node(current.val));
            current = current.next;
        }

        Node newList = new Node(0);
        current = newList;
        
        while(head != null) {
            Node copy = copyByOriginal.get(head);
            copy.next = copyByOriginal.get(head.next);
            copy.random = copyByOriginal.get(head.random);
            current.next = copy;

            head = head.next;
            current = current.next;
        }

        return newList.next;


    }
}
