/*
* A peak element is an element that is strictly greater than its neighbors.
* Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

* You may imagine that nums[-1] = nums[n] = -∞.
* You must write an algorithm that runs in O(log n) time.
* */
/*爬坡*/
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (right > left) {
            int i = (left + right) / 2;
            if (nums[i] > nums[i + 1])
                right = i;
            else
                left = i + 1;
        }

        return left;
    }
}