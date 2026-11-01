class DisjointSet {
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findParent(int u) {
        if (u == parent.get(u)) {
            return u;
        }
        int ulp = findParent(parent.get(u));
        parent.set(u, ulp);
        return parent.get(u);
    }

    public boolean union(int u, int v) {
        int up_u = findParent(u);
        int up_v = findParent(v);
        if (up_u == up_v) {
            // cycle exists
            return false;
        }
        int rank_u = rank.get(up_u);
        int rank_v = rank.get(up_v);
        if (rank_u < rank_v) {
            parent.set(up_u, up_v);
        } else if (rank_v < rank_u) {
            parent.set(up_v, up_u);
        } else {
            parent.set(up_v, up_u);
            int rankTemp = rank.get(up_u);
            rank.set(up_u, ++rankTemp);
        }
        return true;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet ds = new DisjointSet(edges.length);
        int[] res = new int[2];
        for (int[] edge : edges) {
            if (!ds.union(edge[0], edge[1])) {
                res[0] = edge[0];
                res[1] = edge[1];
            }
        }
        return res;
    }
}
