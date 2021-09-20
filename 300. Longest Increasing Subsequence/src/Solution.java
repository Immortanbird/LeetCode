/*
* Given an integer array nums, return the length of the longest strictly increasing subsequence.
* A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
* */

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(s.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i=1; i < nums.length; i++) {
            int temp = 1;
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i])
                    temp = Math.max(temp, dp[j]);
            }
            dp[i] = temp + 1;
        }

        Arrays.sort(dp);
        return dp[nums.length - 1];
    }
}