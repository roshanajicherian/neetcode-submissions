class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        char[] sArray = s.toCharArray();
        boolean[] occurrenceNew = new boolean[128];
        int i = 0, j = 0;
        while (j < sArray.length) {
            if (occurrenceNew[sArray[j]]) {
                while (occurrenceNew[sArray[j]]) {
                    occurrenceNew[sArray[i]] = false;
                    i++;
                }
            } else {
                occurrenceNew[sArray[j]] = true;
                maxLength = Math.max(maxLength, j - i + 1);
                j++;
            }
        }
        return maxLength;
    }
}
