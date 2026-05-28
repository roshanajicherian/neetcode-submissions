class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int i = 0, n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        while (i < n) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peekFirst()]) {
                res[st.peekFirst()] = i - st.peekFirst();
                st.pop();
            }
            st.push(i);
            i++;
        }
        return res;
    }
}
