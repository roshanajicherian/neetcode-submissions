class Solution {
    private List<List<Integer>> finalList = new ArrayList<>();
    private ArrayList<Integer> currentList = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return finalList;
    }

    public void backtrack(int[] nums, int start) {
        finalList.add(new ArrayList<>(currentList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            currentList.add(nums[i]);
            backtrack(nums, i + 1);
            currentList.removeLast();
        }
    }
}
