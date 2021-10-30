/*
* Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
* */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums.length == 2)
            return nums;

        Map<Integer, Integer> hashmap = new HashMap<>();

        for (int x : nums)
            hashmap.put(x, hashmap.getOrDefault(x, 0) + 1);

        int[] res = new int[2];
        int i=0;

        for (int x : nums)
            if (hashmap.get(x) == 1)
                res[i++] = x;

        return res;
    }
}