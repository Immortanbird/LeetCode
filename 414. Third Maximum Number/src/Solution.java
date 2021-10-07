/*
* Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
* */

import java.util.Arrays;

public class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);

        int res = nums[nums.length - 1];
        int rd = 2;
        for (int i=nums.length-2; i>=0 && rd>0; i--) {
            if (nums[i] < res) {
                res = nums[i];
                rd --;
            }
        }

        return rd > 0 ? nums[nums.length - 1] : res;
    }
}