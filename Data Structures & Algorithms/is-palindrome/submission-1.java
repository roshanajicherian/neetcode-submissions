class Solution {
    public boolean isPalindrome(String s) {
                StringBuilder buf = new StringBuilder();
        s = s.toLowerCase();
        for (char c : s.toLowerCase().toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                buf.append(c);
            }
        }
        String alphaNumemricString = buf.toString();
        int l = 0;
        int r = alphaNumemricString.length() - 1;
        while (l < r) {
            if (alphaNumemricString.toCharArray()[l] != alphaNumemricString.toCharArray()[r])
                return false;
            l++;
            r--;
        }
        return true;
    }
}
