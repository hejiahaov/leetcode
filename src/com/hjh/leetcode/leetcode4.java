package com.hjh.leetcode;

/**
 * @author hejiahao
 * @version 1.0
 * @date 2019/10/17 16:56
 * @projct_name leetcode
 */
public class leetcode4 {
    /**
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     *
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     *
     * 你可以假设 nums1 和 nums2 不会同时为空。
     *
     * 示例 1:
     *
     * nums1 = [1, 3]
     * nums2 = [2]
     *
     * 则中位数是 2.0
     * 示例 2:
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     *
     * 则中位数是 (2 + 3)/2 = 2.5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int[] arr = new int[nums1.length+nums2.length];
        //先将两个数组排序成一个
        while (i != nums1.length || j != nums2.length){
            if(i == nums1.length){
                arr[i+j] = nums2[j];
                j++;
                continue;
            }
            if(j == nums2.length){
                arr[i+j] = nums1[i];
                i++;
                continue;
            }
            if(nums1[i] < nums2[j]){
                arr[i+j] = nums1[i];
                i++;
            }else {
                arr[i+j] = nums2[j];
                j++;
            }
        }
        //取中位数
        double mid;
        if(arr.length%2 == 0){
            mid = (Double.sum(arr[arr.length/2 -1],arr[arr.length/2]))/2;
        }else {
            mid = arr[arr.length/2];
        }
        return mid;
    }

    public static void main(String[] args) {
       int[] nums1 = {1, 2, 6};
       int[] nums2 = {3, 4};
       leetcode4 l = new leetcode4();
       l.findMedianSortedArrays(nums1,nums2);
    }

    //大神解题思路
    public double findMedianSortedArrays1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            return findMedianSortedArrays(B,A); // 保证 m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && B[j-1] > A[i]){ // i 需要增大
                iMin = i + 1;
            }
            else if (i != 0 && j != n && A[i-1] > B[j]) { // i 需要减小
                iMax = i - 1;
            }
            else { // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; } // 奇数的话不需要考虑右半部分

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
            }
        }
        return 0.0;
    }
}
