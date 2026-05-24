class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> slidingWindowMax = new ArrayDeque<>();
        ArrayList<Integer> maxes = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int incoming = nums[i];
            while (!slidingWindowMax.isEmpty() && incoming > nums[slidingWindowMax.peekLast()]) {
                slidingWindowMax.pollLast();
            }
            slidingWindowMax.offerLast(i);
        }
        maxes.add(nums[slidingWindowMax.peekFirst()]);
        int l = 1;
        while (!slidingWindowMax.isEmpty() && l > slidingWindowMax.peekFirst())
            slidingWindowMax.pollFirst();
        int r = k;
        while (r < nums.length) {
            int incoming = nums[r];
            while (!slidingWindowMax.isEmpty() && incoming > nums[slidingWindowMax.peekLast()]) {
                slidingWindowMax.pollLast();
            }
            slidingWindowMax.offerLast(r);
            maxes.add(nums[slidingWindowMax.peekFirst()]);
            l++;
            while (!slidingWindowMax.isEmpty() && l > slidingWindowMax.peekFirst())
                slidingWindowMax.pollFirst();
            r++;
        }
        return maxes.stream().mapToInt(i -> i).toArray();
    }
}
