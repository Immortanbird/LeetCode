/*
* Given a 0-indexed integer array nums of size n, find the maximum difference between nums[i] and nums[j] (i.e., nums[j] - nums[i]), such that 0 <= i < j < n and nums[i] < nums[j].
*
* Return the maximum difference. If no such i and j exists, return -1.
* */

class Solution {
    public int maximumDifference(int[] nums) {
        int ans = 0;

        for (int i=0; i<nums.length; i++)
            for (int j=i+1; j<nums.length; j++)
                ans = Math.max(nums[j] - nums[i], ans);

        return ans == 0 ? -1 : ans;
    }
}