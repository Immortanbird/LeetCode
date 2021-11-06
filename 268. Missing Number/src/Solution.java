/*
* Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
* */
/*
* 开长度为n+1的数组哈希，或者原地哈希，但是原地哈希慢
* */
import java.util.Arrays;

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i=0; i<nums.length; i++)
            if (i != nums[i])
                return i;

        return nums.length;
    }
}
