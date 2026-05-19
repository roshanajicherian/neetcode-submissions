class Solution {
    public int characterReplacement(String s, int k) {
     int maxLength = 0;
        char[] sArray = s.toCharArray();
        int n = s.length();
        int l = 0, r = 0;
        int[] freq = new int[26];
        int maxOccuringCount = 0;
        while (r < n) {
            freq[sArray[r] - 'A']++;
            maxOccuringCount = Math.max(maxOccuringCount, freq[sArray[r] - 'A']);
            while ((r - l + 1) - maxOccuringCount > k) {
                freq[sArray[l] - 'A']--;
                l++;
                for (int i = 0; i < 26; i++) {
                    maxOccuringCount = Math.max(maxOccuringCount, freq[i]);
                }
            }
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        return maxLength;
    }
}
