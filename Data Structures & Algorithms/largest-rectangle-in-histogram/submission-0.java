class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] rightBoundary = new int[n];
        int[] leftBoundary = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                rightBoundary[st.pop()] = i - 1;
            }
            st.push(i);
        }
        while (!st.isEmpty())
            rightBoundary[st.pop()] = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                leftBoundary[st.pop()] = i + 1;
            }
            st.push(i);
        }
        while (!st.isEmpty())
            leftBoundary[st.pop()] = 0;
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (rightBoundary[i] - leftBoundary[i] + 1));
        }
        return maxArea;
    }
}
