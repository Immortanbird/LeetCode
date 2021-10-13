/*
* The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
* Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.
* */

import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> sub = new HashMap<>();

        for (int i=0; i<s.length() - 9; i++) {
            String temp = s.substring(i, i + 10);
            sub.put(temp, sub.getOrDefault(temp, 0) + 1);
        }

        Set<Map.Entry<String, Integer>> keys = sub.entrySet();

        for (Map.Entry<String, Integer> x : keys) {
            if (x.getValue() > 1)
                ans.add(x.getKey());
        }

        return ans;
    }
}
