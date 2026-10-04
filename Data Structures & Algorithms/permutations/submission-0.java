class Solution {
    private List<List<Integer>> finalList = new ArrayList<>();
    private List<Integer> currentList = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> numsList =
            Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
        backtrack(numsList, nums.length);
        return finalList;
    }

    public void backtrack(ArrayList<Integer> remainingElts, int size) {
        if (currentList.size() == size) {
            finalList.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = 0; i < remainingElts.size(); i++) {
            int temp = remainingElts.remove(i);
            currentList.add(temp);
            backtrack(remainingElts, size);
            currentList.removeLast();
            remainingElts.add(i, temp);
        }
    }
}
