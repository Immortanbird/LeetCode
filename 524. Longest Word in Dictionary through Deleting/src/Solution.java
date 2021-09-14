/*
* Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed by deleting some of the given string characters. If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
* */
import java.util.List;

class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";

        for (String temp : dictionary) {
            int index1 = 0;
            int index2 = 0;

            while (index1 < s.length() && index2 < temp.length()) {
                if (s.charAt(index1) == temp.charAt(index2))
                    index2++;
                index1++;
            }

            if (index2 == temp.length()) {
                if (res.equals("") || res.length() < temp.length() || (res.length() == temp.length() && temp.compareTo(res) < 0))
                    res = temp;
            }
        }

        return res;
    }
}