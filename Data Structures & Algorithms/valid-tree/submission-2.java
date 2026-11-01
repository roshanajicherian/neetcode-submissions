class Solution {
    public boolean validTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        if (hasCycle(adjList, visited, 0, -1))
            return false;
        for (boolean b : visited)
            if (!b)
                return false;
        return true;
    }

    public boolean hasCycle(
        ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int node, int prevNode) {
        visited[node] = true;
        for (int x : adjList.get(node)) {
            if (x == prevNode)
                continue;
            if (!visited[x]) {
                if (hasCycle(adjList, visited, x, node))
                    return true;
            } else
                return true;
        }
        return false;
    }
}
