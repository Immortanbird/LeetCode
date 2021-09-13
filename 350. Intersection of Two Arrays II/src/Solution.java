/*
* Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
* */

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length)
            return intersect(nums2, nums1);

        HashMap<Integer, Integer> hashmap = new HashMap<>();

        int[] res = new int[nums1.length];
        int index = 0;

        for (int x : nums1) {
            if (hashmap.containsKey(x))
                hashmap.replace(x, hashmap.get(x) + 1);
            else
                hashmap.put(x, 1);
        }

        for (int x : nums2) {
            if (hashmap.containsKey(x) && hashmap.get(x) > 0) {
                res[index++] = x;
                hashmap.replace(x, hashmap.get(x) - 1);
            }
        }

        return Arrays.copyOf(res, index);
    }
}
