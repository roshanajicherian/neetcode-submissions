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
        HashMap<Node, Node> randomVisited = new HashMap<>();
        Node newHead = null;
        Node prev = null;
        Node itr = head;
        Node currentNode;
        while (itr != null) {
            if (randomVisited.containsKey(itr)) {
                currentNode = randomVisited.get(itr);
            } else {
                currentNode = new Node(itr.val);
                randomVisited.put(itr, currentNode);
            }
            if (itr.random != null) {
                if (randomVisited.containsKey(itr.random)) {
                    currentNode.random = randomVisited.get(itr.random);
                } else {
                    Node newRandom = new Node(itr.random.val);
                    currentNode.random = newRandom;
                    randomVisited.put(itr.random, newRandom);
                }
            }
            if (prev != null)
                prev.next = currentNode;
            else
                newHead = currentNode;
            prev = currentNode;
            itr = itr.next;
        }
        return newHead;
    }
}
