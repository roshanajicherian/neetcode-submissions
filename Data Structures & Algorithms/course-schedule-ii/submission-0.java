class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[numCourses];
        int[] topo = new int[numCourses];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adjList.add(new ArrayList<>());
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preReq = prerequisites[i][1];
            adjList.get(preReq).add(course);
            indegree[course]++;
        }
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                queue.offer(i);
        int k = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo[k++] = node;
            for (Integer x : adjList.get(node)) {
                indegree[x]--;
                if (indegree[x] == 0)
                    queue.offer(x);
            }
        }
        if (k == numCourses)
            return topo;
        return new int[0];
    }
}
