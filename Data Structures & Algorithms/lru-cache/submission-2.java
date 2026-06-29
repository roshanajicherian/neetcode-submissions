class LRUCache {
    public static class DLLNode {
        public int key;
        public int val;
        public DLLNode left;
        public DLLNode right;

        DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final DLLNode front;
    private final DLLNode rear;
    private final HashMap<Integer, DLLNode> cache;
    private final int maxCapacity;
    private int size;

    public LRUCache(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        cache = new HashMap<>();
        front = new DLLNode(-1, -1);
        rear = new DLLNode(-1, -1);
        front.left = rear;
        rear.right = front;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DLLNode toRemove = cache.get(key);
            toRemove.left.right = toRemove.right;
            toRemove.right.left = toRemove.left;
            cache.remove(key);
            size--;
        }
        insert(key, value);
        if (size > maxCapacity) {
            DLLNode toRemove = rear.right;
            rear.right = toRemove.right;
            toRemove.right.left = rear;
            cache.remove(toRemove.key);
            size--;
        }
    }

    public int get(int key) {
        int res = -1;
        if (cache.containsKey(key)) {
            DLLNode currentNode = cache.get(key);
            res = currentNode.val;
            currentNode.left.right = currentNode.right;
            currentNode.right.left = currentNode.left;
            currentNode.left = front.left;
            currentNode.right = front;
            front.left.right = currentNode;
            front.left = currentNode;
        }
        return res;
    }

    private void insert(int key, int value) {
        DLLNode newNode = new DLLNode(key, value);
        front.left.right = newNode;
        newNode.left = front.left;
        newNode.right = front;
        front.left = newNode;
        cache.put(key, newNode);
        size++;
    }
}
