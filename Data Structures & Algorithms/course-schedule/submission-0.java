class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        int nodesCovered = 0;
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][1]]++;
        }
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            nodesCovered++;
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][0] == node) {
                    indegree[prerequisites[i][1]]--;
                    if (indegree[prerequisites[i][1]] == 0)
                        queue.offer(prerequisites[i][1]);
                }
            }
        }
        return nodesCovered == numCourses;
    }
}
