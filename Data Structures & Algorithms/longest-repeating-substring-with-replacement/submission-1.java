class Solution {
    public int characterReplacement(String s, int k) {
     int maxLength = 0;
        char[] sArray = s.toCharArray();
        int n = s.length();
        int l = 0, r = 0;
        int[] freq = new int[26];
        freq[sArray[0] - 'A']++;
        int maxOccuringCount = 0;
        while (l < n) {
            for (int i = 0; i < 26; i++) {
                maxOccuringCount = Math.max(maxOccuringCount, freq[i]);
            }
            if ((r - l + 1) - maxOccuringCount <= k) {
                maxLength = Math.max(maxLength, r - l + 1);
                r++;
                if (r == n)
                    break;
                freq[sArray[r] - 'A']++;
            } else {
                freq[sArray[l] - 'A']--;
                l++;
            }
        }
        return maxLength;
    }
}
