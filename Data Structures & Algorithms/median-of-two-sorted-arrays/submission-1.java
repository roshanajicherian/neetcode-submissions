class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int l = 0, r = nums1.length;
        int totalElements = nums1.length + nums2.length;
        while (l <= r) {
            int mid1 = (l + r) / 2;
            int mid2 = (totalElements + 1) / 2 - mid1;
            int l1 = mid1 - 1 >= 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = mid2 - 1 >= 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = mid1 < nums1.length ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < nums2.length ? nums2[mid2] : Integer.MAX_VALUE;
            if (l2 <= r1 && l1 <= r2) {
                if (totalElements % 2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                else
                    return Math.max(l1, l2);
            }
            if (l2 > r1)
                l = mid1 + 1;
            else
                r = mid1 - 1;
        }
        return 0;
    }
}
