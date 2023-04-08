class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        HashMap<Node, Node> visited = new HashMap<>();
        Node newNode = new Node(node.val);
        visited.put(node, newNode);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            List<Node> newNeighbors = visited.get(cur).neighbors;
            for (Node n : cur.neighbors) {
                if (!visited.containsKey(n)) {
                    visited.put(n, new Node(n.val));
                    queue.offer(n);
                }
                newNeighbors.add(visited.get(n));
            }
        }

        return newNode;
    }
}
