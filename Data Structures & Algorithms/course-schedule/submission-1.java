class Solution {
    public boolean canFinish(int numCourse, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourse];
        boolean[] pathVisited = new boolean[numCourse];

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourse; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < prerequisites.length; i++)
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);

        for (int i = 0; i < numCourse; i++) {
            if (!visited[i]) {
                if (performDFS(visited, pathVisited, adjList, i))
                    return false;
            }
        }
        return true;
    }

    public boolean performDFS(
        boolean[] visited, boolean[] pathVisited, ArrayList<ArrayList<Integer>> adjList, int node) {
        visited[node] = true;
        pathVisited[node] = true;
        for (Integer n : adjList.get(node)) {
            if (!visited[n]) {
                if (performDFS(visited, pathVisited, adjList, n))
                    return true;
            } else if (pathVisited[n])
                return true;
        }
        pathVisited[node] = false;
        return false;
    }
}
