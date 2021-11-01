/*
* Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.
*
* In the American keyboard:
*       the first row consists of the characters "qwertyuiop",
*       the second row consists of the characters "asdfghjkl",
*       the third row consists of the characters "zxcvbnm".
* */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String[] findWords(String[] words) {
        int[] hash = {2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};
        List<String> res = new ArrayList<>();

        for (String s : words) {
            String temp = s.toLowerCase();
            int flag = hash[temp.charAt(0) - 'a'];

            for (int i=1; i<temp.length(); i++) {
                if (hash[temp.charAt(i) - 'a'] != flag) {
                    flag = 0;
                    break;
                }
            }

            if (flag != 0)
                res.add(s);
        }

        return res.toArray(new String[0]);
    }
}
