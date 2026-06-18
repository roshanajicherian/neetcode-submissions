class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int minTillNow = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= nums[l]) {
                minTillNow = Math.min(minTillNow, nums[l]);
                l = mid + 1;
            } else {
                minTillNow = Math.min(minTillNow, nums[mid]);
                r = mid - 1;
            }
        }
        return minTillNow;
    }
}
