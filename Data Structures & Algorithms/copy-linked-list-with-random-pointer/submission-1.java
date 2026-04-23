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
        copyByOriginal.put(null, null);

        Node current = head;
        while(current != null) {
            copyByOriginal.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;
        
        while(current != null) {
            Node copy = copyByOriginal.get(current);
            copy.next = copyByOriginal.get(current.next);
            copy.random = copyByOriginal.get(current.random);
            current = current.next;
        }

        return copyByOriginal.get(head);


    }
}
