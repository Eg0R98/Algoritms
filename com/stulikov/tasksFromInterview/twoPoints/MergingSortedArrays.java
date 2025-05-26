package com.stulikov.tasksFromInterview.twoPoints;

public class MergingSortedArrays {
    public static void main(String[] args) {
        merge(new int[]{5, 6, 7, 0, 0, 0}, 3, new int[]{2, 4, 8}, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }
}
