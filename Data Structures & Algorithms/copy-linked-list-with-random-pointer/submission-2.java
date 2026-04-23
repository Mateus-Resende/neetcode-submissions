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
            if (!copyByOriginal.containsKey(current)) {
                copyByOriginal.put(current, new Node(0));
            }
            copyByOriginal.get(current).val = current.val;

            if (!copyByOriginal.containsKey(current.next)) {
                copyByOriginal.put(current.next, new Node(0));
            }
            copyByOriginal.get(current).next = copyByOriginal.get(current.next);

            if (!copyByOriginal.containsKey(current.random)) {
                copyByOriginal.put(current.random, new Node(0));
            }
            copyByOriginal.get(current).random = copyByOriginal.get(current.random);
            current = current.next;
        }

        return copyByOriginal.get(head);
    }
}
