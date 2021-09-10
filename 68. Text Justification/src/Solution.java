/*
* Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

* You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

* Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

* For the last line of text, it should be left-justified and no extra space is inserted between words.

* Note:
*    A word is defined as a character sequence consisting of non-space characters only.
*    Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
*    The input array words contains at least one word.
* */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> res = new ArrayList<>();

        int len = words.length;
        int width = 0;
        String s = "";

        for (int i=0; i<len; i++) {
            if (maxWidth - width > words[i].length()) {
                s += words[i] + " ";
                width += words[i].length() + 1;
            }
        }

        return res;
    }
}