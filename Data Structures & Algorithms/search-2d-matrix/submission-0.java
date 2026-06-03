class Solution {
    public static boolean binarySearch(int[] nums, int low, int high, int target) {
        if (low > high)
            return false;
        int mid = (low + high) / 2;
        if (nums[mid] == target)
            return true;
        else if (target > nums[mid])
            return binarySearch(nums, mid + 1, high, target);
        return binarySearch(nums, low, mid - 1, target);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int rowLow = 0, rowHigh = n - 1;
        while (rowLow <= rowHigh && rowLow >= 0 && rowHigh <= n - 1) {
            int rowMid = (rowLow + rowHigh) / 2;
            if (target >= matrix[rowMid][0] && target <= matrix[rowMid][m - 1]) {
                if (target == matrix[rowMid][0] || target == matrix[rowMid][m - 1])
                    return true;
                return binarySearch(matrix[rowMid], 0, m - 1, target);
            } else if (target > matrix[rowMid][m - 1])
                rowLow = rowMid + 1;
            else if (target < matrix[rowMid][0])
                rowHigh = rowMid - 1;
        }
        return false;
    }
}
