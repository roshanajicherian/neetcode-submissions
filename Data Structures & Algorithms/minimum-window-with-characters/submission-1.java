class Solution {
    public String minWindow(String s, String t) {
        int[] windowFreq = new int[128];
        int[] tFreq = new int[128];
        int[] sFreq = new int[128];
        int smallestLength = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int finalR = 0, finalL = 0;
        for (int i = 0; i < t.length(); i++)
            tFreq[t.charAt(i)]++;
        for (int i = 0; i < s.length(); i++)
            sFreq[s.charAt(i)]++;
        for (int i = 0; i < 128; i++) {
            if (tFreq[i] > sFreq[i])
                return "";
        }
        for (int i = 0; i < s.length(); i++) {
            if (tFreq[s.charAt(i)] > 0) {
                l = i;
                r = i;
                break;
            }
        }
        boolean everythingFound = false;
        while (r < s.length()) {
            if (!everythingFound)
                windowFreq[s.charAt(r)]++;
            if (tFreq[s.charAt(r)] > 0) {
                everythingFound = true;
                for (int i = 0; i < windowFreq.length; i++) {
                    if (tFreq[i] > windowFreq[i]) {
                        everythingFound = false;
                        break;
                    }
                }
            }
            if (everythingFound) {
                if (r - l + 1 < smallestLength) {
                    smallestLength = r - l + 1;
                    finalR = r;
                    finalL = l;
                }
                windowFreq[s.charAt(l)]--;
                l++;
            } else
                r++;
        }
        return s.substring(finalL, finalR + 1);
    }
}
