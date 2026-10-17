class Solution {
    private List<String> finalList = new ArrayList<>();
    private String[] PHONE_MAP = {
        "", // 0
        "", // 1
        "abc", // 2
        "def", // 3
        "ghi", // 4
        "jkl", // 5
        "mno", // 6
        "pqrs", // 7
        "tuv", // 8
        "wxyz" // 9
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return finalList;
        }
        backtrack(0, digits, new StringBuilder());
        return finalList;
    }
    public void backtrack(int currentPointer, String digits, StringBuilder current) {
        if (currentPointer == digits.length()) {
            finalList.add(current.toString());
            return;
        }
        int digit = digits.charAt(currentPointer) - '0';
        String letters = PHONE_MAP[digit];
        for (int letterPointer = 0; letterPointer < letters.length(); letterPointer++) {
            current.append(letters.charAt(letterPointer));
            backtrack(currentPointer + 1, digits, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
