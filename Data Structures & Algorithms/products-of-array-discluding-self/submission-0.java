class Solution {
    public int[] productExceptSelf(int[] nums) {
                int[] res = new int[nums.length];
        int[] prefixProduct = new int[nums.length];
        int[] suffixProduct = new int[nums.length];
        Arrays.fill(prefixProduct, 1);
        Arrays.fill(suffixProduct, 1);
        int p = 1, s = 1;
        for (int i = 0; i < nums.length; i++) {
            prefixProduct[i] *= (p * nums[i]);
            suffixProduct[nums.length - i - 1] *= (s * nums[nums.length - i - 1]);
            p = prefixProduct[i];
            s = suffixProduct[nums.length - i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            int prefix = (i - 1 >= 0) ? prefixProduct[i - 1] : 1;
            int suffix = (i + 1 <= nums.length - 1) ? suffixProduct[i + 1] : 1;
            res[i] = prefix * suffix;
        }
        return res;
    }
}  
