/*
* Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
*
* A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public void backtrack(List<String> list, String digits, int index, StringBuilder sb, String[] map) {
        if (sb.length() < digits.length()) {
            for (int i=0; i<map[digits.charAt(index) - '2'].length(); i++) {
                sb.append(map[digits.charAt(index) - '2'].charAt(i));
                backtrack(list, digits, index + 1, sb, map);
                sb.deleteCharAt(index);
            }
        }
        else
            list.add(sb.toString());
    }

    public List<String> letterCombinations(String digits) {
        String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> list = new ArrayList<>();

        if (digits.isBlank())
            return null;

        backtrack(list, digits, 0, new StringBuilder(), map);

        return list;
    }
}