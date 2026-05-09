class Solution {
    public int trap(int[] height) {
                int totalArea = 0;
        int n = height.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        int prefixM = 0;
        int suffixM = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] > prefixM) {
                prefixM = height[i];
            }
            if (height[n - i - 1] > suffixM) {
                suffixM = height[n - i - 1];
            }
            prefixMax[i] = prefixM;
            suffixMax[n - i - 1] = suffixM;
        }
        for (int i = 0; i < height.length; i++) {
            totalArea += Math.min(prefixMax[i], suffixMax[i]) - height[i];
        }
        return totalArea;
    }
}
