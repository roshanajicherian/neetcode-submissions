class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> slidingWindowMax = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int resIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!slidingWindowMax.isEmpty() && slidingWindowMax.peekFirst() < i - k + 1) {
                slidingWindowMax.pollFirst();
            }
            while (!slidingWindowMax.isEmpty() && nums[i] > nums[slidingWindowMax.peekLast()]) {
                slidingWindowMax.pollLast();
            }
            slidingWindowMax.offerLast(i);
            if (i >= k - 1) {
                result[resIndex++] = nums[slidingWindowMax.peekFirst()];
            }
        }
        return result;
    }
}
