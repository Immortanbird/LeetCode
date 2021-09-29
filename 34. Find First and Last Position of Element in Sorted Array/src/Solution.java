/*
* Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
* If target is not found in the array, return [-1, -1].
* You must write an algorithm with O(log n) runtime complexity.
* */
/*他妈的，二分查找一生之敌*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};

        if (nums.length == 0)
            return res;

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] >= target)
                right = mid;
            else
                left = mid + 1;
        }

        if (nums[left] != target)
            return res;

        res[0] = left;

        right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2 + 1;

            if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid;
        }

        res[1] = left;

        return res;
    }
}