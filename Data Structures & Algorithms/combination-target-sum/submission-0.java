class Solution {
    private ArrayList<Integer> current = new ArrayList<>();
    private List<List<Integer>> finalList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(target, 0, nums);
        return finalList;
    }

    public void backtrack(int rem, int i, int[] nums) {
        if (rem == 0) {
            finalList.add(new ArrayList<>(current));
            return;
        }
        if (i >= nums.length || rem < 0)
            return;

        current.add(nums[i]);
        backtrack(rem - nums[i], i, nums);

        current.removeLast();
        backtrack(rem, ++i, nums);
    }
}
