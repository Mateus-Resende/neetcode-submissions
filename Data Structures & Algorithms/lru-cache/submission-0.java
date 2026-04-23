public class Node {
    int key, val;
    Node next, previous;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.previous = null;
    }
}

class LRUCache {
    private int capacity;
    private Map<Integer, Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.cache = new HashMap<>();
        this.left.next = right;
        this.right.previous = left;
    }

    private void remove(Node node) {
        Node prev = node.previous;
        Node nxt = node.next;

        prev.next = nxt;
        nxt.previous = prev;
    }

    private void insert(Node node) {
        Node previous = this.right.previous;
        previous.next = node;
        node.previous = previous;
        this.right.previous = node;
        node.next = this.right;
    }
    
    public int get(int key) {
        if (this.cache.containsKey(key)) {
            Node node = this.cache.get(key);
            remove(node);
            insert(node);

            return node.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            remove(this.cache.get(key));
        }
        
        Node newNode = new Node(key, value);
        insert(newNode);
        this.cache.put(key, newNode);
        
        if (this.cache.size() > this.capacity) {
            Node lru = this.left.next;
            this.cache.remove(lru.key);
            remove(lru);
        }
    }
}
