class MinStack {
    Node top;

    public static class Node {
        int data;
        Node next;
        int minTillNow;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.minTillNow = -1;
        }
    }
    public MinStack() {
        top = null;
    }

    public void push(int val) {
        Node n = new Node(val);
        if (top != null)
            n.minTillNow = Math.min(n.data, top.minTillNow);
        else
            n.minTillNow = n.data;
        n.next = top;
        top = n;
    }

    public void pop() {
        top = top.next;
    }

    public int top() {
        return top.data;
    }

    public int getMin() {
        return top.minTillNow;
    }
}
