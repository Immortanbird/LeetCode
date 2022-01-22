/*
* Given a string s containing an out-of-order English representation of digits 0-9, return the digits in ascending order.
* All letters the digits include: 'e','f','g','h','i','n','o','r','s','t','u','v','w','x','z'.
* */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String originalDigits(String s) {
        String[] word = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int[] priority = {0, 8, 6, 3, 2, 7, 5, 9, 4, 1};

        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> hash = new HashMap<>();

        for (char c : s.toCharArray())
            hash.put(c, hash.getOrDefault(c, 0) + 1);

        for (int num : priority) {
            int freq = Integer.MAX_VALUE;
            for (char c : word[num].toCharArray())
                freq = Math.min(freq, hash.getOrDefault(c, 0));
            if (freq == 0)
                continue;
            for (char c : word[num].toCharArray())
                hash.put(c, hash.get(c) - freq);
            while (freq-- != 0)
                sb.append(num);
        }

        char[] res = sb.toString().toCharArray();
        Arrays.sort(res);

        return String.valueOf(res);
    }
}
