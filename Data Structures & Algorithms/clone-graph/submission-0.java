/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Deque<Node> queue = new ArrayDeque<>();
        Map<Integer, Node> map = new HashMap<>();

        queue.add(node);

        while(queue.size() > 0) {
            Node current = queue.poll();
            if (!map.containsKey(current.val)) {
                map.put(current.val, new Node(current.val));
            }

            List<Node> neighbors = new ArrayList<>();

            for (Node neighbor : current.neighbors) {
                if (!map.containsKey(neighbor.val)) {
                    map.put(neighbor.val, new Node(neighbor.val));
                    queue.add(neighbor);     
                }
                
                neighbors.add(map.get(neighbor.val));
            }

            map.get(current.val).neighbors = neighbors;
        }

        return map.get(node.val);
    }
}