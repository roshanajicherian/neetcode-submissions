class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]]; // incrementing fast by 2 and slow by one to find out the
                                     // intersection point
        } while (slow != fast); // found out a cycle. not the actual repeated element

        // mathematical proof involved in why newSlow and slow intersection is the repeating element
        int newSlow = 0;
        while (true) {
            newSlow = nums[newSlow];
            slow = nums[slow];
            if (slow == newSlow)
                return slow;
        }
    }
}
