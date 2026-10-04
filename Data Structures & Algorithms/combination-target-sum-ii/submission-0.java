class Solution {
    
    private List<List<Integer>> finalList = new ArrayList<>();
    private List<Integer> current = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(target, 0, candidates);
        return finalList;
    }

    public void backtrack(int rem, int start, int[] nums) {
        if (rem == 0) {
            finalList.add(new ArrayList<>(current));
            return;
        }
        if (rem < 0 || start >= nums.length)
            return;
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            current.add(nums[i]);
            backtrack(rem - nums[i], i + 1, nums);
            current.removeLast();
        }
    }
}
