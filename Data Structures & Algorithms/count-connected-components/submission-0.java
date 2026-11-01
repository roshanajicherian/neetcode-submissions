class Solution {
    public int countComponents(int n, int[][] edges) {
        int connectedComponents = 0;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                connectedComponents++;
                performDFS(adjList, visited, i);
            }
        }
        return connectedComponents;
    }

    public void performDFS(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int node) {
        visited[node] = true;
        for (int x : adjList.get(node)) {
            if (!visited[x]) {
                performDFS(adjList, visited, x);
            }
        }
    }
}
