class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l = 0, r = s1.length() - 1, n = s2.length();
        int[] originalFreq = new int[26];
        int[] windowFreq = new int[26];
        for (char c : s1.toCharArray()) {
            originalFreq[c - 'a']++;
        }
        for (int i = 0; i < r; i++)
            windowFreq[s2.charAt(i) - 'a']++;
        while (r < n) {
            windowFreq[s2.charAt(r) - 'a']++;
            boolean allMatch = true;
            for (int i = 0; i < 26; i++) {
                if (windowFreq[i] > originalFreq[i]) {
                    allMatch = false;
                    windowFreq[s2.charAt(l) - 'a']--;
                    l++;
                    r++;
                    break;
                }
            }
            if (allMatch)
                return true;
        }
        return false;
    }
}
