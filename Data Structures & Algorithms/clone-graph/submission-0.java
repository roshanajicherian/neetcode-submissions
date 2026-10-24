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
        if (node == null)
            return null;
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        dfs(node, nodeMap);
        return nodeMap.get(node.val);
    }
    public void dfs(Node node, HashMap<Integer, Node> nodeMap) {
        Node currentNode;
        if (nodeMap.containsKey(node.val)) {
            currentNode = nodeMap.get(node.val);
        } else {
            currentNode = new Node(node.val);
            nodeMap.put(node.val, currentNode);
        }
        List<Node> newNeighbours = new ArrayList<>();
        for (Node n : node.neighbors) {
            if (!nodeMap.containsKey(n.val))
                dfs(n, nodeMap);
            newNeighbours.add(nodeMap.get(n.val));
        }
        currentNode.neighbors = newNeighbours;
    }
}