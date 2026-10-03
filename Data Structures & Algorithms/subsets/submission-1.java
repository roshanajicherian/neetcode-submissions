class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private ArrayList<Integer> current = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        subsetHelper(0, nums);
        return res;
    }

    public void subsetHelper(int i, int[] nums) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[i]);
        subsetHelper(i + 1, nums);

        current.removeLast();
        subsetHelper(i + 1, nums);
    }
}
