/*
* Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
* A subarray is a contiguous part of an array.
* */

public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];

        for (int num : nums) {
            sum = Math.max(sum + num, num);
            max = Math.max(sum, max);
        }

        return max;
    }
}
