class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i : nums) {
            if (freq.containsKey(i)) {
                return true;
            } else {
                freq.put(i, 1);
            }
        }
        return false;
    }
}