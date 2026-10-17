class Solution {
    private List<List<String>> finalList = new ArrayList<>();
    private ArrayList<String> current = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(0, s);
        return finalList;
    }
    public void backtrack(int start, String s) {
        if (start == s.length()) {
            finalList.add(new ArrayList<>(current));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s.substring(start, end + 1))) {
                current.add(s.substring(start, end + 1));
                backtrack(end + 1, s);
                current.removeLast();
            }
        }
    }

    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }
}
