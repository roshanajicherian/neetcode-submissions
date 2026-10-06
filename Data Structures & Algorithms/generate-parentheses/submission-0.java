class Solution {
    private List<String> finalList = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, n, "");
        return finalList;
    }
    public void backtrack(int leftCount, int rightCount, String current) {
        if (leftCount == 0 && rightCount == 0) {
            finalList.add(current);
            return;
        }
        if (leftCount > 0) {
            backtrack(leftCount - 1, rightCount, current + "(");
        }
        if (rightCount > 0 && leftCount < rightCount) {
            backtrack(leftCount, rightCount - 1, current + ")");
        }
    }
}
